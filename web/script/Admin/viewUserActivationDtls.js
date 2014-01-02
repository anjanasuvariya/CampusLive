function sendUserActivationDtlByMail()
{
    var chkUserActId = document.getElementsByName('chkUserActId');
    var userActIds ="";
    var flag = false;
        
    for(var i=0;i<chkUserActId.length;i++)
    {
        if(chkUserActId[i].checked)
        {
            if(userActIds == "")
            {
                userActIds =  chkUserActId[i].value; 
            }
            else
            {
                userActIds =userActIds +"~"+  chkUserActId[i].value; 
            }
            flag = true;
        }
    }
       
    
    try{
        if(flag)
        {
            return $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/CampusLive/sendUserActivationDtl.do?callmethod=sendUserActivationDtlByMail&userActIds='+userActIds,
                timeout: 5000,
                dataType: "json",
                success: function (data) {
                    
                    generate('topRight','Mail Sent','success');
                    generate('topRight','Click anywhere on the screen to GO back.','info');
                                        
                },
       
                error: function (xhr, ajaxOptions, thrownError){ 
                    alert(thrownError);
                    generate('topRight','Some Error Occured, Please try again.','error');
                    generate('topRight','Click anywhere on the screen to GO back.','info');
            
                }
            });   
        }
        else
        {
            generate('topRight','Please select at least one record.','warning');
            generate('topRight','Click anywhere on the screen to GO back.','info');
        }
     
    }
    catch(e)
    {
        alert(e);
    }
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

