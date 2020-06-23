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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Login;
import model.Produk;
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
            System.out.println("TGL_MASUK BEFORE = " + transaksi.getTgl_masuk());
            String tglMasuk = new SimpleDateFormat("dd/MM/yyyy").format(transaksi.getTgl_masuk());
            System.out.println("TGL_MASUK AFTER = " + tglMasuk);
            String tglKeluar = new SimpleDateFormat("dd/MM/yyyy").format(transaksi.getTgl_keluar());
            this.koneksi.ManipulasiData("INSERT INTO FITRIARISQINA_07032.TRANSAKSI_07032 (ID_TRANSAKSI, ID_USER, JUMLAH_PRODUK, TGL_MASUK, TGL_KELUAR, JML_PRODUK_KEMBALI, TOTAL)VALUES(ID_TRANSAKSI.NEXTVAL, '" + idUser + "','" + jumlahProduk + "', TO_DATE('" + tglMasuk + "','dd/MM/yyyy'), TO_DATE('" + tglKeluar + "','dd/MM/yyyy'), '" + jumlahProdukKembali + "', '" + totalHarga + "')");
            ResultSet rst = this.koneksi.getData("SELECT ID_TRANSAKSI.CURRVAL FROM DUAL");
            rst.next();
            int idTransaksi = rst.getInt("CURRVAL");
            System.out.println("=== " + idTransaksi);
            for (TransaksiDetail transaksiDetail : transaksi.getTransaksiDetails()) {
                this.koneksi.ManipulasiData("INSERT INTO FITRIARISQINA_07032.TRANSAKSI_DETAIL_07032 (ID_TRANSAKSI_DETAIL, ID_TRANSAKSI, ID_PRODUK, QTY_PRODUK, HARGA_PRODUK, TOTAL_HARGA) VALUES(ID_TRANSAKSI_DETAIL.NEXTVAL, '" + idTransaksi + "', '" + transaksiDetail.getIdProduk() + "', '" + transaksiDetail.getQtyProduk() + "', '" + Double.parseDouble(transaksiDetail.getHargaProduk()) + "', '" + (Double.parseDouble(transaksiDetail.getHargaProduk()) * transaksiDetail.getQtyProduk()) + "')");
                this.koneksi.ManipulasiData("UPDATE FITRIARISQINA_07032.PRODUK_07032 SET STOK=STOK-" + transaksiDetail.getQtyProduk() + " WHERE ID_PRODUK=" + transaksiDetail.getIdProduk());
                jumlahProduk += transaksiDetail.getQtyProduk();
                totalHarga += Double.parseDouble(transaksiDetail.getHargaProduk()) * transaksiDetail.getQtyProduk();
                System.out.println("TOTAL HARGA = " + totalHarga);
            }
            this.koneksi.ManipulasiData("UPDATE FITRIARISQINA_07032.TRANSAKSI_07032 SET JUMLAH_PRODUK='" + jumlahProduk + "',JML_PRODUK_KEMBALI='" + transaksi.getJml_produk_kmbli() + "', TOTAL='" + totalHarga + "' WHERE ID_TRANSAKSI=" + idTransaksi);
        } catch (SQLException e) {
            System.out.println("ERROR = " + e.toString());
        }
    }

    public ArrayList<Transaksi> getTransaksi(Transaksi transaksi) throws SQLException {
        this.arrtransaksi.clear();
        ResultSet rs;
        if (transaksi != null) {
            rs = this.koneksi.getData("SELECT * FROM FITRIARISQINA_07032.TRANSAKSI_07032 JOIN LOGIN_07032 ON LOGIN_07032.ID_USER = TRANSAKSI_07032.ID_USER WHERE TRANSAKSI_07032.ID_TRANSAKSI = " + transaksi.getId_transaksi());
        } else {
            rs = this.koneksi.getData("SELECT * FROM FITRIARISQINA_07032.TRANSAKSI_07032 JOIN LOGIN_07032 ON LOGIN_07032.ID_USER = TRANSAKSI_07032.ID_USER");
        }
        while (rs.next()) {
            Transaksi t = new Transaksi();
            t.setId_transaksi(rs.getInt("id_transaksi"));
            t.setJml_produk_kmbli(rs.getInt("jml_produk_kembali"));
            t.setJumlah_produk(rs.getInt("jumlah_produk"));
            t.setTgl_keluar(rs.getDate("tgl_keluar"));
            t.setTgl_masuk(rs.getDate("tgl_masuk"));
            t.setTotal(rs.getDouble("total"));

            //user login
            Login user = new Login();
            user.setId_user(rs.getInt("id_user"));
            user.setUsername(rs.getString("username"));
            t.setLogin(user);

            ArrayList<TransaksiDetail> arrDetail = new ArrayList<>();
            ResultSet dtRs = this.koneksi.getData("SELECT TRANSAKSI_DETAIL_07032.ID_TRANSAKSI AS ID_TRANSAKSI,TRANSAKSI_DETAIL_07032.QTY_PRODUK AS QTY_PRODUK,TRANSAKSI_DETAIL_07032.ID_PRODUK AS ID_PRODUK,TRANSAKSI_DETAIL_07032.TOTAL_HARGA AS TOTAL_HARGA,PRODUK_07032.NAMA_PRODUK AS NAMA_PRODUK,PRODUK_07032.HARGA AS HARGA FROM FITRIARISQINA_07032.TRANSAKSI_DETAIL_07032 JOIN PRODUK_07032 ON PRODUK_07032.ID_PRODUK = TRANSAKSI_DETAIL_07032.ID_PRODUK WHERE TRANSAKSI_DETAIL_07032.ID_TRANSAKSI = " + rs.getInt("id_transaksi"));
            while (dtRs.next()) {
                TransaksiDetail td = new TransaksiDetail();
                td.setIdTransaksi(dtRs.getInt("id_transaksi"));
                td.setIdProduk(dtRs.getInt("id_produk"));
                td.setTotalHarga(dtRs.getString("total_harga"));
                td.setQtyProduk(dtRs.getInt("qty_produk"));
                Produk p = new Produk();
                p.setNama_produk(dtRs.getString("nama_produk"));
                p.setHarga(dtRs.getDouble("harga"));
                td.setProduk(p);
                arrDetail.add(td);
            }

            t.setTransaksiDetails(arrDetail);

            this.arrtransaksi.add(t);
        }

        return this.arrtransaksi;
    }

}
