 <?php
 $dbserver = "localhost";
 $dbusername = "root";
 $dbpassword = "";
 $dbname = "test";

 $conn = mysqli_connect($dbserver,$dbusername,$dbpassword, $dbname) or die("Unable to connect");

 
echo "great work";
?>