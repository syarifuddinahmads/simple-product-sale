/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import database.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.produk;

/**
 *
 * @author syarifuddin
 */
public class produk_controller {

    koneksi koneksi;
    ArrayList<produk> arrproduk;

    public produk_controller() throws SQLException {
        this.koneksi = new koneksi();
        this.arrproduk = new ArrayList<>();
    }

    public ArrayList<produk> getDataproduk(produk p) throws SQLException {

        this.arrproduk.clear();
        ResultSet rs;
        if (p != null) {
            rs = this.koneksi.getData("select * from produk_07032 where id_produk =" + p.getId_produk());
        } else {
            rs = this.koneksi.getData("select * from produk_07032");
        }

        while (rs.next()) {

            produk produk = new produk();
            produk.setId_produk(rs.getInt("id_produk"));
            produk.setNama_produk(rs.getString("nama_produk"));
            produk.setHarga(rs.getDouble("Harga"));
            produk.setStok(rs.getInt("Stok"));
            this.arrproduk.add(produk);

        }
        return this.arrproduk;
    }
}
