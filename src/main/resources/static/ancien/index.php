<?php
	require_once ("connexion.php");
	$req="SELECT * FROM etudiants";
	$ps=$pdo->prepare($req);
	$ps->execute();
?>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>IDENTIFIEZ-VOUS</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/signin.css">

    <!-- Custom styles for this template -->
</head>

<body class="text-center">
<form class="form-signin" method="get" action="start.php">
    <img class="mb-4" src="assets/images/bootstrap-solid.svg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Identifiez vous</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required autofocus>
    <br>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Mot de passe" name="password" required>
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Se souvenir de moi
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
    <br>
    <p class="mt-5 mb-3 text-muted">Powerbach &copy; 2017-2018</p>
    <p class="mt-5 mb-3 text-muted right">
        <a href="#" class="href">
            Mot de passe oublié?
        </a>
    </p>
</form>
</body>
</html>
