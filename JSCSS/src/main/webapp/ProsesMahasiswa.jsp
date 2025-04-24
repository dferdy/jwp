<%-- 
    Document   : ProsesMahasiswa
    Created on : Apr 14, 2025, 7:40:08 PM
    Author     : pins
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.study.biodata.connection.Koneksi" %>
<%@page import="java.sql.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <%
            String nim = request.getParameter("nim");
            String nama = request.getParameter("nama");
            String jenisKelamin = request.getParameter("jenkel");
            String tempatLahir = request.getParameter("tempatlahir");
            String tanggalLahir = request.getParameter("tanggallahir");
            String handphone = request.getParameter("hp");
            String email = request.getParameter("email");
            String alamat = request.getParameter("alamat");
            
            Koneksi koneksi = new Koneksi();
            Connection conn = koneksi.bukaKoneksi();
            Statement stm = conn.createStatement();
            String query = "insert into mahasiswa"
                        + "(nim,nama,jenis_kelamin,tempat_lahir,tanggal_lahir, handphone,email,alamat)"
                        + "values('"+nim+"','"+nama+"','"+jenisKelamin+"',"
                        +"'"+tempatLahir+"',"+"'"+tanggalLahir+"',"
                        +"'"+handphone+"',"+"'"+email+"'"+"'"+alamat+"'"+")";
            stm.executeUpdate(query);
            conn.close();
            stm.close();
        %>
        <div id="contain">
            <h3>Form Mahasiswa Telah Berhasil DiSimpan</h3>
            <a href='index.jsp'>BACK</a>
        </div>                
            
    </body>
</html>
