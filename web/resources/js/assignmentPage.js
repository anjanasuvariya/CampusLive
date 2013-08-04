

$(document).ready(function() { 
    
 //   alert("Loading Page Assignments");
    
 //manageGroups.do k liye Validation...   
 $("#createGroup").validationEngine();
 
 
    $('#snapshot-container').freetile({
	animate: true,
	elementDelay: 30
});

    $('.projectThumb').adipoli({
    'startEffect' : 'transparent',  //grayscale,normal,overlay,transparent
    'hoverEffect' : 'popout'   
    //boxRainGrow,popout
    });

    
});