<?php
//
	if(!(isset($_GET['userid']))){
		echo "YOU ARE NOT LOGGED IN!";
		die();
	}
	$userid = $_GET['userid'];
	$server = "db.cs.dal.ca";
	$username = "zqiu";
	$pass = "B00791470";
	$dbName = "zqiu";

	$conn = new mysqli($server, $username, $pass, $dbName);
	if($conn === false){
		echo "Data Base Connection Problem!";
		die();
	}
	$sql = "SELECT * from `Parent-User` where UserID = '$userid'";
	
	$res = $conn->query($sql);

	$data = $res->fetch_assoc();
	//print_r($data);
	$ht = $data['Height'];
	$wt = $data['Weight'];
	$bp = $data['BloodPressure'];
	$hr = $data['HeartRate'];

	if (isset($_POST['submit'])) {
		$ht = $_POST['ht'];
		$wt = $_POST['wt'];
		$bp = $_POST['Bp'];
		$hr = $_POST['hr'];

		$sql = "UPDATE `Parent-User` SET `Height` = '$ht', `Weight` = '$wt', `BloodPressure`= '$bp', `HeartRate` = '$hr' WHERE `Parent-User`.`UserID` = $userid";

		$res = $conn->query($sql);
		// if ($res != false) {
		// 	echo "SUCCESSFUL";
		// }
	//	echo "$sql";
	

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
		<h1>Parent User</h1>
	</div>

	<div class="form-group" style="width: 50%; margin: auto;">
		<form action="Parent.php?userid=<?php echo($userid); ?>" method="post">
			<label>Height:</label>
			<input class="form-control" type="text" name="ht" value="<?php echo($ht); ?>">
			<label>Weight:</label>
			<input class="form-control" type="text" name="wt" value="<?php echo($wt); ?>">
			<label>Blood Preasure:</label>
			<input class="form-control" type="text" name="Bp" value="<?php echo($bp); ?>">
			<label>Heart Rate:</label>
			<input class="form-control" type="text" name="hr" value="<?php echo($hr); ?>">
			<button class="btn btn-primary" type="submit" name="submit" >SUBMIT</button>
		</form>
	</div>


</body>
</html>