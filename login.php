<?php
session_start();

if(isset($_POST['submit'])){

    $username = $_POST['uname'];
	$password = $_POST['password'];
	
	$con = new mysqli('localhost','root', '','login');
	$statement = $con->prepare('SELECT * FROM login_info WHERE uname = ?');
	$statement->bind_param('s', $username);
	$statement->execute();
	
	$user = $statement->get_result()->fetch_object();
	
	if(!empty($user)) {
		if(verifyPassword($user->password, $password)) {
			echo "<h1>"."Login success!!!"."</h1>";
			$_SESSION['log']=1;
			header("refresh:2;url=welcome.php");
		}
		else {
			echo 'Wrong Password Given';
		}
	}
	else {
		echo 'No User with username: '.$username;
	}
}

function verifyPassword($p1, $p2) {
    return $p2 == $p1;
}
