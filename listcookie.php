<html>
<head> <title> Cookie </title> </head>
<body bgcolor="GreenYellow">
<center>
<form action="" method="post">
 <input type="submit" value="LIST COOKIES" name="list">
</form>
</center>
<?php
error_reporting(0);
if($_POST['list'])
{
foreach($_COOKIE as $key=>$val)
{
echo "<center>".$key." is ".$val."<br>
</center>";
}
}
?>
</body>
</html>
