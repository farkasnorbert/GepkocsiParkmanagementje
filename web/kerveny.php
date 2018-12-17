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
                lable.form = "utas"+i;
                lable.innerText = "Utas" + i + " nev";
                var lable2 = document.createElement("label");
                lable2.form = "utas" + i+"tipus";
                lable2.innerText = "Utas" + i + " tipus";
                var input = document.createElement("input");
                var input2 = document.createElement("input");
                input.type = "text";
                input.name = "utas" + i;
                input.id = "utas" + i;
                input.class = "form-control";
                input2.class = "form-control";
                input2.type = "text";
                input2.name = "utas"+i+"tipus";
                input2.id = "utas"+i+"tipus";
                ins.appendChild(lable);
                ins.appendChild(input);
                ins.appendChild(lable2)
                ins.appendChild(input2);
                ins.appendChild(document.createElement("br"));
            }
        }
    </script>
</head>
<body>
<div class="container">
    <form action="kervenfel.php" method="post">
        <div class="form-group">
            <label for="auto">Auto</label>
            <select name="auto" class="form-control" id="auto">
                <?php
                include 'mysql.php';
                if (!empty($_POST)) {
                    $indulas = $_POST["start"];
                    $erkezes = $_POST["end"];
                }else{
                    $indulas = "";
                    $erkezes = "";
                }
                $a=select("idAuto,Nev","auto","1");
                $autok=json_decode($a, true);
                foreach ($autok as $auto){
                    $a = json_decode($auto,true);
                    echo "<option value='{$a['idAuto']}'>".$a["Nev"]."</option>";
                }
                ?>
            </select>
            <label for="sofor">Sofor</label>
            <select class="form-control" name="sofor" id="sofor">
            <?php
            $v=select("felhasznalok.idFelhasznalok,felhasznalok.Nev","felhasznalok INNER JOIN felhasznalo_tipus ON felhasznalok.idFelhasznalok=felhasznalo_tipus.Felhasznalo_id","felhasznalo_tipus.Vezeto=1");
            $vezetok=json_decode($v, true);
            foreach ($vezetok as $vezeto){
                $v = json_decode($vezeto,true);
                echo "<option value='{$v['idFelhasznalok']}'>".$v["Nev"]."</option>";
            }
            ?>
            </select>
            <label for="indulas">Indulas</label>
            <?php
            echo "<input type='date' class='form-control' name='indulas' id='indulas' value='{$indulas}'>";
            ?>
            <label for="erkezes">Erkezes</label>
            <?php
            echo "<input type='date' class='form-control' name='erkezes' id='erkezes' value='{$erkezes}'>";
            ?>
            <label for="celpont">Celpont</label>
            <input type="text" class="form-control" name="celpont" id="celpont">
            <label for="utazasCelja">Utazas celja</label>
            <input type="text" class="form-control" name="utazasCelja" id="utazasCelja">
            <label for="utasokSzama">Utasok szama</label>
            <input type="number" class="form-control" name="utasokSzama" id="utasokSzama" onchange="utasok()">
            <input type="submit" class="form-control">
            <div id="utazasok"/>
        </div>
    </form>
</div>
</body>
</html>

