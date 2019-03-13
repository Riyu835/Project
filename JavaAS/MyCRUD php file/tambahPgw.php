<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		$id = (!isset($_GET['id']));
		
		require_once'koneksi.php';

		$name = $_POST['nama'];
		$desg = $_POST['posisi'];
		$sal = $_POST['gaji'];

		$sql = "INSERT INTO tb_pegawai (nama,posisi,gaji) VALUES ('$name','$desg','$sal')";

		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Pegawai';
		}else{
			echo 'Gagal Menambahkan Pegawai';
		}

		mysqli_close($con);
	}
?>
<!-- <form method="POST" action="tambahPgw.php">
<table>
			<tr>
				<td>Nama</td>
				<td><input type="text" name="nama"></td>					
			</tr>	
			<tr>
				<td>Jabatan</td>
				<td><input type="text" name="posisi"></td>					
			</tr>	
			<tr>
				<td>Gaji</td>
				<td><input type="text" name="gaji"></td>					
			</tr>	
			<tr>
				<td></td>
				<td><input type="submit" value="Simpan"></td>					
			</tr>				
		</table>
		</form> -->