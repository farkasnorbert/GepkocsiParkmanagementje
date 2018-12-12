<?php
include 'mysql.php';
if (!empty($_POST)) {
    $auto = $_POST["auto"];
    $sofor =$_POST["sofor"];
    $indulas = $_POST["indulas"];
    $erkezes = $_POST["erkezes"];
    $celpont = $_POST["celpont"];
    $utazasCelja = $_POST["utazasCelja"];
    $utasokSzama = $_POST["utasokSzama"];
    if(insert("utazas","Sofor,indulas,haza_erkezes,Celalomas,Utasok_szama,Utazas_celja,Alapot,Auto,Igenylo","")==0){

    }else{

    }
    $uId=json_decode(select("idUtazas","utazas",""),true)[1];
    for($i = 1;$i<=$utasokSzama;$i++){
        $utas= $_POST["utas{$i}"];
        $utas_tipus = $_POST["utast{$i}ipus"];
        insert("utazo","Nev,Utazo_tipus,Utazas_id",$utas.$utas_tipus.$uId);
    }
}