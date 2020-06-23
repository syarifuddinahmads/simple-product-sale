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
import model.Pegawai;

/**
 *
 * @author syarifuddin
 */
public class PegawaiController {

    koneksi koneksi;
    ArrayList<Pegawai> arrPegawai;

    public PegawaiController() throws SQLException {
        this.koneksi = new koneksi();
        this.arrPegawai = new ArrayList<>();
    }

    public ArrayList<Pegawai> getDataPegawai(Pegawai p) throws SQLException {

        this.arrPegawai.clear();
        ResultSet rs;
        if (p != null) {
            rs = this.koneksi.getData("select * from pegawai_07032 where id_pegawai =" + p.getId_pegawai());
        } else {
            rs = this.koneksi.getData("select * from pegawai_07032");
        }

        while (rs.next()) {

            Pegawai pegawai = new Pegawai();
            pegawai.setId_pegawai(rs.getInt("id_pegawai"));
            pegawai.setNama_Pegawai(rs.getString("nama_pegawai"));
            pegawai.setAlamat(rs.getString("alamat"));

            this.arrPegawai.add(pegawai);

        }

        return this.arrPegawai;
    }

    public void insertPegawai(Pegawai p) {
        System.out.println("ID_USER_LOGIN = " + Data.userlLogin.getId_user());
        try {
            if (p.getId_pegawai() > 0) {
                System.out.println("UPDATE PEGAWAI");
                this.koneksi.ManipulasiData("UPDATE FITRIARISQINA_07032.PEGAWAI_07032 SET NAMA_PEGAWAI = '" + p.getNama_Pegawai() + "', ALAMAT ='" + p.getAlamat() + "', ID_USER ='" + String.valueOf(Data.userlLogin.getId_user()) + "' WHERE ID_PEGAWAI =" + p.getId_pegawai());
            } else {
                System.out.println("INSERT PEGAWAI");
                this.koneksi.ManipulasiData("INSERT INTO FITRIARISQINA_07032.PEGAWAI_07032 (ID_PEGAWAI, ID_USER, NAMA_PEGAWAI, ALAMAT) VALUES (ID_PEGAWAI.NEXTVAL, '" + String.valueOf(Data.userlLogin.getId_user()) + "', '" + p.getNama_Pegawai() + "', '" + p.getAlamat() + "')");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletePegawai(int idPegawai) {
        try {
            this.koneksi.ManipulasiData("DELETE FITRIARISQINA_07032.PEGAWAI_07032 WHERE ID_PEGAWAI=" + idPegawai);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
