package com.enigmacamp.simpledb.mahasiswa;

import com.enigmacamp.simpledb.mahasiswa.models.MahasiswaModel;
import com.enigmacamp.simpledb.shared.classes.ServiceBase;
import com.enigmacamp.simpledb.shared.exceptions.CapacityLimitException;
import com.enigmacamp.simpledb.shared.exceptions.InvalidDataException;
import com.enigmacamp.simpledb.shared.validation.Validation;

public class MahasiswaService extends ServiceBase<MahasiswaModel> {
    private final Validation<String> nameValidation = (n) -> n.length() > 3 && n.length() <= 20;
    private final Validation<Integer> ageValidation = (a) -> a >= 17;
    private final Validation<String> majorValidation = (m) -> m.length() <= 10;

    public MahasiswaService(MahasiswaRepository mahasiswaRepository) {
        super(mahasiswaRepository);
    }

    @Override
    public MahasiswaModel createItem(MahasiswaModel newItem) throws InvalidDataException, CapacityLimitException {
        if (!nameValidation.test(newItem.nama)) {
            throw new InvalidDataException("Nama Mahasiswa tidak valid!");
        }
        if (!ageValidation.test(newItem.umur)) {
            throw new InvalidDataException("Umur Mahasiswa tidak valid!");
        }
        if (!majorValidation.test(newItem.jurusan)) {
            throw new InvalidDataException("Jurusan Mahasiswa tidak valid!");
        }
        return super.createItem(newItem);
    }
}
