
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Comparator;
import java.util.Scanner;

public class Laundrysimplejava {
    public static String[] usernames = new String[100];
    public static String[] passwords = new String[100];
    public static String[] userNames = new String[100];
    public static int userCount = 0;
    public static final String ADMIN_USERNAME = "Admin";
    public static final String ADMIN_PASSWORD = "Althaflaundry";
    public static List<String> keranjang = new ArrayList<>();
    public static List<Integer> hargaKeranjang = new ArrayList<>();
    public static List<Integer> jumlahKeranjang = new ArrayList<>();
    public static List<String> transactionHistory = new ArrayList<>();
    public static int totalEarningsToday = 0;
    

// Laman Login     
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);    
        while (true) {
            System.out.println("SELAMAT DATANG DI ALTHAF LAUNDRY");
            System.out.println("================================");
            System.out.println("| 1. Registrasi                |");
            System.out.println("| 2. Login sebagai User        |");
            System.out.println("| 3. Login sebagai Admin       |");
            System.out.println("| 4. Exit                      |");
            System.out.println("================================");
            System.out.print("  Pilih opsi : ");
            int choice = scanner.nextInt();

           switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    loginAdmin();
                    break;
                case 4:
                    System.out.println("Program selesai. Sampai jumpa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opsi yang dipilih tidak ada. Silahkan pilih kembali.");
            }
        }
    }
    
// setting registrasi
public static void registerUser() {
    Scanner scanner = new Scanner(System.in);
    if (userCount < usernames.length) {
        System.out.println("================================");
        String newUsername;
        do {
            System.out.print("  Masukkan username: ");
            newUsername = scanner.next();
        } while (isUsernameExists(newUsername));

        System.out.print("  Masukkan password: ");
        String password = scanner.next();
        System.out.print("  Masukkan nama (panggilan): ");
        String name = scanner.next();

        usernames[userCount] = newUsername;
        passwords[userCount] = password;
        userNames[userCount] = name;
        userCount++;

        System.out.println("  Registrasi berhasil!");
        System.out.println("================================");
    } else {
        System.out.println("  Kapasitas pengguna sudah penuh. Harap tunggu untuk beberapa saat.");
    }
}

    // Setting login sebagai user    
public static void loginUser() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("================================");    
    System.out.print("  Masukkan username: ");
    String username = scanner.next();
    boolean userFound = false;

    for (int i = 0; i < userCount; i++) {
        if (usernames[i].equals(username)) {
            userFound = true;
            System.out.print("  Masukkan password: ");
            String password = scanner.next();

            if (passwords[i].equals(password)) {
                System.out.println("  Login berhasil. Selamat datang, " + userNames[i] + "!");
                System.out.println("================================");
                userMenu();
                return;
            } else {
                System.out.println("  Password salah. Silakan coba lagi.");
                System.out.println("================================");
                loginUser();
            }
        }
    }

    if (!userFound) {
        System.out.println("  Username tidak ditemukan. Silakan coba lagi.");
        System.out.println("================================");
        loginUser();
    }
}

// Setting login sebagai admin    
public static void loginAdmin() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("================================");
    System.out.print("  Masukkan admin username: ");
    String username = scanner.next();
    System.out.print("  Masukkan admin password: ");
    String password = scanner.next();

    if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
        System.out.println("  Login berhasil. Selamat datang, " + username + "!");
        System.out.println("================================");
        adminMenu();
    } else {
        System.out.println("  login gagal. Silakan cek kembali username dan password anda.");
        System.out.println("================================");
        loginAdmin();
    }
   
}


    // menu user   
    public static void userMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("================================");
            System.out.println("|           Menu User          |");
            System.out.println("================================");
            System.out.println("| 1. Price List                |");
            System.out.println("| 2. Keranjang                 |");
            System.out.println("| 3. Checkout                  |");
            System.out.println("| 4. Petunjuk Penggunaan       |");
            System.out.println("| 5. Logout                    |");
            System.out.println("================================");
            System.out.print("  Pilih opsi : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    pricelist();
                    break;
                case 2:
                    lihatKeranjang();
                    break;
                case 3:
                    checkout();
                    break;
                case 4:
                    userGuide();
                    break;
                case 5:
                    System.out.println("Logout berhasil!");
                    logout();
                    return; 
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        }
    }

    
    // daftar cuci   
    public static void pricelist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=================================================");
        System.out.println("|              Pricelist Cuci Baju              |");
        System.out.println("=================================================");
        System.out.println("| 1.  Cuci Bed cover jumbo    : Rp 35.000/pcs   |");
        System.out.println("| 2.  Cuci Bed cover nomor 1  : Rp 28.000/pcs   |");
        System.out.println("| 3.  Cuci Bed cover nomor 2  : Rp 25.000/pcs   |");
        System.out.println("| 4.  Cuci Bed cover nomor 3  : Rp 20.000/pcs   |");
        System.out.println("| 5.  Cuci Sprei besar 1 set  : Rp 10.000/pcs   |");
        System.out.println("| 6.  Cuci Sprei sedang 1 set : Rp 8.000/pcs    |");
        System.out.println("| 7.  Cuci Sprei kecil 1 set  : Rp 6.000/pcs    |");
        System.out.println("| 8.  Cuci Handuk besar       : Rp 10.000/pcs   |");
        System.out.println("| 9.  Cuci Handuk sedang      : Rp 8.000/pcs    |");
        System.out.println("| 10. Cuci Handuk kecil       : Rp 6.000/pcs    |");
        System.out.println("| 11. Cuci Jaket tebal        : Rp 8.000/pcs    |");
        System.out.println("| 12. Cuci Jaket tipis        : Rp 6.000/pcs    |");
        System.out.println("| 13. Cuci Baju Biasa         : Rp 7.000/kilo   |");
        System.out.println("| 14. Cuci Baju Putih         : Rp 10.000/kilo  |");
        System.out.println("| 15. Setrika Baju            : Rp 3.500/kilo   |");
        System.out.println("| 16. Kembali                                   |");
        System.out.println("=================================================");
        System.out.print(" Pilih opsi : ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
        case 1:
            System.out.print(" Masukkan kuantitas: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            addToCart(" Cuci bed cover jumbo", 35000, quantity);
            pricelist();
            break;
        case 2:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            addToCart(" Cuci bed cover nomor 1", 28000, quantity);
            pricelist();
            break;
        case 3:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            addToCart(" Cuci bed cover nomor 2", 25000, quantity);
            pricelist();
            break;
         case 4:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            addToCart(" Cuci bed cover nomor 3", 20000, quantity);
            pricelist();
            break;
        case 5:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); 
            addToCart(" Cuci sprei besar 1 set", 10000, quantity);
            pricelist();
            break;
        case 6:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); 
            addToCart(" Cuci sprei sedang 1 set", 8000, quantity);
            pricelist();
            break;
         case 7:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); 
            addToCart(" Cuci sprei kecil 1 set", 6000, quantity);
            pricelist();
            break;
        case 8:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); 
            addToCart(" Cuci handuk besar", 10000, quantity);
            pricelist();
            break;
        case 9:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            addToCart(" Cuci handuk sedang", 8000, quantity);
            pricelist();
            break;
         case 10:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); 
            addToCart(" Cuci handuk kecil", 6000, quantity);
            pricelist();
            break;
        case 11:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine();
            addToCart(" Cuci jaket tebal", 8000, quantity);
            pricelist();
            break;
        case 12:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); 
            addToCart(" Cuci jaket tipis", 6000, quantity);
            pricelist();
            break;
         case 13:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); 
            addToCart(" Cuci baju biasa", 7000, quantity);
            pricelist();
            break;
         case 14:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); 
            addToCart(" Cuci baju putih", 10000, quantity);
            pricelist();
            break;
         case 15:
            System.out.print(" Masukkan kuantitas: ");
            quantity = scanner.nextInt();
            scanner.nextLine(); 
            addToCart(" Setrika baju", 3500, quantity);
            pricelist();
            break;
         case 16:
            userMenu();
            break;
        default:
            System.out.println(" Opsi tidak valid. Silakan pilih lagi.");
            pricelist();
            break;
        }
}

//tambah ke keranjang    
 public static void addToCart(String item, int harga, int quantity) {
        keranjang.add(item + " (" + quantity + ")");
        hargaKeranjang.add(harga * quantity);
        System.out.println("Item berhasil ditambahkan ke keranjang!");
    }   

//lihat keranjang
public static void lihatKeranjang() {
    System.out.println("================================");
    System.out.println("|           Keranjang          |");
    System.out.println("================================");
    
    if (keranjang.isEmpty()) {
        System.out.println("Keranjang Kosong");
    } else {
        int totalHarga = 0;
        for (int i = 0; i < keranjang.size(); i++) {
            System.out.println((i + 1) + ". " + keranjang.get(i) + " - Rp " + hargaKeranjang.get(i));
            totalHarga += hargaKeranjang.get(i);
        }
        System.out.println("================================");
        System.out.println(" Total Harga: Rp " + totalHarga);
    }
    System.out.println("================================");      
}

//opsi checkout
public static void checkout() {
        lihatKeranjang();
        System.out.print("Apakah Anda ingin checkout semuanya atau sebagian? (semua/sebagian): ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("semua")) {
            checkoutAll();
        } else if (choice.equalsIgnoreCase("sebagian")) {
            checkoutPartial();
        } else {
            System.out.println("Pilihan tidak valid. Pemesanan dibatalkan.");
            checkout();
        }
    }

//checkout semua item
public static void checkoutAll() {
        int totalHarga = hitungTotalHarga();
        System.out.println("Total Harga: Rp " + totalHarga);
        System.out.print("Masukkan nominal pembayaran: Rp ");
        Scanner scanner = new Scanner(System.in);
        int pembayaran = scanner.nextInt();
        int kembalian;
        if (pembayaran > totalHarga) {
            kembalian = pembayaran - totalHarga;
            System.out.println("Kembalian : Rp " + kembalian);
            displayReceipt(totalHarga, pembayaran);
            displayTotalEarningsToday();
            keranjang.clear();
            hargaKeranjang.clear();
            askForMore();
        } else if (pembayaran == totalHarga) {
            displayReceipt(totalHarga, pembayaran);
            keranjang.clear();
            hargaKeranjang.clear();
            askForMore();
        } else {
            System.out.println("Nominal pembayaran kurang. Transaksi dibatalkan.");
            checkoutAll();
        }
    }

//checkout sebagian item
public static void checkoutPartial() {
    Scanner scanner = new Scanner(System.in);
    lihatKeranjang();
    int totalHarga = hitungTotalHarga();
    System.out.println("Total Harga: Rp " + totalHarga);

    // Meminta pengguna memilih item untuk checkout
    System.out.println("Pilih item untuk check out (0 untuk kembali): ");

    for (int i = 0; i < keranjang.size(); i++) {
        System.out.println((i + 1) + ". " + keranjang.get(i));
    }

    System.out.println("Masukkan nomor item yang ingin di-check out (0 untuk kembali): ");

    // Menerima input nomor-nomor item yang akan di-checkout
    List<Integer> selectedItems = new ArrayList<>();
    int selectedItem;
    do {
        selectedItem = scanner.nextInt();
        if (selectedItem > 0 && selectedItem <= keranjang.size()) {
            selectedItems.add(selectedItem);
        } else if (selectedItem != 0) {
            System.out.println("Nomor item tidak valid.");
        }
    } while (selectedItem != 0);

    if (selectedItems.isEmpty()) {
        System.out.println("Kembali ke menu sebelumnya.");
    } else {
        // Membuat salinan keranjang asli untuk di-reset jika transaksi dibatalkan
        List<String> originalCart = new ArrayList<>(keranjang);
        List<Integer> originalPrices = new ArrayList<>(hargaKeranjang);

        // Menampilkan informasi item yang dipilih
        System.out.println("Item yang dipilih untuk checkout:");

        int totalHargaItem = 0;
        for (int selectedItemIndex : selectedItems) {
            String selectedCartItem = keranjang.get(selectedItemIndex - 1);
            int originalIndex = originalCart.indexOf(selectedCartItem);
            totalHargaItem += originalPrices.get(originalIndex);
            System.out.println(selectedCartItem + " - Rp " + originalPrices.get(originalIndex));
        }

        // Menampilkan total harga item yang dipilih
        System.out.println("Total Harga Item: Rp " + totalHargaItem);

        // Meminta pengguna memasukkan nominal pembayaran
        System.out.print("Masukkan nominal pembayaran: Rp ");
        int pembayaran = scanner.nextInt();
        scanner.nextLine();

        // Melakukan perhitungan kembalian jika pembayaran mencukupi
        if (pembayaran >= totalHargaItem) {
            int kembalian = pembayaran - totalHargaItem;
            System.out.println("Kembalian : Rp " + kembalian);
            displayReceipt(totalHargaItem, pembayaran);
            displayTotalEarningsToday();
            hapusItem(selectedItems);
            askForMore();
        } else {
            // Jika pembayaran kurang, membatalkan transaksi dan mengembalikan keranjang ke kondisi sebelum checkout
            System.out.println("Nominal pembayaran kurang. Transaksi dibatalkan .");
            keranjang = originalCart;
            hargaKeranjang = originalPrices;
            checkoutPartial();
        }
    }
}

public static void hapusItem(List<Integer> selectedItems) {
    // Urutkan item yang dipilih secara descending untuk menghindari masalah indeks
    selectedItems.sort(Comparator.reverseOrder());

    for (int selectedItemIndex : selectedItems) {
        keranjang.remove(selectedItemIndex - 1);
        hargaKeranjang.remove(selectedItemIndex - 1);
    }
}
//hitung total
public static int hitungTotalHarga() {
        int totalHarga = 0;
        for (int harga : hargaKeranjang) {
            totalHarga += harga;
        }
        return totalHarga;
    }

//struk pembayaran
public static void displayReceipt(int totalHarga, int pembayaran) {
   
        System.out.println("=====================================================");
        System.out.println("|              Struk Pembayaran                     |");
        System.out.println("=====================================================");        
        String noPesanan = generateUniqueOrderNumber();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String tanggalPesanan = dateFormat.format(new Date());
        System.out.println("  Nomor Pesanan      : " + noPesanan);
        System.out.println("  Nama Pemesan       : " + userNames[0]);
        System.out.println("  Tanggal Pesanan    : " + tanggalPesanan);
        System.out.println("  Total Harga        : Rp " + totalHarga);
        System.out.println("  Nominal Pembayaran : Rp "+ pembayaran);
        int kembalian ;
        if (pembayaran >= totalHarga) {
        kembalian = pembayaran - totalHarga;
        totalEarningsToday += totalHarga;
        System.out.println("  Kembalian          : Rp " + kembalian);
        System.out.println("=====================================================");
        // Menambahkan data transaksi ke riwayat
            transactionHistory.add("No Pesanan         : " + noPesanan);
            transactionHistory.add("Nama Pemesan       : " + userNames[0] );
            transactionHistory.add("Tanggal Pesanan    : " + tanggalPesanan);
            transactionHistory.add("Total Harga        : RP " + totalHarga );
            transactionHistory.add("Nominal Pembayaran : Rp " + pembayaran);
            transactionHistory.add("Kembalian          : Rp " + kembalian);
            transactionHistory.add("Admin              : "+ADMIN_USERNAME);
            transactionHistory.add("=============================================");
        } else {
            System.out.println("  Nominal pembayaran kurang. Silakan masukkan nominal yang mencukupi.");
            transactionHistory.add("No Pesanan   : " + noPesanan);
            transactionHistory.add("Nama Pemesan : " + userNames[0] );
            transactionHistory.add("Tanggal Pesanan : " + tanggalPesanan);
            transactionHistory.add("Total Harga : RP " + totalHarga );
            transactionHistory.add("Nominal Pembayaran : Rp " + pembayaran+", Nominal Pembayaran Kurang");
            transactionHistory.add("Admin              : "+ADMIN_USERNAME);
        }
       
    }

//layanan lain
public static void askForMore() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Apakah ada yang dibutuhkan lagi? (ya/tidak): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("ya")) {
            userMenu(); // Kembali ke menu user
        } else if (response.equalsIgnoreCase("tidak")) {
            System.out.println("Terima kasih telah menggunakan layanan kami.");
            System.out.println("==============================================");
            main(new String[] {});
            return;
        } else {
            System.out.println("Pilihan tidak valid.");
            askForMore();
            
        }
    }

//logout
public static void logout() {
    System.out.println("Logout berhasil!");
    main(new String[] {});
    return;
}

//menu admin
public static void adminMenu() {
        while (true) {
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("================================");
            System.out.println("|          Admin Menu          |");
            System.out.println("================================");
            System.out.println("| 1. Data Histori Transaksi    |");
            System.out.println("| 2. Pemasukan hari ini        |");
            System.out.println("| 3. Kelola User               |");
            System.out.println("| 4. Logout                    |");
            System.out.println("================================");
            System.out.print("  Pilih opsi : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewTransactionHistory();
                    break;
                case 2:
                    displayTotalEarningsToday();
                    break;
                case 3:
                    manageUsers();
                    break;
                case 4:
                    logout();
                    break;

                default:
                    System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        }
    }

//data histori transaksi
public static void viewTransactionHistory() {
        System.out.println("================================");
        System.out.println("|      Data Histori Transaksi   |");
        System.out.println("================================");

        if (transactionHistory.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
       }

//kelola user
public static void manageUsers() {
    Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("|               Kelola User             |");
        System.out.println("=========================================");
        System.out.println("| 1. Tambah pengguna                    |");
        System.out.println("| 2. Hapus pengguna                     |");
        System.out.println("| 3. Tampilkan pengguna yang terdaftar  |");
        System.out.println("| 4. Kembali                            |");
        System.out.println("=========================================");
        System.out.print("  Pilih opsi : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                deleteUser();
                break;
            case 3:
                displayRegisteredUsers();
                break;
            case 4:
                break;
            default:
                System.out.println("Opsi tidak valid. Silakan pilih lagi.");
                manageUsers();
        }
    }

//tambah user
 public static void addUser() {
     Scanner scanner = new Scanner(System.in);
        System.out.println("================================");
        System.out.println("|        Tambah pengguna       |");
        System.out.println("================================");

        if (userCount < usernames.length) {
            System.out.print("  Masukkan username baru : ");
            String newUsername = scanner.nextLine();

            // Check if the username already exists
            if (isUsernameExists(newUsername)) {
                System.out.println("  Username sudah digunakan. Silakan pilih yang lain.");
                System.out.println("================================");
                return;
            }

            System.out.print("  Masukkan password baru : ");
            String newPassword = scanner.nextLine();

            usernames[userCount] = newUsername;
            passwords[userCount] = newPassword;
            userCount++;

            System.out.println("  Tambah pengguna berhasil!");
            System.out.println("================================");
        } else {
            System.out.println("  Kapasitas pengguna penuh. Tidak dapat menambahkan pengguna baru.");
            System.out.println("================================");
        }
    }

// hapus user
public static void deleteUser() {
Scanner scanner = new Scanner(System.in);
    System.out.println("================================");
        System.out.println("|        Hapus Pengguna        |");
        System.out.println("================================");

        System.out.print("  Masukkan username yang ingin dihapus: ");
        String usernameToDelete = scanner.nextLine();

        int indexToDelete = findUserIndex(usernameToDelete);

        if (indexToDelete != -1) {
            // Shift the array elements to remove the user
            for (int i = indexToDelete; i < userCount - 1; i++) {
                usernames[i] = usernames[i + 1];
                passwords[i] = passwords[i + 1];
            }

            // Clear the last element
            usernames[userCount - 1] = null;
            passwords[userCount - 1] = null;

            userCount--;

            System.out.println("  Hapus pengguna berhasil!");
            System.out.println("================================");
        } else {
            System.out.println("  Pengguna tidak ditemukan. Silakan periksa ulang username.");
            System.out.println("================================");
            deleteUser();
        }
    }

//opsi tampilkan user yang terdaftar
public static void displayRegisteredUsers() {
    System.out.println("================================");
    System.out.println("|       User Terdaftar         |");
    System.out.println("================================");

    if (userCount == 0) {
        System.out.println("Tidak ada pengguna terdaftar.");
    } else {
        for (int i = 0; i < userCount; i++) {
            System.out.println((i + 1) + ". Username: " + usernames[i] + " - Nama: " + userNames[i]);
        }
    }

    System.out.println("================================");
}

    public static boolean isUsernameExists(String username) {
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static int findUserIndex(String username) {
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username)) {
                return i;
            }
        }
        return -1; // Return -1 if the username is not found
    }
    
//mendapatkan nomor pesanan    
public static String generateUniqueOrderNumber() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date());    
} 

//petunjuk penggunaan
public static void userGuide() {
    System.out.println("=====================================================================");
    System.out.println("|                        Petunjuk Penggunaan                        |");
    System.out.println("| 1. Pilih menu Price List untuk melihat daftar harga cuci.         |");
    System.out.println("| 2. Pilih menu Keranjang untuk melihat barang yang sudah dipilih.  |");
    System.out.println("| 3. Pilih menu Checkout untuk melakukan pembayaran.                |");
    System.out.println("| 4. Pilih menu Logout untuk keluar dari akun.                      |");
    System.out.println("=====================================================================");

}

public static void displayTotalEarningsToday() {
    System.out.println("=========================================");
    System.out.println("|         Pemasukan Hari Ini           |");
    System.out.println("=========================================");
    System.out.println("  Total Pemasukan Hari Ini: Rp " + totalEarningsToday);
    System.out.println("=========================================");
}

}