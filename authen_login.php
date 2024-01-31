<?php
$servername = "localhost";
$username = "root"; $password = ""; $dbname = "rohit";

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

if (isset($_POST['user_id']) and isset($_POST['user_pass'])){
$username = $_POST['user_id'];
$password = $_POST['user_pass'];
$query = "SELECT * FROM `user_login` WHERE username='$username' and password='$password'";
$result = mysqli_query($conn, $query) or die(mysqli_error($conn));
$count = mysqli_num_rows($result);
if ($count >= 1){
echo "<script type='text/javascript'>alert('Login Credentials verified')</script>";
}else{
echo "<script type='text/javascript'>alert('Invalid Login Credentials')</script>";
}
} 
?>
