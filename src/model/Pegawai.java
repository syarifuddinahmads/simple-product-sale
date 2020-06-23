package model;

public class Pegawai {
    private Integer id_pegawai;
    private String nama_Pegawai;
    private String alamat;
    private Login login; 

    public Integer getId_pegawai() {
        return id_pegawai;
    }

    public void setId_pegawai(Integer id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getNama_Pegawai() {
        return nama_Pegawai;
    }

    public void setNama_Pegawai(String nama_Pegawai) {
        this.nama_Pegawai = nama_Pegawai;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
}
