package ProjectUAS;

import java.util.Scanner;
import java.util.*;
import java.text.*;

public class appToko {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar now = Calendar.getInstance();
        //data barang yang dijual
        cBarang brg1 = new cBarang("Coffe Caramel", 10000);
        cBarang brg2 = new cBarang("Coffe Good Day", 6000);
        cBarang brg3 = new cBarang("Ice Red velvet", 10000);
        cBarang brg4 = new cBarang("Kentang Goreng", 7000);
        cBarang brg5 = new cBarang("Mie instan", 6000);

        //data member toko
        int id1 = 2201, pw1 = 111;
        int id2 = 2202, pw2 = 222;
        int id3 = 2203, pw3 = 333;
        int id, pw;
        
        Date hari = new Date( );
        SimpleDateFormat m = new SimpleDateFormat ("MM");        
        SimpleDateFormat d = new SimpleDateFormat ("dd");
        String idTrans = (m.format(hari)+d.format(hari));
        //daftar antrian transaksi yang masuk ke toko
        cDaftarTransaksi jual = new cDaftarTransaksi();
        int pilih = 0, pilih2 = 0, pilih3 = 0;
        int kode = 1, jumlah=0;
        
        
        do {
            System.out.println("\n----- APLIKASI -----\nWARKOP DUDUK BERSAMA");
            System.out.println("\n1. Pembeli");
            System.out.println("2. Anggota");
            System.out.println("3. Admin");
            System.out.println("4. Pemilik");
            System.out.println("5. Exit");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    //Pembeli
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    System.out.print("Masukkan Nama : ");
                    String nama = sc.next();

                    do {
                        System.out.println("\n--- AKUN PEMBELI ---");
                        System.out.println("1. Tambah");
                        System.out.println("2. Hapus");
                        System.out.println("3. Lihat");
                        System.out.println("4. Keluar");
                        System.out.print("Pilih : ");
                        pilih2 = sc.nextInt();
                        switch (pilih2) {
                            case 1:
                                do{
                                    cTransaksi br = null;
                                    System.out.println("\n  Daftar Barang\n-----------------");
                                    System.out.print("1. "+brg1.getNama()+"\tHarga  : ");
                                    System.out.printf("%,d\n",brg1.getHarga());
                                    System.out.print("2. "+brg2.getNama()+"\tHarga  :  ");
                                    System.out.printf("%,d\n",brg2.getHarga());
                                    System.out.print("3. "+brg3.getNama()+"\tHarga  : ");
                                    System.out.printf("%,d\n",brg3.getHarga());
                                    System.out.print("4. "+brg4.getNama()+"\tHarga  :  ");
                                    System.out.printf("%,d\n",brg4.getHarga());
                                    System.out.print("5. "+brg5.getNama()+"\t\tHarga  :  ");
                                    System.out.printf("%,d\n",brg5.getHarga());
                                    System.out.println("6. Keluar");
                                    System.out.print("Pilih  : ");
                                    pilih3 = sc.nextInt();
                                    if(pilih3 < 6){
                                        System.out.print("Jumlah : ");
                                        jumlah = sc.nextInt();
                                    }else{ 
                                        
                                    }
                                    String kodes = idTrans+0+String.valueOf(kode);
                                    switch (pilih3){
                                        case 1 :
                                            br = new cTransaksi(kodes, nama, brg1, jumlah, 0);
                                            beli.tambahTransaksi(br);
                                            kode++;
                                            break;
                                        case 2 :
                                            br = new cTransaksi(kodes, nama, brg2, jumlah, 0);
                                            beli.tambahTransaksi(br);
                                            kode++;
                                            break;
                                        case 3 :
                                            br = new cTransaksi(kodes, nama, brg3, jumlah, 0);
                                            beli.tambahTransaksi(br);
                                            kode++;
                                            break;
                                        case 4 :
                                            br = new cTransaksi(kodes, nama, brg4, jumlah, 0);
                                            beli.tambahTransaksi(br);
                                            kode++;
                                            break;
                                        case 5 :
                                            br = new cTransaksi(kodes, nama, brg5, jumlah, 0);
                                            beli.tambahTransaksi(br);
                                            kode++;
                                            break;
                                        case 6 :
                                            break;
                                    }
                                    if(pilih3 > 6){
                                        System.out.println("\n==== PILIHAN TIDAK TERSEDIA ===="); 
                                    }
                                }while(pilih3 >6);
                                break;
                            case 2:
                                int a = beli.lihatTransaksi();
                                if(a == 1){
                                    System.out.println("     ===== Data Masih Kosong =====");
                                }else{
                                    System.out.print("Hapus nomor : ");
                                    int hapus = sc.nextInt();
                                    beli.hapusTransaksi(hapus);
                                }
                                kode--;
                                break;
                            case 3:
                                beli.lihatTransaksi();
                                break;
                            case 4:
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("\nSelamat datang kembali ...");
                                break;
                        }
                        if(pilih2 > 4){
                            System.out.println("\n==== PILIHAN TIDAK TERSEDIA ===="); 
                        }
                    } while (pilih2 != 4);
                    break;

                case 2://Anggota
                    boolean valid = false;
                    int pilihM;
                    do {
                        System.out.print("ID       : ");
                        id = sc.nextInt();
                        System.out.print("Password : ");
                        pw = sc.nextInt();
                        if (id == id1 && pw == pw1) {
                            valid = true;
                        } else if (id == id2 && pw == pw2) {
                            valid = true;
                        } else if (id == id3 && pw == pw3) {
                            valid = true;
                        }
                        if (valid == false) {
                            System.out.println("ID / PASSWORD SALAH");
                            do{
                                System.out.println("\n1. Masuk lagi\n2. Keluar");
                                System.out.print("Pilih : ");
                                pilihM = sc.nextInt();
                                System.out.println("");
                                if(pilihM == 1){
                                }else{
                                    break;
                                }
                                if(pilih3 > 2){
                                    System.out.println("\n==== PILIHAN TIDAK TERSEDIA ===="); 
                                }
                            }while(pilihM > 2);
                        } else {
                            break;
                        }
                    } while (valid == false);
                    if (valid == true) {
                        System.out.println("\n---- WELCOME MEMBER ----");
                        String kodes = idTrans+0+String.valueOf(kode);
                        beli = new cDaftarTransaksi();
                        do {
                            System.out.println("\n--- AKUN MEMBER ---");
                            System.out.println("1. Tambah");
                            System.out.println("2. Hapus");
                            System.out.println("3. Lihat");
                            System.out.println("4. Ubah Password");
                            System.out.println("5. Keluar");
                            System.out.print("Pilih : ");
                            pilih2 = sc.nextInt();
                            switch (pilih2) {
                                case 1:
                                    do{
                                        cTransaksi br = null;
                                        System.out.println("\n  Daftar Barang\n-----------------");
                                        System.out.print("1. "+brg1.getNama()+"\tHarga  : ");
                                        System.out.printf("%,d\n",brg1.getHarga());
                                        System.out.print("2. "+brg2.getNama()+"\tHarga  :  ");
                                        System.out.printf("%,d\n",brg2.getHarga());
                                        System.out.print("3. "+brg3.getNama()+"\tHarga  : ");
                                        System.out.printf("%,d\n",brg3.getHarga());
                                        System.out.print("4. "+brg4.getNama()+"\tHarga  :  ");
                                        System.out.printf("%,d\n",brg4.getHarga());
                                        System.out.print("5. "+brg5.getNama()+"\t\tHarga  :  ");
                                        System.out.printf("%,d\n",brg5.getHarga());
                                        System.out.println("6. Keluar");
                                        System.out.print("Pilih  : ");
                                        pilih3 = sc.nextInt();
                                        if(pilih3 < 6){
                                            System.out.print("Jumlah : ");
                                            jumlah = sc.nextInt();
                                        }
                                        switch (pilih3){
                                            case 1 :
                                                cBarang brgM1 = new cBarang(brg1.getNama(), 9500);
                                                br = new cTransaksi(kodes, String.valueOf(id), brgM1, jumlah, 0);
                                                beli.tambahTransaksi(br);
                                                kode++;
                                                break;
                                            case 2 :
                                                brgM1 = new cBarang(brg2.getNama(), 5700);
                                                br = new cTransaksi(kodes, String.valueOf(id), brgM1, jumlah, 0);
                                                beli.tambahTransaksi(br);
                                                kode++;
                                                break;
                                            case 3 :
                                                brgM1 = new cBarang(brg3.getNama(), 9500);
                                                br = new cTransaksi(kodes, String.valueOf(id), brgM1, jumlah, 0);
                                                beli.tambahTransaksi(br);
                                                kode++;
                                                break;
                                            case 4 :
                                                brgM1 = new cBarang(brg4.getNama(), 6650);
                                                br = new cTransaksi(kodes, String.valueOf(id), brgM1, jumlah, 0);
                                                beli.tambahTransaksi(br);
                                                kode++;
                                                break;
                                            case 5 :
                                                brgM1 = new cBarang(brg5.getNama(), 5700);
                                                br = new cTransaksi(kodes, String.valueOf(id), brgM1, jumlah, 0);
                                                beli.tambahTransaksi(br);
                                                kode++;
                                                break;
                                            case 6 :
                                                break;
                                        }
                                        if(pilih3 > 6){
                                            System.out.println("\n==== PILIHAN TIDAK TERSEDIA ===="); 
                                        }
                                    }while(pilih3 > 6);
                                    break;
                                case 2: 
                                    int a = beli.lihatTransaksi();
                                    if(a == 1){
                                        System.out.println("     ===== Data Masih Kosong =====");
                                    }else{
                                        System.out.print("Hapus nomor : ");
                                        int hapus = sc.nextInt();
                                        beli.hapusTransaksi(hapus);
                                    }
                                    kode--;
                                    break;
                                case 3:
                                    //menampilkan daftar belanja dan diskon
                                    beli.lihatTransaksiMember();
                                    break;
                                case 4:                   
                                    System.out.print("\n      Ubah Password\n-------------------------");
                                    int pilihPass = 0;
                                    do{
                                        System.out.print("\nPassword baru       : ");
                                        int pass = sc.nextInt();
                                        System.out.print("Konfirmasi Password : ");
                                        int pass1 = sc.nextInt();
                                        if(pass == pass1){
                                            if(id == id1){
                                                pw1 = pass;
                                            }else if(id == id2){
                                                pw2 = pass;
                                            }else{
                                                pw3 = pass;
                                            }
                                            System.out.println("Password berhasil diubah, silahkan login kembali ...");
                                            pilihPass++;
                                            break;
                                        }else{
                                            System.out.println("= Password tidak sesuai =");
                                        }
                                    }while(pilihPass == 0);
                                    pilih2 = 6;
                                    break;
                                case 5:
                                    //selesai. sambungkan transaksi pembeli
                                    //ke antrian transaksi toko
                                    jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                    System.out.println("Selamat datang kembali ...");
                                    break;
                            }
                            if(pilih2 > 6){
                                System.out.println("\n==== PILIHAN TIDAK TERSEDIA ===="); 
                            }
                        } while (pilih2 != 5);
                        break;
                    }
                    break;
                case 3://Admin
                    boolean loginA = false;
                    String userA = "admin";
                    String passA = "admin123";
                    do {
                            System.out.print("Username : ");
                            String userA1 = sc.next();
                            System.out.print("Password : ");
                            String passA1 = sc.next();
                            if(userA1.equalsIgnoreCase(userA)  && passA1.equalsIgnoreCase(passA) ){
                                loginA = true;
                            }else{
                                System.out.println("Maaf username atau password anda salah!");
                                System.out.println("Masukkan kembali username dan password anda!!");
                            }
                        }while (loginA != true);
                    System.out.println("\n-------------- AKUN ADMIN --------------");
                    int a = jual.lihatTransaksi();
                    if(a == 1){
                        System.out.println("     ===== Data Masih Kosong =====");
                    }else{
                        cTransaksi t = jual.getFront();
                        do {
                            if (t.getStatus() == 0) {
                                System.out.println("\nKode    : " + t.getKode());
                                System.out.println("Pembeli : " + t.getnmPembeli());
                                System.out.println("Barang  : " + t.getBarang().getNama());
                                System.out.println("Jumlah  : " + t.getJumlah());
                                System.out.println("-------------- Pilih Aksi --------------");
                                System.out.println("1. Diproses");
                                System.out.println("2. Selesai");
                                System.out.print("Pilih : ");
                                int aksi = sc.nextInt();
                                if (aksi == 1) {
                                    jual.prosesTransaksi(t);
                                    System.out.println("Berhasil Diproses");
                                } else {
                                    break;
                                }
                            }
                            t = t.next;
                        } while (t != null);
                    }
                    break;
                case 4://Pemilik
                    int pilihAdmin = 0;
                    boolean loginP = false;
                    String userP = "pemilik";
                    String passP = "pemilik123";
                    do {
                        do {
                            System.out.print("Username : ");
                            String userP1 = sc.next();
                            System.out.print("Password : ");
                            String passP1 = sc.next();
                            if(userP1.equalsIgnoreCase(userP)  && passP1.equalsIgnoreCase(passP) ){
                                loginP = true;
                            }else{
                                System.out.println("Maaf username atau password anda salah!");
                                System.out.println("Masukkan kembali username dan password anda!!");
                            }
                        }while (loginP != true);
                        
                        System.out.println("\n------------- AKUN PEMILIK -------------");
                        System.out.println("1. Mengubah Harga Menu");
                        System.out.println("2. Menampilkan Status Transaksi");
                        System.out.println("3. Menampilkan Laporan Pendapatan");
                        System.out.println("4. Grafik Penjualan");
                        System.out.println("5. Keluar");
                        System.out.print("Pilih : ");
                        pilihAdmin = sc.nextInt();
                        switch (pilihAdmin) {
                            case 1:
                                int ubahM=0;
                                do{
                                    int yes = 0;
                                    System.out.println("\n  Daftar Barang\n-----------------");
                                    System.out.print("1. "+brg1.getNama()+"\tHarga  : ");
                                    System.out.printf("%,d\n",brg1.getHarga());
                                    System.out.print("2. "+brg2.getNama()+"\tHarga  :  ");
                                    System.out.printf("%,d\n",brg2.getHarga());
                                    System.out.print("3. "+brg3.getNama()+"\tHarga  : ");
                                    System.out.printf("%,d\n",brg3.getHarga());
                                    System.out.print("4. "+brg4.getNama()+"\tHarga  :  ");
                                    System.out.printf("%,d\n",brg4.getHarga());
                                    System.out.print("5. "+brg5.getNama()+"\t\tHarga  :  ");
                                    System.out.printf("%,d\n",brg5.getHarga());
                                    System.out.println("6. Keluar");
                                    System.out.println("---------------------------------------");
                                    System.out.print("Pilih Menu yang Ingin diubah : ");
                                    ubahM = sc.nextInt();
                                    if(ubahM < 6){
                                      System.out.print("Harga Baru : ");
                                    int hargaB = sc.nextInt();
                                    switch(ubahM){
                                        case 1:
                                            brg1 = new cBarang(brg1.getNama(), hargaB);
                                            yes = 1;
                                            break;
                                        case 2:
                                            brg1 = new cBarang(brg2.getNama(), hargaB);
                                            yes = 1;
                                            break;
                                        case 3:
                                            brg1 = new cBarang(brg3.getNama(), hargaB);
                                            yes = 1;
                                            break;
                                        case 4:
                                            brg1 = new cBarang(brg4.getNama(), hargaB);
                                            yes = 1;
                                            break;
                                        case 5:
                                            brg1 = new cBarang(brg5.getNama(), hargaB);
                                            yes = 1;
                                            break;
                                        case 6:
                                            break;
                                        }
                                            System.out.println("Harga Berhasil Diubah ...");
                                            System.out.println("PESANAN YANG SUDAH DI PROSES TIDAK MENGALAMI PERUBAHAN HARGA");
                                            
                                    }
                                    else if(ubahM > 6){
                                        System.out.println("\n==== PILIHAN TIDAK TERSEDIA ====");
                                    }
                                }while(ubahM < 6);
                                break;
                            case 2:
                                System.out.println("\n    Status Transaksi\n-------------------------");
                                System.out.println("Diproses       : " + jual.lihatDiproses());
                                System.out.print("Pemasukan      : ");
                                System.out.printf("%,.0f\n", jual.lihatPemasukan());
                                System.out.println("-------------------------");
                                System.out.println("Tidak Diproses : " + jual.lihatTidakDiproses());
                                System.out.print("Pemasukan      : ");
                                System.out.printf("%,.0f\n", jual.lihatTidakPemasukan());
                                break;
                            case 3:
                                int pilihLp;
                                do{
                                    System.out.println("\n   Laporan Penjualan\n-----------------------");
                                    System.out.println("1. Pembeli");
                                    System.out.println("2. Member");
                                    System.out.println("3. Total Penjualan");
                                    System.out.println("4. Kembali");
                                    System.out.print("Pilih : ");
                                    pilihLp = sc.nextInt();
                                    switch(pilihLp){
                                        case 1 :
                                            jual.penjualan();
                                            break;
                                        case 2 :
                                            jual.penjualanMember();
                                            break;
                                        case 3 :
                                            jual.penjualanTotal();
                                            break;
                                    }
                                    if(pilihLp > 4){
                                        System.out.println("\n==== PILIHAN TIDAK TERSEDIA ===="); 
                                    }
                                }while(pilihLp != 4);
                                break;
                            case 4:
                                jual.grafikPenjualan();
                                break;
                        }
                        if(pilihAdmin > 5){
                            System.out.println("\n==== PILIHAN TIDAK TERSEDIA ===="); 
                        }
                    } while (pilihAdmin != 5);
                    break;
                case 5:
                    break;
            }
            if(pilih > 6){
                System.out.println("\n==== PILIHAN TIDAK TERSEDIA ===="); 
            }
        } while (pilih != 5);
    }
}
