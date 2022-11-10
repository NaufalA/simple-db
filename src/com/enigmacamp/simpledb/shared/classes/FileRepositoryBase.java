package com.enigmacamp.simpledb.shared.classes;

import com.enigmacamp.simpledb.shared.exceptions.CapacityLimitException;
import com.enigmacamp.simpledb.shared.interfaces.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FileRepositoryBase<T> implements Repository<T> {
    protected final Path filePath;
    protected final Integer maxSize;


    public FileRepositoryBase(String filePath, Integer maxSize) throws IOException {
        this.filePath = Paths.get(filePath);
        if (!Files.exists(this.filePath)) {
            Files.createFile(this.filePath);
            System.out.println("new file created at " + this.filePath.toAbsolutePath());
        }
        this.maxSize = maxSize;
    }

    protected Stream<String> readData() {
        try {
            return Files.lines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void writeData(String content) {
        try {
            Files.write(this.filePath, content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void insertData(String content) {
        try {
            Files.write(this.filePath, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T add(T newItem) throws Exception {
        if (readData().count() >= maxSize) {
            throw new CapacityLimitException();
        }
        List<String> data =
                Arrays.stream(newItem.getClass().getDeclaredFields()).map(field -> {
                    try {
                        return field.get(newItem).toString();
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
        String dataString = String.join(",", data) + "\n";
        insertData(dataString);
        return newItem;
    }

    @Override
    public Integer getSize() {
        return Long.valueOf(readData().count()).intValue();
    }

    protected abstract T parseData(String data);
}
