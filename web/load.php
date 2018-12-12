<?php

//load.php

$connect = new PDO('mysql:host=localhost;dbname=mydb', 'root', '');

$data = array();

$query = "SELECT * FROM utazas 
		INNER JOIN auto ON utazas.Auto= auto.idAuto";

$statement = $connect->prepare($query);

$statement->execute();

$result = $statement->fetchAll();

foreach($result as $row)
{
 $data[] = array(
  'id'   => $row["idUtazas"],
  'title'   => "Hova:".$row["Celalomas"]." "."Auto:".$row["Nev"],
   'start'   => $row["indulas"],
  'end'   => $row["haza_erkezes"]
 );
}

echo json_encode($data);

?>