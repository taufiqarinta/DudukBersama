package ProjectUAS;
//class linked listnya

public class cDaftarTransaksi {

    cTransaksi front, rear;
    int jumlah;

    cDaftarTransaksi() {
        front = rear = null;
        jumlah = 0;
    }

    public cTransaksi getFront() {
        return front;
    }

    public cTransaksi getRear() {
        return rear;
    }

    public void tambahTransaksi(cTransaksi baru) {
        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        System.out.println("Penambahan Sukses");
    }

    public int lihatTransaksi() {
        int i = 1;    
        System.out.println("\n\t    Daftar Transaksi\n----------------------------------------");
        for (cTransaksi t = front; t != null; t = t.next) {
            System.out.print(i + ". ");
            System.out.print(t.getKode() + " - ");
            System.out.print(t.getnmPembeli() + " - ");
            System.out.print(t.getBarang().getNama() + " - ");
            System.out.print(t.getJumlah() + " - ");
            System.out.println(t.getStatus());
            i++;
        }
        return i;
    }

    public void lihatTransaksiMember() {
        int i = 1;
        double total = 0;
        System.out.println("\n\tDaftar Transaksi Member\n"
                +          "----------------------------------------");
        for (cTransaksi t = front; t != null; t = t.next) {
            System.out.print(i + ". ");
            System.out.print(t.getKode() + " - ");
            System.out.print(t.getnmPembeli() + " - ");
            System.out.print(t.getBarang().getNama() + " - ");
            System.out.print(t.getJumlah() + " - ");
            System.out.println(t.getStatus());
            i++;
            total = total + (t.getBarang().getHarga() * t.getJumlah());
        }
        System.out.print("\nTotal Belanja       : ");
        System.out.printf("%,.0f\n", total / 0.95);
        System.out.print("Diskon              : ");
        System.out.printf("%,.0f\n", total * 0.05 / 0.95);
        System.out.print("Jumlah Pembayaran   : ");
        System.out.printf("%,.0f\n", total);
    }

    public void hapusTransaksi(int nomor) {
        cTransaksi t = front;
        cTransaksi prev = null;
        int i = 1;
        if (nomor == 1) {
            if (t.next == null) {
                front = rear = null;
            } else {
                front = front.next;
                t.next = null;
            }
            System.out.println("[" + t.getBarang().getNama() + "] dihapus ...");
        } else {
            for (; t != null; t = t.next) {
                if (i == nomor) {
                    break;
                }
                i++;
                prev = t;
            }
            if (t.next == null) {
                rear = prev;
                rear.next = null;
            } else {
                prev.next = t.next;
                t.next = null;
            }
            System.out.println("[" + t.getBarang().getNama() + "] dihapus ...");
        }
    }

    public void sambungTransaksi(cTransaksi depan, cTransaksi belakang) {
//        System.out.println("rear : "+rear.getnmPembeli());
//        System.out.println("Front : "+depan.getnmPembeli());
        if (rear == null) {
            front = depan;
            rear = belakang;
        } else {
            rear.next = depan;
            rear = belakang;
        }
    }

    public void prosesTransaksi(cTransaksi t) {
        t.setStatus(1);
    }

    public void prosesTransaksiMember(cTransaksi t) {

    }

    public int lihatDiproses() {
        cTransaksi t = front;
        int proses = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                proses++;
            }
        }
        return proses;
    }

    public int lihatTidakDiproses() {
        cTransaksi t = front;
        int Tproses = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 0) {
                Tproses++;
            }
        }
        return Tproses;
    }

    public double lihatPemasukan() {
        cTransaksi t = front;
        double nominal = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                //cek member berdasarkan dataa nama/kode pembeli
                nominal = nominal + t.getBarang().getHarga() * t.getJumlah();
                //System.out.println("Kode : "+t.getKode());
//                if (t.getnmPembeli().compareToIgnoreCase("1")==0||t.getnmPembeli().compareToIgnoreCase("02")==0||t.getnmPembeli().compareToIgnoreCase("03")==0){
//                    System.out.println("Member!");
//                    nominal = nominal - (0.05 * nominal);
//                }
            }
        }
        return nominal;

    }

    public double lihatTidakPemasukan() {
        cTransaksi t = front;
        int Tnominal = 0;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 0) {
                Tnominal = Tnominal + t.getBarang().getHarga() * t.getJumlah();
            }
        }
        return Tnominal;
    }

    public void penjualan() {
        cTransaksi t = front;
        double hargabrg1 = 0, hargabrg2 = 0, hargabrg3 = 0, hargabrg4 = 0, hargabrg5 = 0, nominal = 0;
//        int no = 1;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1 ) {
                if (t.getnmPembeli().compareToIgnoreCase("2201")==0 
                    || t.getnmPembeli().compareToIgnoreCase("2202")==0 
                    || t.getnmPembeli().compareToIgnoreCase("2203")==0){
                    
                }else{
                    String NamaB = t.getBarang().getNama();
                    if ("Coffe Caramel".equals(NamaB)) {
                        hargabrg1 = hargabrg1 + t.getBarang().getHarga() * t.getJumlah();
                    } else if ("Coffe Good Day".equals(NamaB)) {
                        hargabrg2 = hargabrg2 + t.getBarang().getHarga() * t.getJumlah();
                    } else if ("Ice Red velvet".equals(NamaB)){
                        hargabrg3 = hargabrg3 + t.getBarang().getHarga() * t.getJumlah();
                    } else if ("Kentang Goreng".equals(NamaB)){
                        hargabrg4 = hargabrg4 + t.getBarang().getHarga() * t.getJumlah();
                    } else {
                        hargabrg5 = hargabrg5 + t.getBarang().getHarga() * t.getJumlah();
                    } 
                }
            }
        }
        nominal = hargabrg1+hargabrg2+hargabrg3+hargabrg4+hargabrg5;
        System.out.print("\n1. Coffe Caramel  : ");
        System.out.printf("%,.0f\n",hargabrg1);
        System.out.print("2. Coffe Good Day : ");
        System.out.printf("%,.0f\n",hargabrg2);
        System.out.print("3. Ice Red Velvet : ");
        System.out.printf("%,.0f\n",hargabrg3);
        System.out.print("4. Kentang Goreng : ");
        System.out.printf("%,.0f\n",hargabrg4);
        System.out.print("5. Mie Instan     : ");
        System.out.printf("%,.0f\n",hargabrg5);
        System.out.println("---------------------------");
        System.out.print("Total             : ");
        System.out.printf("%,.0f\n",nominal);
    }

    public void penjualanMember() {
        cTransaksi t = front;
        double hargabrg1 = 0, hargabrg2 = 0, hargabrg3 = 0, hargabrg4 = 0, hargabrg5 = 0, 
               nominal = 0,nominal1 = 0, nominal2 =0, nominal3=0;
//        int no = 1;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1 ) {
                if (t.getnmPembeli().compareToIgnoreCase("2201")==0){
                    nominal1 += t.getBarang().getHarga() * t.getJumlah();
                }else if (t.getnmPembeli().compareToIgnoreCase("2202")==0){
                    nominal2 += t.getBarang().getHarga() * t.getJumlah();
                }else if(t.getnmPembeli().compareToIgnoreCase("2203")==0){
                    nominal3 += t.getBarang().getHarga() * t.getJumlah();
                }else{
                }
            }
        }
        nominal = nominal1+nominal2+nominal3;
        System.out.print("\n1. Taufiq   : ");
        System.out.printf("%,.0f\n",nominal1);
        System.out.print("2. Uyun     : ");
        System.out.printf("%,.0f\n",nominal2);
        System.out.print("3. Najwa    : ");
        System.out.printf("%,.0f\n",nominal3);
        System.out.println("-----------------------");
        System.out.print("Total       : ");
        System.out.printf("%,.0f\n",nominal);
    }
    
    public void penjualanTotal() {
        cTransaksi t = front;
        double hargabrg1 = 0, hargabrg2 = 0, hargabrg3 = 0, hargabrg4 = 0, hargabrg5 = 0, nominal = 0;
//        int no = 1;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1 ) {
                String NamaB = t.getBarang().getNama();
                if ("Coffe Caramel".equals(NamaB)) {
                    hargabrg1 = hargabrg1 + t.getBarang().getHarga() * t.getJumlah();
                } else if ("Coffe Good Day".equals(NamaB)) {
                    hargabrg2 = hargabrg2 + t.getBarang().getHarga() * t.getJumlah();
                } else if ("Ice Red velvet".equals(NamaB)){
                    hargabrg3 = hargabrg3 + t.getBarang().getHarga() * t.getJumlah();
                } else if ("Kentang Goreng".equals(NamaB)){
                    hargabrg4 = hargabrg4 + t.getBarang().getHarga() * t.getJumlah();
                } else {
                    hargabrg5 = hargabrg5 + t.getBarang().getHarga() * t.getJumlah();
                }
            }
        }
        nominal = hargabrg1+hargabrg2+hargabrg3+hargabrg4+hargabrg5;
        System.out.print("\n1. Coffe Caramel  : ");
        System.out.printf("%,.0f\n",hargabrg1);
        System.out.print("2. Coffe Good Day : ");
        System.out.printf("%,.0f\n",hargabrg2);
        System.out.print("3. Ice Red Velvet : ");
        System.out.printf("%,.0f\n",hargabrg3);
        System.out.print("4. Kentang Goreng : ");
        System.out.printf("%,.0f\n",hargabrg4);
        System.out.print("5. Mie Instan     : ");
        System.out.printf("%,.0f\n",hargabrg5);
        System.out.println("---------------------------");
        System.out.print("Total             : ");
        System.out.printf("%,.0f\n",nominal);
    }
    
    public void grafikPenjualan() {
        cTransaksi t = front;
        double hargabrg1 = 0, hargabrg2 = 0, hargabrg3 = 0, hargabrg4 = 0, hargabrg5 = 0, nominal = 0;
//        int no = 1;
        for (; t != null; t = t.next) {
            if (t.getStatus() == 1) {
                String NamaB = t.getBarang().getNama();
                if ("Coffe Caramel".equals(NamaB)) {
                    hargabrg1 = hargabrg1 + t.getBarang().getHarga() * t.getJumlah();
                    nominal += hargabrg1;
                } else if ("Coffe Good Day".equals(NamaB)) {
                    hargabrg2 = hargabrg2 + t.getBarang().getHarga() * t.getJumlah();
                    nominal += hargabrg2;
                } else if ("Ice Red velvet".equals(NamaB)){
                    hargabrg3 = hargabrg3 + t.getBarang().getHarga() * t.getJumlah();
                    nominal += hargabrg3;
                } else if ("Kentang Goreng".equals(NamaB)){
                    hargabrg4 = hargabrg4 + t.getBarang().getHarga() * t.getJumlah();
                    nominal += hargabrg4;
                } else{
                    hargabrg5 = hargabrg5 + t.getBarang().getHarga() * t.getJumlah();
                    nominal += hargabrg5;
                }
            }
        }
        System.out.print("\n1. Coffe Caramel  : ");
        int n = (int)hargabrg1 / 10000;
        for (int i = 0; i < n; i++) {
            System.out.print("X");
        }
        System.out.printf("%,.0f\n",hargabrg1);
        System.out.print("2. Coffe Good Day : ");
        n = (int)hargabrg2 / 10000;
        for (int i = 0; i < n; i++) {
            System.out.print("X");
        }
        System.out.printf("%,.0f\n",hargabrg2);
        System.out.print("3. Ice Red Velvet : ");
        n = (int)hargabrg3 / 10000;
        for (int i = 0; i < n; i++) {
            System.out.print("X");
        }
        System.out.printf("%,.0f\n",hargabrg3);
        System.out.print("4. Kentang Goreng : ");
        n = (int)hargabrg4 / 10000;
        for (int i = 0; i < n; i++) {
            System.out.print("X");
        }
        System.out.printf("%,.0f\n",hargabrg4);
        System.out.print("5. Mie Instan     : ");
        n = (int)hargabrg5 / 10000;
        for (int i = 0; i < n; i++) {
            System.out.print("X");
        }
        System.out.printf("%,.0f\n",hargabrg5);
    }
}
