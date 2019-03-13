<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id = $_POST['id'];
		$name = $_POST['name'];
		$desg = $_POST['desg'];
		$sal = $_POST['salary'];

		require_once'koneksi.php';

		$sql = "UPDATE tb_pegawai SET nama = '$name', posisi = '$desg', gaji = '$sal' WHERE id = $id;";

		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Pegawai';
		}else{
			echo 'Gagal Update Data Pegawai';
		}

		mysqli_close($con);
	}
?>
