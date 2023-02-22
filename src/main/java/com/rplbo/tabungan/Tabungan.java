package com.rplbo.tabungan;

public class Tabungan {
    private int saldo;
    private String pemilik;

    public Tabungan() {
    }

    public int getSaldo(){ return saldo; }
    public String getPemilik(){ return pemilik; }
    public void setPemilik(String pemilik){
        this.pemilik = pemilik;
    }

    public void penarikan(int jumlah){
        if(jumlah > 0 && saldo>=jumlah){
            saldo = saldo - jumlah;
        }
    }

    public void penyetoran(int jumlah){
        if(jumlah > 0){
            saldo = saldo + jumlah;
        }
    }

    public void transfer(int jumlah,Tabungan t){
        if(saldo>=jumlah) {
            penarikan(jumlah);
            t.penyetoran(jumlah);
        }
    }

    public void tampilkan(){
        System.out.println("Nama pemilik: "+ pemilik);
        System.out.println("Saldo: "+this.saldo);
    }
}
