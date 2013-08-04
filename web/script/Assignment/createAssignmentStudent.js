
$(document).ready(function() { 
   
   
 var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; //January is 0!
        var yyyy = today.getFullYear();
        if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm} var today = mm+'-'+dd+'-'+yyyy;
        $('#datepicker').val(today);

        $('#datepicker').datepicker({
            format: 'dd-mm-yyyy',
            weekStart: '0'
        });
        
    $("#gdTable").pagination({
        items: $('dl-horizontal').length,
        itemsOnPage: 2,
        cssStyle: 'light-theme'
    });


    
});