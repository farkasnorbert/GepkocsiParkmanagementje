window.onload = function () {
    var datum = new Date();
    var honap = datum.getMonth()+1;
    var ev = datum.getFullYear();
    tablazat(honap,ev);
    document.getElementById("nap"+datum.getDate().toString()).style.backgroundColor="LightBlue";
};
function napokahonapba (honap, ev) {
    return new Date(ev, honap, 0).getDate();
}
function honapnev(honap){
    switch(honap){
        case 1:
            return "Január";
        case 2:
            return "Február";
        case 3:
            return "Március";
        case 4:
            return "Április";
        case 5:
            return "Május";
        case 6:
            return "Június";
        case 7:
            return "Július";
        case 8:
            return "Augusztus";
        case 9:
            return "Szeptember";
        case 10:
            return "Október";
        case 11:
            return "November";
        case 12:
            return "December";
    }
}
function uresbal(elsonap){
    var tablazat = "";
    var day = 1;
    if(elsonap.getDay()==0){
        tablazat += "<tr><td></td><td></td><td></td><td></td><td></td><td></td><td id='nap1'>1</td>" ;
        day++;
    }else {
        tablazat += "<tr>";
        var i;
        for( i=1; i < elsonap.getDay(); i++){
            tablazat += "<td></td>";
        }
        for( i=elsonap.getDay(); i < 7; i++){
            tablazat += "<td id='nap"+day.toString()+"'>"+ day.toString() + "</td>";
            day++;
        }
        tablazat += "<td id='nap"+day.toString()+"'>"+ day.toString() + "</td>";
        day++;
    }
    tablazat += "</tr>";
   // console.log(tablazat);
    return [day,tablazat];
}
function tobbi(nap,napokszama){
    var tablazat = "<tr>";
    var i=1;
    while(nap<=napokszama){
        if(i>7){
            tablazat += "</tr><tr>";
            i=1;
        }
        tablazat += "<td id='nap"+nap.toString()+"'>" + nap.toString() + "</td>";
        nap++;
        i++;
    }
    return tablazat + "</tr>";
}
function feltolt(elsonap,napokszama) {
    var indulas=elsonap.getFullYear().toString()+"-"+(elsonap.getMonth()+1).toString()+"-01 00:00:00";
    var haza_erkezes=elsonap.getFullYear().toString()+"-"+(elsonap.getMonth()+1).toString()+"-"+napokszama.toString()+" 23:59:59";
    $.ajax({
        data: 'indulas=' + indulas+"&haza_erkezes="+haza_erkezes,
        url: 'betoltes.php',
        method: 'POST',
        success: function(msg) {
            var r = JSON.parse(msg);
            for (var x in r){
                var o = JSON.parse(r[x]);
                var indulas=parseInt(o["indulas"].substr(8,2));
                var erkezes=parseInt(o["haza_erkezes"].substr(8,2));
                var c;
                if(o["Alapot"]==0){
                    c="Red";
                }else{
                    c="Green";
                }
                var i;
                if(indulas<=erkezes) {
                    for ( i=indulas;i<=erkezes;i++){
                        document.getElementById("nap"+i.toString()).innerHTML += "<br><form action='utazas.php' method='post'><button id='idUtazas' type='submit' class='btn btn-info' value='"+o["idUtazas"]+"' style='background-color: "+c+"'>"+o["Nev"]+"</button></form>"
                    }
                }else{
                    for ( i=indulas;i<=napokszama;i++){
                        document.getElementById("nap"+i.toString()).innerHTML += "<br><form action='utazas.php' method='post'><button id='idUtazas' type='submit' class='btn btn-info' value='"+o["idUtazas"]+"' style='background-color: "+c+"'>"+o["Nev"]+"</button></form>"
                    }
                }
            }
        }
    });
}
function tablazat(honap,ev){
    document.getElementById("honap").innerHTML = "<h1 align='center' id='honapev'>" + honapnev(honap)+" . "+ev.toString()+"</h1>";
    var napokszama = napokahonapba(honap,ev);
    var elsonap = new Date(ev,honap-1,1,0,0,0,0);
    var x=uresbal(elsonap);
    var tablazat =x[1];
    var nap = x[0];
    tablazat += tobbi(nap,napokszama);
    document.getElementById("tablazat").innerHTML= tablazat;
    feltolt(elsonap,napokszama);
}
function honapszam(honap) {
    switch (honap) {
        case "Január":
            return 1;
        case "Február":
            return 2;
        case "Március":
            return 3;
        case "Április":
            return 4;
        case "Május":
            return 5;
        case "Június":
            return 6;
        case "Július":
            return 7;
        case "Augusztus":
            return 8;
        case "Szeptember":
            return 9;
        case "Október":
            return 10;
        case "November":
            return 11;
        case "December":
            return 12;
    }
}
function mozgas(irany) {
    var x=document.getElementById("honapev").innerHTML;
    var honaps = x.substr(0,x.indexOf(' '));
    var evs = x.substr(x.indexOf(' ')+3,x.length);
    honap = honapszam(honaps,evs);
    ev = parseInt(evs);
    if(irany == 1 && honap==12){
        ev+=1;
        honap=1;
    }else if(irany == -1 && honap==1){
        ev -= 1;
        honap = 12;
    }else{
        honap += irany;
    }
    tablazat(honap,ev);
    //console.log(honap);
    //console.log(ev);

}