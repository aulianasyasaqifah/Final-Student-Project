package voting2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

public class Voting2 {

    public static record Pemilih(String nama, int pilihan) {
    }

    static class Node {
        Pemilih data;
        Node next;

        public Node(Pemilih data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CustomLinkedList {
        Node head;

        public void addNode(Pemilih data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        public Pemilih searchPemilihByName(String targetName) {
            Node temp = head;
            while (temp != null) {
                if (temp.data.nama().equalsIgnoreCase(targetName)) {
                    return temp.data;
                }
                temp = temp.next;
            }
            return null;
        }

        public Pemilih searchPemilihByPilihan(int targetPilihan) {
            Node temp = head;
            while (temp != null) {
                if (temp.data.pilihan() == targetPilihan) {
                    return temp.data;
                }
                temp = temp.next;
            }
            return null;
        }
    }

    static class CustomQueue {
        Node front, rear;

        public void enqueue(Pemilih data) {
            Node newNode = new Node(data);
            if (front == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        public Pemilih dequeue() {
            if (front == null) {
                return null;
            }
            Pemilih data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("Selamat Datang Di E-Voting App");
        System.out.println("==========================================");
        System.out.println("Daftar Kandidat: ");
        System.out.println("1. Kandidat A");
        System.out.println("2. Kandidat B");
        System.out.println("3. Kandidat C");
        System.out.println("4. Tidak Memilih");
        System.out.println("==========================================");
        System.out.println("  ");

        int totalSuaraTidakMemilih = 0;

        CustomLinkedList pemilihList = new CustomLinkedList();
        CustomQueue pemilihQueue = new CustomQueue();
        int[] suaraKandidat = new int[4]; // Indeks 0 tidak digunakan

        boolean votingSelesai = false;

        while (!votingSelesai) {
            System.out.println("Masukkan nama Anda: ");
            String nama = scanner.nextLine();

            if (nama.isEmpty()) {
                System.out.println("Nama tidak boleh kosong. Silakan isi kembali.");
                continue;
            }

            System.out.println("Masukkan pilihan Anda (1-4): ");
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka (1-4).");
                continue;
            }

            Pemilih pemilih = new Pemilih(nama, pilihan);
            pemilihList.addNode(pemilih);
            pemilihQueue.enqueue(pemilih);

            if (pilihan >= 1 && pilihan <= 3) {
                suaraKandidat[pilihan]++;
            } else if (pilihan == 4) {
                totalSuaraTidakMemilih++;
            } else if (pilihan == 0) {
                votingSelesai = true;
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        }

        // Menambahkan metode untuk menampilkan hasil pemilihan dalam urutan menurun
        displayVotingResultsDescending(suaraKandidat);

        System.out.println("==========================================");    
        System.out.println("\nRekaman Pemilih (Linked List):");
        System.out.println("==========================================");
        displayLinkedList(pemilihList);

        System.out.println("==========================================");
        System.out.println("\nCari Pemilih (Linked List):");
        System.out.println("==========================================");
        searchPemilih(pemilihList);

        System.out.println("==========================================");
        System.out.println("\nTerima kasih atas partisipasi Anda!");
        System.out.println("==========================================");
    }

    private static int pemilihListCount(CustomLinkedList list) {
        int count = 0;
        Node temp = list.head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private static void displayLinkedList(CustomLinkedList list) {
        Node temp = list.head;
        while (temp != null) {
            System.out.println("Nama: " + temp.data.nama() + ", Pilihan: " + temp.data.pilihan());
            temp = temp.next;
        }
    }

    private static void displayVotingResultsDescending(int[] suaraKandidat) {
        PriorityQueue<Integer> votePriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 1; i <= 3; i++) {
            votePriorityQueue.add(suaraKandidat[i]);
        }

        System.out.println("==========================================");
        System.out.println("Hasil Pemilihan Berdasarkan Peringkat:");
        System.out.println("==========================================");

        int peringkat = 1;
        while (!votePriorityQueue.isEmpty()) {
            int suara = votePriorityQueue.poll();
            char kandidat = (char) ('A' + Arrays.binarySearch(suaraKandidat, suara) - 1);
            System.out.println("Peringkat " + peringkat + ": Kandidat " + kandidat + " dengan " + suara + " suara");
            peringkat++;
        }
    }

    private static void searchPemilih(CustomLinkedList list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama untuk mencari pemilih (kosongkan jika tidak ingin mencari): ");
        String searchName = scanner.nextLine();
        if (!searchName.isEmpty()) {
            Pemilih foundPemilih = list.searchPemilihByName(searchName);
            if (foundPemilih != null) {
                System.out.println("Pemilih ditemukan: " + foundPemilih.nama() + ", Pilihan: " + foundPemilih.pilihan());
            } else {
                System.out.println("Pemilih dengan nama " + searchName + " tidak ditemukan.");
            }
        }
    }
}