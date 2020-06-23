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
import model.Login;

/**
 *
 * @author syarifuddin
 */
public class LoginController {

    koneksi koneksi;

    public LoginController() {
        this.koneksi = new koneksi();
    }

    public Login doLogin(Login login) {

        try {
            ResultSet rs = this.koneksi.getData("SELECT * FROM FITRIARISQINA_07032.LOGIN_07032 WHERE USERNAME ='" + login.getUsername() + "' AND PASSWORD ='" + login.getPassword() + "'");
            System.out.println("LOGIN = " + this.koneksi.getData("SELECT * FROM FITRIARISQINA_07032.LOGIN_07032 WHERE USERNAME ='" + login.getUsername() + "'"));
            rs.next();
            Login user = new Login();
            user.setId_user(rs.getInt("id_user"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));

            return user;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

}
