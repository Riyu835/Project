<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		$id = (!isset($_GET['id']));
		
		require_once'koneksi.php';

		$name = $_POST['name'];
		$desg = $_POST['desg'];
		$sal = $_POST['salary'];

		$sql = "INSERT INTO tb_pegawai (nama,posisi,gaji) VALUES ('$name','$desg','$sal')";

		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Pegawai';
		}else{
			echo 'Gagal Menambahkan Pegawai';
		}

		mysqli_close($con);
	}
?>