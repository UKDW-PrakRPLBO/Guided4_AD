package com.rplbo.tabungan;
/**
 * Hello world!
 *
 */
public class Main
{
    public static void tampil(Tabungan x){
        System.out.println("Pemilik: "+x.getPemilik());
        System.out.println("Saldo: "+x.getSaldo());
    }
    public static void main( String[] args )
    {
        Tabungan A = new Tabungan();
        Tabungan B = new Tabungan();
        A.setPemilik("A");
        A.penyetoran(300);
        B.setPemilik("B");
        B.penyetoran(1200);
        A.tampilkan();
        B.tampilkan();
        A.penarikan(150);
        B.penyetoran(300);

        B.penarikan(-500);
        A.penyetoran(-1000);
        A.tampilkan();
        B.tampilkan();

    }
}
