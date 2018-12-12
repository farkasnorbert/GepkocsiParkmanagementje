<?php
//index.php




?>
<!DOCTYPE html>
<html>
 <head>
  <title>Jquery Fullcalandar Integration with PHP and Mysql</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
  <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.min.js"></script>-->
  <script src="fullcalendar.js"></script>
  <script src="https://cdn.jsdelivr.net/qtip2/3.0.3/jquery.qtip.min.js"></script>
  <script>
   
  $(document).ready(function() {


   var calendar = $('#calendar').fullCalendar({
    editable:true,
    header:{
     left:'prev,next today',
     center:'title',
     right:'month,agendaWeek,agendaDay'
    },
    events: 'load.php',//betolti az adatbazisban levo elemeket
    selectable:true,// kilehet valasztani a napokat
    selectHelper:false,//8:10 nem ertem
    /* events: [ 

{"id":"46_l","title":"CustomEvent-Chargement","start":"2018-12-02","end":"2018-12-03","className":"customEventsClass","type":1},
{"id":"46_d","title":"Custom Event-Livraison","start":"2018-12-11","end":"2018-12-12","className":"customEventsClass","type":2}

],
*/	/* UJ ELEM HOZZAADASA
		 events: [
        {
            title: 'All Day Event',
            start: new Date(y, m, 1),
            description: 'long description',
            id: 1
        },
        {
            title: 'Long Event',
            start: new Date(y, m, d - 5),
            end: new Date(y, m, 1),
            description: 'long description3',
            id: 2
        }],
		

        eventRender: function(event, element) {
            element.qtip({
                content: event.description + '<br />' + event.start,
                style: {
                    background: 'black',
                    color: '#FFFFFF'
                },
                position: {
                    corner: {
                        target: 'center',
                        tooltip: 'bottomMiddle'
                    }
                }
            })
        },
		*/

    select: function(start, end, allDay) // tarolja amikor lefoglaltunk egy uj esemenyt
    {
     var title = prompt("Enter Event Title");//The prompt() method displays a dialog box that prompts the visitor for input.
     if(title)
     {
      var start = $.fullCalendar.formatDate(start, "Y-MM-DD HH:mm:ss");
      var end = $.fullCalendar.formatDate(end, "Y-MM-DD HH:mm:ss");
      $.ajax({ //ha hozzadunk u jadatot automatikusan frissuljon
       url:"insert.php",
       type:"POST",
       data:{title:title, start:start, end:end}, //mekyik adatokat kuldjuk a szervernek
       success:function()
       {
        calendar.fullCalendar('refetchEvents');//ujratolti a naptarat (refetchEvents bepitett)
        alert("Added Successfully");//pop up massage
       }
      })
     }
    },
    editable:true,
    eventResize:function(event) // ez nem fog kelleni h
    {
     var start = $.fullCalendar.formatDate(event.start, "Y-MM-DD HH:mm:ss");
     var end = $.fullCalendar.formatDate(event.end, "Y-MM-DD HH:mm:ss");
     var title = event.title;
     var id = event.id;
     $.ajax({
      url:"update.php",
      type:"POST",
      data:{title:title, start:start, end:end, id:id}, //mekyik adatokat kuldjuk a szervernek
      success:function(){
       calendar.fullCalendar('refetchEvents');
       alert('Event Update');
      }
     })
    },

    eventDrop:function(event) //mododsitjuk a napokat
    {
     var start = $.fullCalendar.formatDate(event.start, "Y-MM-DD HH:mm:ss");
     var end = $.fullCalendar.formatDate(event.end, "Y-MM-DD HH:mm:ss");
     var title = event.title;
     var id = event.id;
     $.ajax({
      url:"update.php",
      type:"POST",
      data:{title:title, start:start, end:end, id:id},
      success:function()
      {
       calendar.fullCalendar('refetchEvents');
       alert("Event Updated");
      }
     });
    },

    eventClick:function(event) //beepitett fugveny
    {
     if(confirm("Are you sure you want to remove it?"))
     {
      var id = event.id;
      $.ajax({
       url:"delete.php",
       type:"POST",
       data:{id:id},
       success:function()
       {
        calendar.fullCalendar('refetchEvents');
        alert("Event Removed");
       }
      })
     }
    },

   });
  });
   
  </script>
 </head>
 <body>
  <div class="container">
   <div id="calendar"></div>
  </div>
 </body>
</html>