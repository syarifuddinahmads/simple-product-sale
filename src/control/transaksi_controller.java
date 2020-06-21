/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import database.koneksi;
import java.sql.SQLException;
import java.util.ArrayList;
import model.transaksi;

public class transaksi_controller {

    koneksi koneksi;
    ArrayList<transaksi> arrtransaksi;

    public transaksi_controller() throws SQLException {

        this.koneksi = new koneksi();
        this.arrtransaksi = new ArrayList<>();
    }

}
