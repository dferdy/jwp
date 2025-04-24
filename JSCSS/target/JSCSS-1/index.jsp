<%-- 
    Document   : index
    Created on : Apr 14, 2025, 9:38:07 AM
    Author     : pins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/jquery-ui.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        
        <script type="text/javascript">
            function validasiKosong(){
                var x = document.forms['form']['nim'].value
                if (x==null || x==""){
                    alert("NIM Harus Diisi");
                    return false;
                }
                
                var x = document.forms['form']['nama'].value
                if (x==null || x==""){
                    alert("Nama Harus Diisi");
                    return false;
                }
                
                var x = document.forms['form']['jenkel'].value
                if (x==null || x==""){
                    alert("Jenis Kelamin Harus Diisi");
                    return false;
                }
                
                var x = document.forms['form']['tempatlahir'].value
                if (x==null || x==""){
                    alert("Tempat Lahir Harus Diisi");
                    return false;
                }
                
                var x = document.forms['form']['tanggallahir'].value
                if (x==null || x==""){
                    alert("Tanggal Lahir Harus Diisi");
                    return false;
                }
                
                var x = document.forms['form']['hp'].value
                if (x==null || x==""){
                    alert("Nomor Handphone Harus Diisi");
                    return false;
                }
                
                var x = document.forms['form']['email'].value
                if (x==null || x==""){
                    alert("Alamat E-mail Harus Diisi");
                    return false;
                }
                
                var x = document.forms['form']['alamat'].value
                if (x==null || x==""){
                    alert("Alamat Anda Harus Diisi");
                    return false;
                }
            }
            function validasiAngka(evt){
                var charCode = (evt.which) ? evt.which : event.keyCode
                if(charCode > 31 && (charCode < 48 || charCode > 57))
                        return false;
                    return true;
            }
            $(function(){
                $("#datepicker").datepicker();
            })
    </script>
    
    </head>
    <body>
        <div id="container">
            <h3>Form Biodata Diri</h3>
            <form action="MahasiswaController" name="form" method="post" onsubmit="return validasiKosong()">
                <label>NIM</label>
                <input type="text" name="nim" size="15" class="text" onkeypress="return validasiAngka(event)"/><br />
                <label>Nama</label>
                <input type="text" name="nama" size="15" class="text" /><br/>
                <label>Jenis Kelamin</label>
                <input type="radio" name="jenkel" value="L" class="text" />Laki-laki&nbsp;
                <input type="radio" name="jenkel" value="P" class="text" />Perempuan<br/>
                <label>Tempat Lahir</label>               
                <input type="text" name="tempatlahir" size="15" class="text" /><br/>
                <label>Tanggal Lahir</label>
                <input type="text" name="tanggallahir" id="datepicker"> *mm/dd/yyyy <br/>
                <label>Nomor Handphone</label>
                <input type="text" name="hp" size="15" class="text" onkeypress="return validasiAngka(event)"/><br />
                <label>E-Mail</label>
                <input type="text" name="email" size="15" class="text" /><br/>
                <label>Alamat</label>
                <textarea name="alamat" rows="5" cols="28"></textarea><br/><br/>
                <label></label>
                <input type="submit" name="submit" value="Daftar" class="button"/>
                <input type="reset" name="reset" value="Reset" class="button"/>
            </form>
            <form action="ProsesMahasiswa.jsp" name="form" method="post" onsubmit="return Kosong()">
        </div>
    </body>
</html>
