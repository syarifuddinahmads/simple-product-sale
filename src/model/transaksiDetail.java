/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lenovo
 */
public class transaksiDetail {
    
    int idTransaksiDetail;
    int idTransaksi;
    int idProduk;
    int qtyProduk;
    String hargaProduk;
    String totalHarga;
    produk produk;

    public produk getProduk() {
        return produk;
    }

    public void setProduk(produk produk) {
        this.produk = produk;
    }

    public int getIdTransaksiDetail() {
        return idTransaksiDetail;
    }

    public void setIdTransaksiDetail(int idTransaksiDetail) {
        this.idTransaksiDetail = idTransaksiDetail;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public int getQtyProduk() {
        return qtyProduk;
    }

    public void setQtyProduk(int qtyProduk) {
        this.qtyProduk = qtyProduk;
    }

    public String getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(String hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(String totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    
    
}
