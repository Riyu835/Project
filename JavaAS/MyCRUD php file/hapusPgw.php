<?php

 $id = (!isset($_GET['id']));

 require_once'koneksi.php';

 $sql = "DELETE FROM tb_pegawai WHERE id=$id;";

 if(mysqli_query($con,$sql)){
 echo 'Berhasil Menghapus Pegawai';
 }else{
 echo 'Gagal Menghapus Pegawai';
 }

 mysqli_close($con);
 ?>
