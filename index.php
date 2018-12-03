<?php
//THIS IS CONNECTION TO DB
	$server = "db.cs.dal.ca";
	$username = "zqiu";
	$pass = "B00791470";
	$dbName = "zqiu";

	$conn = new mysqli($server, $username, $pass, $dbName);
	//IF I AM NOT ABLE TO CONNECT BY SOME REASON
	if($conn === false){
		echo "Data Base Connection Problem!";
		die();
	}
//----------------------------///
	$userExists = true;
	if(isset($_POST['submit'])){
		$username = $_POST['uName'];
		$pass = $_POST['pWord'];

		$sql = "SELECT * from User where Name = '$username' and Password = '$pass'";

		$res = $conn->query($sql);
		//res is the returned object after running querry
		if ($res->num_rows == 0) {
			$userExists = false;
		}
		else if ($res->num_rows == 1) {
			$userExists = true;
			$data = $res->fetch_assoc();
			//THIS FUNCTION RETURNS ARRAY
			
			$status = $data['Status'];
			$userID = $data['UserID'];
			if($status == "Children"){
				$url = "Children.php";
			}
			else{
				$url = "Parent.php?userid=".$userID;
			}

			header("Location: ".$url);
		}
	}


?>





<!DOCTYPE html>
<html>
<head>
	<!-- BOOTSTRAP STUFF -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
	<title>Database Project</title>
</head>
<body>
	<div class="jumbotron">
		<h1>Family Health</h1>
	</div>
	<div class="form-group" style="width: 50%; margin: auto;">
		<form action="index.php" method="post">
			<label>UserName:</label>
			<input class="form-control" type="text" name="uName">
			<label>Password:</label>
			<input class="form-control" type="password" name="pWord">
			<button class="btn btn-primary" type="submit" name="submit" >SUBMIT</button>
		</form>
			<a href="signUp.php">Sign Up For account here</a>
			<?php
			if ($userExists == false) {
			
			?>
				<p style="color: red">The user does not exists</p>
			<?php
			}
			?>
	</div>


</body>
</html>