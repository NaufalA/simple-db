package com.enigmacamp.simpledb.mahasiswa;

import com.enigmacamp.simpledb.mahasiswa.models.MahasiswaModel;
import com.enigmacamp.simpledb.shared.classes.FileRepositoryBase;
import com.enigmacamp.simpledb.shared.exceptions.EmptyDatabaseException;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MahasiswaFileRepository extends FileRepositoryBase<MahasiswaModel> {

    public MahasiswaFileRepository(String filePath, Integer maxSize) throws IOException {
        super(filePath, maxSize);
    }

    @Override
    public List<MahasiswaModel> getAll() {
        return readData().map(this::parseData).collect(Collectors.toList());
    }

    @Override
    public MahasiswaModel getOne(Integer index) {
        return parseData(readData().collect(Collectors.toList()).get(index));
    }

    @Override
    public MahasiswaModel delete(Integer index) throws Exception {
        List<String> data = readData().collect(Collectors.toList());
        if (data.isEmpty()) {
            throw new EmptyDatabaseException();
        }
        String deletedData = data.get(index);
        data.remove(deletedData);
        writeData(String.join("\n", data));
        return parseData(deletedData);
    }

    @Override
    protected MahasiswaModel parseData(String data) {
        String[] fields = data.split(",");
        return new MahasiswaModel(fields[0], Integer.valueOf(fields[1]), fields[2]);
    }
}
