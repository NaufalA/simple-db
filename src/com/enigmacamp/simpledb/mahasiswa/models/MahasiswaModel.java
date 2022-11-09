package com.enigmacamp.simpledb.mahasiswa.models;

public class MahasiswaModel {
    public String nama;
    public Integer umur;
    public String jurusan;

    @Override
    public String toString() {
        return "Nama    : " + nama + "\n" +
               "Umur    : " + umur + "\n" +
               "Jurusan : " + jurusan + "\n";
    }
}
