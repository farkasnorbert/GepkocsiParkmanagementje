<?php
function connect() {
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "mydb";
    $conn = mysqli_connect($servername, $username, $password, $dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }else
        return $conn;
}
function select($columns,$table,$where){
    $sql = "select ".$columns." from ".$table." where ".$where;
    //echo $sql;
    $conn = connect();
    $result = mysqli_query($conn, $sql);
    $r = array();
    $i = 1;
    if (mysqli_num_rows($result) > 0) {
        while ($row = mysqli_fetch_assoc($result)) {
            $r[$i]=json_encode($row);
            $i++;
        }
    }
    mysqli_close($conn);
    return json_encode($r);
}
function insert($table,$columns,$data){
    $sql = "INSERT INTO ".$table." (".$columns.") values (".$data.")";
    $conn = connect();
    if(mysqli_query($conn, $sql)){
        mysqli_close($conn);
        return 0;
    }else{
        return $sql.mysqli_error($conn);
    }
}
function update($table,$column,$data,$where){
    $sql = "UPDATE ".$table." SET ".$column."=".$data." where ".$where;
    $conn = connect();
    if (mysqli_query($conn, $sql)) {
        mysqli_close($conn);
        return 0;
    } else {
        return mysqli_error($conn);
    }
}