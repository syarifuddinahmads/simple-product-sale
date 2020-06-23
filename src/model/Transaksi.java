package model;

import java.util.ArrayList;
import java.util.Date;

public class Transaksi {
    private Integer id_transaksi;
    private Integer jumlah_produk;
    private String tgl_masuk;
    private String tgl_keluar;
    private int jml_produk_kmbli;
    private double total;
    ArrayList<TransaksiDetail> transaksiDetails;

    public Integer getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Integer id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Integer getJumlah_produk() {
        return jumlah_produk;
    }

    public void setJumlah_produk(Integer jumlah_produk) {
        this.jumlah_produk = jumlah_produk;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public String getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(String tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    public int getJml_produk_kmbli() {
        return jml_produk_kmbli;
    }

    public void setJml_produk_kmbli(int jml_produk_kmbli) {
        this.jml_produk_kmbli = jml_produk_kmbli;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<TransaksiDetail> getTransaksiDetails() {
        return transaksiDetails;
    }

    public void setTransaksiDetails(ArrayList<TransaksiDetail> transaksiDetails) {
        this.transaksiDetails = transaksiDetails;
    }

    
}
