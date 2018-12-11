<html lang="hu">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="jquery.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <script>
        function utasok() {
            var u = document.getElementById("utasokSzama").value;
            var ins = document.getElementById("utazasok");
            while (ins.hasChildNodes()) {
                ins.removeChild(ins.lastChild);
            }
            for(var i=1;i<=u;i++){
                var lable = document.createElement("label");
                lable.form = "utas" + i;
                lable.innerText = "Utas" + i + " nev";
                var input = document.createElement("input");
                input.type = "text";
                input.name = "utas" + i;
                input.id = "utas" + i;
                ins.appendChild(lable);
                ins.appendChild(input);
                ins.appendChild(document.createElement("br"));
            }
        }
    </script>
</head>
<body>
<div class="container">
    <form action="kervenfel.php" method="post">
        <div class="form-group" id="kerveny">
            <label for="sofor">Sofor</label>
            <input type="text" class="form-control" name="sofor" id="sofor">
            <label for="indulas">Indulas</label>
            <input type="date" class="form-control" name="indulas" id="indulas">
            <label for="erkezes">Erkezes</label>
            <input type="date" class="form-control" name="erkezes" id="erkezes">
            <label for="celpont">Celpont</label>
            <input type="text" class="form-control" name="celpont" id="celpont">
            <label for="utazasCelja">Utazas celja</label>
            <input type="text" class="form-control" name="utazasCelja" id="utazasCelja">
            <label for="utasokSzama">Utasok szama</label>
            <input type="number" class="form-control" name="utasokSzama" id="utasokSzama" onchange="utasok()">
            <div id="utazasok" class="form-group"/>
        </div>
    </form>
</div>
</body>
</html>
<?php
include 'mysql.php';

