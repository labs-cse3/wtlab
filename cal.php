<?php
$num1 = ($_POST['num1']);
$num2 = ($_POST['num2']);
$func= ($_POST['func']);
if(is_numeric($num1) &&is_numeric($num2) )
{	if($func != null)
{	switch($func)
{	
case "+" :	$result= $num1 + $num2;    break;
case "-" :	$result= $num1 - $num2;     break;
case "*" :	$result= $num1 * $num2;     break;
case "/" :	$result= $num1 / $num2;     break;
case "%" :	$result= $num1 % $num2;  break;
}
echo("calculation result: ". $result);
}
     	 }
?>
