<?php
include 'mysql.php';
if ( isset( $_POST["haza_erkezes"] ) && isset( $_POST["indulas"] )) {
    $haza_erkezes = $_POST['haza_erkezes'];
    $indulas = $_POST['indulas'];
    $r=select("utazas.idUtazas,utazas.Alapot,utazas.indulas,utazas.haza_erkezes,utazas.Auto,auto.Nev","utazas INNER JOIN auto ON utazas.Auto=auto.idAuto","indulas >= '".$indulas."' and indulas <= '".$haza_erkezes."' or haza_erkezes >= '".$indulas."' and haza_erkezes <= '".$haza_erkezes."'");
    echo $r;
}
