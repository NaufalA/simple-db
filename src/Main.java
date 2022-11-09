import com.enigmacamp.simpledb.mahasiswa.MahasiswaController;
import com.enigmacamp.simpledb.mahasiswa.MahasiswaRepository;
import com.enigmacamp.simpledb.mahasiswa.MahasiswaService;
import com.enigmacamp.simpledb.shared.utils.InputValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MahasiswaRepository mahasiswaRepository = new MahasiswaRepository();
        MahasiswaService mahasiswaService = new MahasiswaService(mahasiswaRepository, 5);
        MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaService, scanner, "Mahasiswa");

        int choice = 0;
        while (choice != 4) {
            mahasiswaController.printMenu();
            choice = mahasiswaController.handleMenuInput(InputValidator.handleIntegerInput(scanner, true));
        }
    }
}