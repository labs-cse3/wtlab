<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "databaseg3";
$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sqlCreateTable = "CREATE TABLE login (
    username VARCHAR(30) NOT NULL,
    upassword VARCHAR(255) NOT NULL
)";

if (mysqli_query($conn, $sqlCreateTable)) {
    echo "Table created successfully";
} else {
    echo "Error creating table: " . mysqli_error($conn);
}

$sqlInsertUser = "INSERT INTO login (username, upassword) VALUES ('Virat', '1234')";

if (mysqli_query($conn, $sqlInsertUser)) {
    echo "User inserted successfully";
} else {
    echo "Error inserting user: " . mysqli_error($conn);
}

if (isset($_POST["username"]) && isset($_POST["password"])) {
    $username = $_POST["username"];
    $password = $_POST["password"];

    $query = "SELECT * FROM `login` WHERE username='$username' AND upassword='$password'"; 
    $result = mysqli_query($conn, $query) or die(mysqli_error($conn));
    
    $count = mysqli_num_rows($result);
    
    if ($count == 1) {
        echo "<script type='text/javascript'>alert('LOGIN VERIFIED')</script>";
    } else {
        echo "<script type='text/javascript'>alert('USERNAME OR PASSWORD INCORRECT')</script>";
    }
}
?>

