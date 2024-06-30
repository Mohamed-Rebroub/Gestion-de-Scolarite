<?php

try{
	$Strconnection = 'mysql:host=127.0.0.1;dbname=pbash';
	$pdo = new PDO ($Strconnection, 'root', '');
}
catch (PDOException $e) {
	$msg = 'ERREUR PDO dans ' . $e->getMessage();
	die ($msg);
}

?>