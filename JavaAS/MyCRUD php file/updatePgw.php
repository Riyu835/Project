<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id = $_POST['id'];
		$name = $_POST['nama'];
		$desg = $_POST['posisi'];
		$sal = $_POST['gaji'];

		require_once'koneksi.php';

		$sql = "UPDATE tb_pegawai SET nama = '$nama', posisi = '$posisi', gaji = '$gaji' WHERE id = $id;";

		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Pegawai';
		}else{
			echo 'Gagal Update Data Pegawai';
		}

		mysqli_close($con);
	}
?>
