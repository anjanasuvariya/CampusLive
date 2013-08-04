

$(document).ready(function() { 
    
    //alert("Loading Page");
    $('#gdTable').dataTable();
    $('#gdTableCampus').dataTable();
    $('#gdTableOpen').dataTable();

    function gdClickAddRowGUI(gdSubject,gdDesc,gdId) {
        alert("GDID:"+gdId);

	$('#gdTable').dataTable().fnAddData( [
		'<td>'+gdSubject+'</td>',
		'<td>'+gdDesc+'</td>',gdId,
		'<td><a href="LoadDiscussion.do?method=execute1&chatPadId='+gdId+'&chatPadName='+gdSubject+'">Join</a></td>' 
        ] );  
    }
    
    function gdClickAddRowGUICampus(gdSubject,gdDesc,gdId) {
        alert("GDID:"+gdId);

	$('#gdTableCampus').dataTable().fnAddData( [
		'<td>'+gdSubject+'</td>',
		'<td>'+gdDesc+'</td>',gdId,
		'<td><a href="LoadDiscussion.do?method=execute1&chatPadId='+gdId+'&chatPadName='+gdSubject+'">Join</a></td>' 
        ] );  
    }
    
    function gdClickAddRowGUIOpen(gdSubject,gdDesc,gdId) {
        alert("GDID:"+gdId);

	$('#gdTableOpen').dataTable().fnAddData( [
		'<td>'+gdSubject+'</td>',
		'<td>'+gdDesc+'</td>',gdId,
		'<td><a href="LoadDiscussion.do?method=execute1&chatPadId='+gdId+'&chatPadName='+gdSubject+'">Join</a></td>' 
        ] );  
    }

//////////////////////////////////////////////////////////  Secret
    $('#insertGDSecret').click(function() { 
        $.blockUI( { 
                      message: $('#insertGDFormSecret')
                    }
        ); 
       $('.blockOverlay').attr('title','Click to Go Back').click($.unblockUI); 
    }); 
//////////////////////////////////////////////////////////  Campus
    $('#insertGDCampus').click(function() { 
        $.blockUI( { 
                      message: $('#insertGDFormCampus')
                    }
        ); 
       $('.blockOverlay').attr('title','Click to Go Back').click($.unblockUI); 
    }); 
///////////////////////////////////////////////////////////  Open    
    $('#insertGDOpen').click(function() { 
        $.blockUI( { 
                      message: $('#insertGDFormOpen')
                    }
        ); 
       $('.blockOverlay').attr('title','Click to Go Back').click($.unblockUI); 
    }); 
    
/////////////////////////////////////////////////////////////////////
    
   $('#submitGDSecret').click(function(e) {
       e.preventDefault();
       var gdSubject=$("#gdSubject").val();
       var gdDesc=$("#gdDesc").val();
       alert("gdSubject is "+gdSubject+" with Description "+gdDesc );
       var gdType = 'Secret';
       
       var promise_gdId = createGD_DB(gdSubject, gdDesc , gdType);
       
       promise_gdId.success(function (data) {
        alert(data);
        var gdId=0;
        var gdSubject=$("#gdSubject").val();
        var gdDesc=$("#gdDesc").val();
                  alert("Result is:"+data+"nd result type is:"+data.toString());
                  $.each(data, function(key){
                    if(key=="gdId")
                    gdId=data[key];
                    alert("Final gdId is:"+gdId);
                  }); 
        if(gdId>0){ gdClickAddRowGUI(gdSubject,gdDesc,gdId); }
       });
  
       
       
       generate('topRight','Personal Discussion Created Successfully. Join NOW to post your Comments.','success');
       generate('topRight','Click anywhere on the screen to GO back.','info'); 
  
       
 });
 
 $('#submitGDCampus').click(function(e) {
       e.preventDefault();
       var gdSubject=$("#gdSubjectCampus").val();
       var gdDesc=$("#gdDescCampus").val();
       alert("gdSubject is "+gdSubject+" with Description "+gdDesc );
       var gdType = 'Campus';
       
       var promise_gdId = createGD_DB(gdSubject, gdDesc , gdType);
       
       promise_gdId.success(function (data) {
        alert(data);
        var gdId=0;
        var gdSubject=$("#gdSubject").val();
        var gdDesc=$("#gdDesc").val();
                  alert("Result is:"+data+"nd result type is:"+data.toString());
                  $.each(data, function(key){
                    if(key=="gdId")
                    gdId=data[key];
                    alert("Final gdId is:"+gdId);
                  }); 
        if(gdId>0){ gdClickAddRowGUICampus(gdSubject,gdDesc,gdId); }
       });
  
       
       
       generate('topRight','Campus Discussion Created Successfully. Join NOW to post your Comments.','success');
       generate('topRight','Click anywhere on the screen to GO back.','info'); 
  
       
 });
 
 
 $('#submitGDOpen').click(function(e) {
       e.preventDefault();
       var gdSubject=$("#gdSubjectOpen").val();
       var gdDesc=$("#gdDescOpen").val();
       alert("gdSubject is "+gdSubject+" with Description "+gdDesc );
       var gdType = 'Open';
       
       var promise_gdId = createGD_DB(gdSubject, gdDesc , gdType);
       
       promise_gdId.success(function (data) {
        alert(data);
        var gdId=0;
        var gdSubject=$("#gdSubjectOpen").val();
        var gdDesc=$("#gdDescOpen").val();
                  alert("Result is:"+data+"nd result type is:"+data.toString());
                  $.each(data, function(key){
                    if(key=="gdId")
                    gdId=data[key];
                    alert("Final gdId is:"+gdId);
                  }); 
        if(gdId>0){ gdClickAddRowGUIOpen(gdSubject,gdDesc,gdId); }
       });
  
       
       
       generate('topRight','Public Discussion Created Successfully. Join NOW to post your Comments.','success');
       generate('topRight','Click anywhere on the screen to GO back.','info'); 
  
       
 });
    
    
    }); 



function createGD_DB(gdSubject,gdDesc,gdType){

        return $.ajax({
              type: 'GET',
              url: 'http://localhost:8080/CampusLive/GDCreateAction.do?gdSubject='+gdSubject+'&gdDesc='+gdDesc+'&gdType='+gdType,
              timeout: 5000,
              dataType: "json",
              success: function(result){ alert("success");
      },
              error: function (xhr, ajaxOptions, thrownError){ alert("error"); }
        });
        
}
function generate(layout,text,type) {
    
     var n =    noty({
  		text: text,
  		type: type,
                dismissQueue: true,
  		layout: layout,
                timeout:6500,
                closeWith: ['click','button'],
  		theme: 'defaultTheme'
                
    });
  	console.log('html: '+n.options.id);
  }
  
  

    