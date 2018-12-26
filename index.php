<?php
session_start();
?>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
</head>
<body>
	<form method="POST" action="login.php">
		<table align= "center" border="2">
			<tr>
				<td>Username :</td>
				<td><input type= "text" name="uname" required></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type= "password" name="password" required></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type= "submit" value="Login" name="submit"></td>
			</tr>
			
		</table>
</form>

</body>
</html>
<?php
session_destroy();
?>
