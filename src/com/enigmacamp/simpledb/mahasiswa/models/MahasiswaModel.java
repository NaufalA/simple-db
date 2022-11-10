package com.enigmacamp.simpledb.mahasiswa.models;

public class MahasiswaModel {
    public String nama;
    public Integer umur;
    public String jurusan;

    public MahasiswaModel() {}

    public MahasiswaModel(String nama, Integer umur, String jurusan) {
        this.nama = nama;
        this.umur = umur;
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "Nama    : " + nama + "\n" +
                "Umur    : " + umur + "\n" +
                "Jurusan : " + jurusan + "\n";
    }
}
