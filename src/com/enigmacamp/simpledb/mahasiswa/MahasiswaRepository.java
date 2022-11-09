package com.enigmacamp.simpledb.mahasiswa;

import com.enigmacamp.simpledb.mahasiswa.models.MahasiswaModel;
import com.enigmacamp.simpledb.shared.classes.RepositoryBase;

public class MahasiswaRepository  extends RepositoryBase<MahasiswaModel> {
    public MahasiswaRepository(Integer maxSize) {
        super(maxSize);
    }
}
