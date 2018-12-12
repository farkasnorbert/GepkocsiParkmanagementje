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
            for (var i = 1; i <= u; i++) {
                var lable = document.createElement("label");
                lable.form = "utas" + i;
                lable.innerText = "Utas" + i + " nev";
                var lable2 = document.createElement("label");
                lable2.form = "utas" + i + "tipus";
                lable2.innerText = "Utas" + i + " tipus";
                var input = document.createElement("input");
                var input2 = document.createElement("input");
                input.type = "text";
                input.name = "utas" + i;
                input.id = "utas" + i;
                input2.type = "text";
                input2.name = "utas" + i + "tipus";
                input2.id = "utas" + i + "tipus";
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
    <?php
    include 'mysql.php';
    if (!empty($_POST)) {
        $utazasid = $_POST["idUtazas"];
        $u = select("idUtazas,Sofor,indulas,haza_erkezes,Celalomas,Utasok_szama,Utazas_celja,Auto,Igenylo", "utazas", "idUtazas=" . $utazasid);
        $utazas = json_decode($u, true);
        //echo $utazas[1];
        $utazas = json_decode($utazas[1], true);

        ?>
        <div class="container">
            <form action="valtoztat.php" method="post">
                <div class="form-group">
                    <label for="auto">Auto</label>
                    <select name="auto" class="form-control">
                        <?php
                        $a = select("idAuto,Nev", "auto", "1");
                        $autok = json_decode($a, true);
                        foreach ($autok as $auto){
                            $a = json_decode($auto,true);
                            if($a["idAuto"]==$utazas["Auto"]){
                                echo "<option value='{$a['idAuto']}' selected>" . $a["Nev"] . "</option>";
                            }else {
                                echo "<option value='{$a['idAuto']}'>" . $a["Nev"] . "</option>";
                            }
                        }
                        ?>
                    </select><br>
                    <label for="sofor">Sofor</label>
                    <?php
                    echo "<input type='text' class='form-control' name='sofor' id='sofor' value='".$utazas["Sofor"]."'>";
                    ?><br>
                    <label for="indulas">Indulas</label>
                    <?php
                    echo "<input type='datetime-local' class='form-control' name='indulas' id='indulas' value='".$utazas["indulas"]."'>";
                    ?><br>
                    <label for="erkezes">Erkezes</label>
                    <?php
                    echo "<input type='datetime-local' class='form-control' name='erkezes' id='erkezes' value='".$utazas["haza_erkezes"]."'>";
                    ?><br>
                    <label for="celpont">Celpont</label>
                    <?php
                    echo "<input type='text' class='form-control' name='celpont' id='celpont' value='".$utazas["Celalomas"]."'>";
                    ?><br>
                    <label for="utazasCelja">Utazas celja</label>
                    <?php
                    echo "<input type='text' class='form-control' name='utazasCelja' id='utazasCelja' value='".$utazas["Utazas_celja"]."'>";
                    ?><br>
                    <label for="utasokSzama">Utasok szama</label>
                    <?php
                    echo "<input type='number' class='form-control' name='utasokSzama' id='utasokSzama' value='".$utazas["Utasok_szama"]."'>";
                    ?><br>
                    <div id="utazasok" class="form-group">
                        <?php
                        $ut = select("*","utazo","Utazas_id=".$utazas["idUtazas"]);
                        $utasok = json_decode($ut,true);
                        $i=1;
                        foreach ($utasok as $utas){
                            $azutas = json_decode($utas,true);
                            echo "<label for='utas{$i}'>Utas{$i} nev</label><input type='text' name'utas{$i}' id='utas{$i}' class='form-control' value='{$azutas['Nev']}'";
                            echo "<label for='utas{$i}tipus'>Utas{$i} tipus</label><input type='text' name'utas{$i}tipus' id='utas{$i}tipus' class='form-control' value='{$azutas['Utazo_tipus']}'";
                            $i +=1;
                        }
                        ?>
                    </div>
                </div>
            </form>
        </div>
        <?php
    } else {
        ?><h1>Hiba</h1><?php
    }
    ?>
</div>
</body>
</html>
