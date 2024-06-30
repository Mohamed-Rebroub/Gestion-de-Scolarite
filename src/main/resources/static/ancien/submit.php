<?php
	//appelle de la connexion au serveur de base de données
	require 'connexion.php';

	//recuperation des valeures envoyées par POST 
	$nom = $_POST['nom'];
	$email = $_POST['email'];
	$photo = $_POST['photo'];

	$query = "INSERT INTO etudiant VALUES('', '.$nom.', '.$email.', '.$photo.')";
	var_dump($query);
	$result = mysql_query($query);
	$requette = $pdo->prepare("INSERT INTO etudiant SET nom = ?, email = ?, photo = ?");

    //$requette->execute($nom, $email, $photo);
    //location.header('index.php');
?>