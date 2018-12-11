<html lang="hu">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="jquery.min.js"></script>
    <script src="bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <?php
    include 'mysql.php';
    if (!empty($_POST)) {
        $utazasid = $_POST["idUtazas"];
        $u=select("idUtazas,Sofor,indulas,haza_erkezes,Celalomas,Utasok_szama,Utazas_celja,Auto,Igenylo","utazas","idUtazas=".$utazasid);
        $utazas=json_decode($u, true);
        echo $utazas[1];
        $utazas=json_decode($utazas[1],true);

        ?>
        <div class="container">
            <form action="valtoztat.php" method="post">
                <div class="form-group">
                    <label for=""></label>
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
