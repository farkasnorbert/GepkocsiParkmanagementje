<?php
include 'mysql.php';
if (!empty($_POST)) {
    $auto = $_POST["auto"];
    $sofor = $_POST["sofor"];
    $indulas = date("Y-m-d", strtotime($_POST["indulas"]));
    $erkezes = date("Y-m-d", strtotime($_POST["erkezes"]));
    $celpont = $_POST["celpont"];
    $utazasCelja = $_POST["utazasCelja"];
    $utasokSzama = $_POST["utasokSzama"];
    $utazasid = $_POST["idUtazas"];
    update("utazas","Sofor",$sofor,"idUtazas=".$utazasid);
    update("utazas","indulas",$indulas,"idUtazas=".$utazasid);
    update("utazas","haza_erkezes",$erkezes,"idUtazas=".$utazasid);
    update("utazas","Celalomas",$celpont,"idUtazas=".$utazasid);
    update("utazas","Utazas_celja",$utazasCelja,"idUtazas=".$utazasid);
    update("utazas","Utasok_szama",$utasokSzama,"idUtazas=".$utazasid);
}