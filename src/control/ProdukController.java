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
import model.Produk;

/**
 *
 * @author syarifuddin
 */
public class ProdukController {

    koneksi koneksi;
    ArrayList<Produk> arrproduk;

    public ProdukController() throws SQLException {
        this.koneksi = new koneksi();
        this.arrproduk = new ArrayList<>();
    }

    public ArrayList<Produk> getDataproduk(Produk p) throws SQLException {

        this.arrproduk.clear();
        ResultSet rs;
        if (p != null) {
            rs = this.koneksi.getData("select * from produk_07032 where id_produk =" + p.getId_produk());
        } else {
            rs = this.koneksi.getData("select * from produk_07032");
        }

        while (rs.next()) {

            Produk produk = new Produk();
            produk.setId_produk(rs.getInt("id_produk"));
            produk.setNama_produk(rs.getString("nama_produk"));
            produk.setHarga(rs.getDouble("Harga"));
            produk.setStok(rs.getInt("Stok"));
            this.arrproduk.add(produk);

        }
        return this.arrproduk;
    }

    public void insertProduct(Produk p) {
        try {
            System.out.println("PRODUK = " + p.getNama_produk() + ",HARGA = " + p.getHarga() + ",STOK =" + p.getStok());
            if (p.getId_produk() > 0) {
                System.out.println("UPDATE PRODUK");
                this.koneksi.ManipulasiData("UPDATE FITRIARISQINA_07032.PRODUK_07032 SET NAMA_PRODUK = '" + p.getNama_produk() + "', HARGA ='" + p.getHarga() + "', STOK ='" + p.getStok() + "' WHERE ID_PRODUK =" + p.getId_produk());
            } else {
                System.out.println("INSERT PRODUK");
                this.koneksi.ManipulasiData("INSERT INTO FITRIARISQINA_07032.PRODUK_07032 (ID_PRODUK, NAMA_PRODUK, HARGA,STOK) VALUES (ID_PRODUK.NEXTVAL, '" + p.getNama_produk() + "', '" + p.getHarga() + "', '" + p.getStok() + "')");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteProduk(int idProduk) {
        try {
            this.koneksi.ManipulasiData("DELETE FITRIARISQINA_07032.PRODUK_07032 WHERE ID_PRODUK=" + idProduk);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
