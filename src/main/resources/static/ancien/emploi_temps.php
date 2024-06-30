<?php
require_once ("connexion.php");

	$student = $_GET['student'];
	$filiere = $_GET['filiere']; 
?>

<?php echo 'vous etes de la filiere '.$filiere; ?>

<?php require 'header.php' ?>
<form action="">
	<select name="filiere" id="">
		<option value="web">Webmaster</option>
		<option value="maintenance">maintenance</option>
		<option value="secretariat">secreatariat</option>
	</select>
	<input type="date" name="date-debut">
	<input type="date" name="date-fin">
	<select name="jours" id="">
		<option value="lundi">Lundi</option>
		<option value="mardi">mardi</option>
		<option value="mercredi">mercredi</option>
		<option value="jeudi">jeudi</option>
		<option value="vendredi">vendredi</option>
		<option value="samedi">samedi</option>
	</select>
	<input type="hours" name="horaire">
	<select name="salle" id="">
		<option value="labo">Labo</option>
		<option value="101">101</option>
		<option value="202">202</option>
	</select>
	<select name="cours" id="">
		<option value="anglais">Anglais</option>
		<option value="francais">Francais</option>
	</select>
	<input type="submit" value="Valider" class="btn btn-primary">
</form>
<hr>
<table class="table">
	<tr>
		aucune programmation pour le moment
	</tr>
	<br>
	<tr>
		aucune programmation pour le moment
	</tr>
	<br>
	<tr>
		aucune programmation pour le moment
	</tr>
</table>