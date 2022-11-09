import com.enigmacamp.simpledb.mahasiswa.MahasiswaController;
import com.enigmacamp.simpledb.mahasiswa.MahasiswaRepository;
import com.enigmacamp.simpledb.mahasiswa.MahasiswaService;
import com.enigmacamp.simpledb.shared.utils.InputValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MahasiswaRepository mahasiswaRepository = new MahasiswaRepository(5);
        MahasiswaService mahasiswaService = new MahasiswaService(mahasiswaRepository);
        MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaService, scanner, "Mahasiswa");


        boolean shouldCloseApp = false;
        while (!shouldCloseApp) {
            System.out.println("\n--------------------------------------\n");
            System.out.println("MAIN MENU");
            System.out.println("\n--------------------------------------\n");
            System.out.println("1. MAHASISWA");
            System.out.println("0. EXIT");
            System.out.println("\n--------------------------------------\n");
            System.out.println("Pilih Database: ");
            Integer selection = InputValidator.handleIntegerInput(scanner, true);
            boolean shouldExit;
            switch (selection) {
                case 1:
                    shouldExit = false;
                    while (!shouldExit) {
                        shouldExit = mahasiswaController.run();
                    }
                    break;
                case 0:
                    shouldCloseApp = true;
                    break;
                default:
                    System.out.println("Menu tidak tersedia!");
                    break;
            }
        }
    }
}