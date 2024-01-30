<?php
$name = $_POST['name'];
$age = $_POST['age'];
if ($age < 18)
 print "Hello " . $name . " you are not authorized to visit this site.";
else
 print "Welcome " . $name . " to this site."
?>
