<?php
include 'mysql.php';
if (!empty($_POST)) {
    $auto = $_POST["auto"];
    $sofor =$_POST["sofor"];
    $indulas = date("Y-m-d", strtotime($_POST["indulas"]));
    $erkezes = date("Y-m-d", strtotime($_POST["erkezes"]));
    $celpont = $_POST["celpont"];
    $utazasCelja = $_POST["utazasCelja"];
    $utasokSzama = $_POST["utasokSzama"];
    $ins=insert("utazas","Sofor,indulas,haza_erkezes,Celalomas,Utasok_szama,Utazas_celja,Alapot,Auto,Igenylo",
            "'".$sofor."','".$indulas."','".$erkezes."','".$celpont."','".$utasokSzama."','".$utazasCelja."','0','".$auto."','1'");
    if($ins>0) {
        for($i = 1;$i<=$utasokSzama;$i++){
            $utas= $_POST["utas{$i}"];
            $utas_tipus = $_POST["utas{$i}tipus"];
            $in=insert("utazo","Nev,Utazo_tipus,Utazas_id","'".$utas."','".$utas_tipus."','".$ins."'");
        }
        header('Location: index.php');
    }
}