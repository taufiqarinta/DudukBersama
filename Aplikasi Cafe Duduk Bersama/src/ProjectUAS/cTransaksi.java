package ProjectUAS;
//class simpulnya 

public class cTransaksi {

    String kode;
    String Pembeli;
    cBarang barang;
    int jumlahBrg;
    int status;
    cTransaksi next;

    cTransaksi(String k, String p, cBarang b, int j, int s) {
        kode = k;
        Pembeli = p;
        barang = b;
        jumlahBrg = j;
        status = s;
        next = null;
    }

    public void setStatus(int s) {
        status = s;
    }

    public String getKode() {
        return kode;
    }

    public String getnmPembeli() {
        return Pembeli;
    }

    public cBarang getBarang() {
        return barang;
    }

    public int getJumlah() {
        return jumlahBrg;
    }

    public int getStatus() {
        return status;
    }
}
