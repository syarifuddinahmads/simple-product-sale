/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import database.Data;
import database.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Transaksi;
import model.TransaksiDetail;

public class TransaksiController {

    koneksi koneksi;
    ArrayList<Transaksi> arrtransaksi;

    public TransaksiController() throws SQLException {
        this.koneksi = new koneksi();
        this.arrtransaksi = new ArrayList<>();
    }

    public void insertTransaksi(Transaksi transaksi) {
        try {
            Double totalHarga = 0.0;
            int jumlahProduk = 0;
            int jumlahProdukKembali = 0;
            int idUser = Data.userlLogin.getId_user();
            this.koneksi.ManipulasiData("INSERT INTO FITRIARISQINA_07032.TRANSAKSI_07032 (ID_TRANSAKSI, ID_USER, JUMLAH_PRODUK, TGL_MASUK, TGL_KELUAR, JML_PRODUK_KEMBALI, TOTAL)VALUES(ID_TRANSAKSI.NEXTVAL, '" + idUser + "','" + jumlahProduk + "', '" + transaksi.getTgl_masuk() + "', '" + transaksi.getTgl_keluar() + "', '" + jumlahProdukKembali + "', '" + totalHarga + "')");
            ResultSet rst = this.koneksi.getData("SELECT ID_TRANSAKSI.CURRVAL FROM DUAL");
            rst.next();
            int idTransaksi = rst.getInt("CURRVAL");
            for (TransaksiDetail transaksiDetail : transaksi.getTransaksiDetails()) {
                System.out.println("=== "+Integer.parseInt(transaksiDetail.getTotalHarga()));
                this.koneksi.ManipulasiData("INSERT INTO FITRIARISQINA_07032.TRANSAKSI_DETAIL_07032 (ID_TRANSAKSI_DETAIL, ID_TRANSAKSI, ID_PRODUK, QTY_PRODUK, HARGA_PRODUK, TOTAL_HARGA) VALUES(ID_TRANSAKSI_DETAIL.NEXTVAL, '" + idTransaksi + "', '" + transaksiDetail.getIdProduk() + "', '" + transaksiDetail.getQtyProduk() + "', '" + transaksiDetail.getTotalHarga().trim() + "', '" + Integer.parseInt(transaksiDetail.getTotalHarga().trim()) * transaksiDetail.getQtyProduk() + "')");
                this.koneksi.ManipulasiData("UPDATE FITRIARISQINA_07032.PRODUK_07032 STOK=STOK-" + transaksiDetail.getQtyProduk() + " WHERE ID_PRODUK=" + transaksiDetail.getIdProduk());
                jumlahProduk += transaksiDetail.getQtyProduk();
                totalHarga += Integer.parseInt(transaksiDetail.getHargaProduk()) * transaksiDetail.getQtyProduk();
            }
            this.koneksi.ManipulasiData("UPDATE FITRIARISQINA_07032.TRANSAKSI_07032 SET JUMLAH_PRODUK='"+jumlahProduk+"', TOTAL='"+totalHarga+"' WHERE ID_TRANSAKSI=" + idTransaksi);
        } catch (SQLException e) {
            System.out.println("ERROR = " + e.toString());
        }
    }

}
