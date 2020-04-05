<?php
$con=mysqli_connect("localhost", "skawns27", "skawnstkq27!", "skawns27");
mysqli_query($con, 'SET NAMES uft8');

$userId=$_POST["userID"];
$userPassword=$_POST["userPassword"];
$userName=$_POST["userName"];
$userSex=$_POST["userSex"];

$statement=mysql_prepare($con, "INSERT INTO USER VALUES (?,?,?,?)");//입력 받을 준비 ->DB
mysql_stmt_bind_param($statement, "sssi", $userID, $userPassword, $userName,
 $userSex);
mysqli_stmt_execute($statement);

$respond=array();
$respond["success"]=true;

$statement->close();

echo json_encode($respond);

$con->close();
?>
