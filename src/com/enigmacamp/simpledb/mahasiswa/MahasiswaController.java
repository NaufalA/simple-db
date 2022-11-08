package com.enigmacamp.simpledb.mahasiswa;

import com.enigmacamp.simpledb.mahasiswa.models.MahasiswaModel;
import com.enigmacamp.simpledb.shared.classes.ControllerBase;
import com.enigmacamp.simpledb.shared.utils.InputValidator;

import java.util.Scanner;

public class MahasiswaController extends ControllerBase<MahasiswaModel> {
    public MahasiswaController(MahasiswaService mahasiswaService, String dbName) {
        super(mahasiswaService, dbName);
    }

    @Override
    public void createItem() {
        super.createItem();
        Scanner scanner = new Scanner(System.in);
        MahasiswaModel newMhs = new MahasiswaModel();
        System.out.print("Nama (3-20 Karakter)       : ");
        newMhs.nama = scanner.nextLine();
        System.out.print("Umur (min 17 Tahun)        : ");
        newMhs.umur = InputValidator.handleIntegerInput(scanner, true);
        System.out.print("Jurusan (maks 10 Karakter) : ");
        newMhs.jurusan = scanner.nextLine();
        try {
            service.createItem(newMhs);
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    @Override
    public void deleteItem() {
        super.deleteItem();
        try {
            MahasiswaModel deletedMhs = service.removeItem(service.getDataCount() - 1);
            System.out.println("Mahasiswa yang terakhir masuk didelete");
            printItem(deletedMhs);
            System.out.println("\n--------------------------------------\n");
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    @Override
    public void viewItem() {
        super.viewItem();
        Scanner scanner = new Scanner(System.in);
        int choice = InputValidator.handleIntegerInput(scanner, false);
        handleViewMenuInput(choice, scanner);
    }

    @Override
    public void printItem(MahasiswaModel item) {
        System.out.printf("Nama    : %s\n", item.nama);
        System.out.printf("Umur    : %d\n", item.umur);
        System.out.printf("Jurusan : %s\n", item.jurusan);
    }
}
