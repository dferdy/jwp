/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.study.biodata.dao;

import com.study.biodata.connection.Koneksi;
import com.study.biodata.javabeans.Mahasiswa;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pins
 */
public class MahasiswaDao {
    
    Mahasiswa mahasiswa = new Mahasiswa();
    
    public void simpan(Mahasiswa mahasiswa) throws SQLException{
        try{
            Koneksi koneksi = new Koneksi();
            Connection conn = koneksi.bukaKoneksi();
            Statement stm = conn.createStatement();
            String query = "'"
                    + "insert into mahasiswa"
                    + "(nim,nama,jenis_kelamin,tempat_lahir,tanggal_lahir, handphone,email,alamat)"
                    + "values('" + mahasiswa.getNim() +"','"
                    + mahasiswa.getNama() +"','"
                    + "'" + mahasiswa.getJenisKelamin() +"',"
                    + "'" + mahasiswa.getTempatLahir() +"',"
                    + "'" + mahasiswa.getTanggalLahir() +"',"
                    + "'" + mahasiswa.getHandphone() +"'," 
                    + "'" + mahasiswa.getEmail() +"',"
                    + "'" + mahasiswa.getAlamat() +"'" + ")";
            
            stm.executeUpdate(query);
            conn.close();
            stm.close();           
        }catch(SQLException exc){
            exc.printStackTrace();
        }
    }
    }
    

