package model;

import java.util.Date;

public class transaksi {
    private Integer id_transaksi;
    private Integer jumlah_produk;
    private Date tgl_masuk;
    private Date tgl_keluar;
    private Date jml_produk_kmbli;
    private double total;

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

    public Date getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(Date tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public Date getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(Date tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    public Date getJml_produk_kmbli() {
        return jml_produk_kmbli;
    }

    public void setJml_produk_kmbli(Date jml_produk_kmbli) {
        this.jml_produk_kmbli = jml_produk_kmbli;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
