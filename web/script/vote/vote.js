
$(document).ready(function() {
    /* create a node for the flip-to number */
    
    
    
    $('.votecard div').each(function(){
        
    
    $(this).children().clone().appendTo($(this));
    //var node = $(".votecard em:last strong")
    var node = $(this).children('em').next('em').children('strong');
    
    
    
    //$(this).next('strong').replaceWith("<strong>0</strong>");
    node.text(parseInt(node.text())+1);
     //$(this).replaceWith("<strong>294</strong><span>Votes</span>").clone().appendTo(".votecard pull-right div");
        
        
    });
    
    /* increment that by 1 */
    
    
    function flip(obj) {
        
        obj.prev().find("em").animate({
            top: '-=45'
        }, 200);
        obj.toggleClass("voted",true);
}
 
    $('.voteaction1').bind({
      click: function(event) {
        ///event.preventDefault();
        
      },
      mouseup: function() {
        flip($(this));
        // Add Data to Database
        
        
        
        $(this).unbind('mouseup');
      }
    });
    
    
    $('.voteaction').click(function(event){
        event.preventDefault();
        
        var hidMsgId= $(this).children(".hidMsgId").val();
        var hidUserId= $(this).children(".hidUserId").val();
        var hidPadId= $(this).children(".hidPadId").val();
        var hidPosId= $(this).children(".hidPosId").val();
        
                
        $.ajax({
            type:'GET',
            url:'http://localhost:8080/CampusLive/GDVoteAction.do?chatMsgId='+hidMsgId+'&chatUserId='+hidUserId+'&chatPadId='+hidPadId+'&chatPositionId='+hidPosId
        });
        
        flip($(this));
        $(this).unbind('click');
    });
 
});