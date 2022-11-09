package com.enigmacamp.simpledb.mahasiswa;

import com.enigmacamp.simpledb.mahasiswa.models.MahasiswaModel;
import com.enigmacamp.simpledb.shared.classes.ControllerBase;
import com.enigmacamp.simpledb.shared.utils.InputValidator;

import java.util.Scanner;

public class MahasiswaController extends ControllerBase<MahasiswaModel> {
    public MahasiswaController(MahasiswaService mahasiswaService, Scanner scanner, String dbName) {
        super(mahasiswaService, scanner, dbName);
    }

    @Override
    public void createItemMenu() {
        super.createItemMenu();
        boolean dataInvalid;
        do {
            MahasiswaModel newMhs = new MahasiswaModel();
            System.out.print("Nama (3-20 Karakter)       : ");
            newMhs.nama = scanner.nextLine();
            System.out.print("Umur (min 17 Tahun)        : ");
            newMhs.umur = InputValidator.handleIntegerInput(scanner, false);
            System.out.print("Jurusan (maks 10 Karakter) : ");
            newMhs.jurusan = scanner.nextLine();
            try {
                service.createItem(newMhs);
                dataInvalid = false;
            } catch (Exception e) {
                System.out.println("\n" + e.getMessage());
                dataInvalid = true;
            }
        } while (dataInvalid);
    }

    @Override
    public void deleteItemMenu() {
        super.deleteItemMenu();
        try {
            MahasiswaModel deletedMhs = service.removeItem(service.getDataCount() - 1);
            System.out.println("Mahasiswa yang terakhir masuk didelete");
            System.out.println(deletedMhs);
            System.out.println("\n--------------------------------------\n");
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    @Override
    public void viewItemMenu() {
        Boolean inputInvalid;
        do {
            super.viewItemMenu();
            int choice = InputValidator.handleIntegerInput(scanner, true);
            inputInvalid = handleViewMenuInput(choice);
        } while (inputInvalid);
    }
}
