package com.enigmacamp.simpledb.mahasiswa;

import com.enigmacamp.simpledb.mahasiswa.models.MahasiswaModel;
import com.enigmacamp.simpledb.shared.classes.ServiceBase;

public class MahasiswaService extends ServiceBase<MahasiswaModel> {
    public MahasiswaService(MahasiswaRepository mahasiswaRepository, int storageSize) {
        super(mahasiswaRepository, storageSize);
    }

    @Override
    public MahasiswaModel createItem(MahasiswaModel newItem) throws Exception {
        if (newItem.nama.length() < 3 || newItem.nama.length() > 20) {
            throw new Exception("Nama Mahasiswa tidak valid!");
        }
        if (newItem.umur < 17) {
            throw new Exception("Umur Mahasiswa tidak valid!");
        }
        if (newItem.jurusan.length() > 10) {
            throw new Exception("Jurusan Mahasiswa tidak valid!");
        }
        return super.createItem(newItem);
    }
}
