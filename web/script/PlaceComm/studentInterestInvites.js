/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//$(document).ready(function() { 
//        
//    $('#btnSaveInvtDtl').click(function(e) {
//        
//        e.preventDefault();
//        var invtDtlId=$("#invtDtlId").val();
//        var companyId=$("#companyId").val();
//        var jobDesc=$("#jobDesc").val();
//        var lastDate=$("#lastDate").val();
//        var jobDescDoc=$("#jobDescDoc").val();
//        var otherDetails=$("#otherDetails").val();
//            
//        var param = 'invtDtlId='+invtDtlId+'&companyId='+companyId+'&jobDesc='+jobDesc
//        +'&lastDate='+lastDate+'&jobDescDoc='+jobDescDoc+'&otherDetails='+otherDetails+'&callmethod=saveInvtDtls';
//            
//        saveInvtDtlsUsingAjax(param);
//       
//    });
//    
//}); 

function saveStudentInvtDtls(rowCnt,intInvtId,studAction)
{
    var studSelectionFlag=studAction;
    var addOrUpdateFlag ='';
    var studIntInvtId = $("#hdnStdInvtDtlId"+rowCnt).val();
    
    if(studIntInvtId == '')
    {
        addOrUpdateFlag = 'Add';
    }
    else
    {
        addOrUpdateFlag = 'Update';
    }
    
    var param = 'studSelectionFlag='+studSelectionFlag+'&intInvtId='+intInvtId+'&studIntInvtId='+studIntInvtId
    +'&addOrUpdateFlag='+addOrUpdateFlag+'&callmethod=saveStudentIntInvtDtls';
    saveStudentInvtDtlsUsingAjax(param,studSelectionFlag,rowCnt,intInvtId);
    
}

function saveStudentInvtDtlsUsingAjax(param,studSelectionFlag,rowCnt,intInvtId){


    return $.ajax({
        type: 'GET',
        url: 'http://localhost:23236/CampusLive/saveStudentInterestInviteDtl.do?'+param,
        timeout: 5000,
        dataType: "json",
        success: function (data) {
          
            var studInvtDtlId=0;
            
            $.each(data, function(key){
       
                if(key=="studInvtDtlId"){
                    studInvtDtlId=data[key];
                }
                
            }); 
            if(studInvtDtlId>0){
                
                $("#hdnStdInvtDtlId"+rowCnt).val(studInvtDtlId);
               
                var obj = document.getElementById("trStudInvId"+rowCnt);
                var row = $(obj).closest("tr").get(0);
                if(studSelectionFlag == 'A')
                {
                    $('#tblStudInvtDtls').find(row).find('td:eq(5)').html("Applied");
                    //$('#tblStudInvtDtls').find(row).find('td:eq(7)').text("Reject");
                  $('#tblStudInvtDtls').find(row).find('td:eq(7)').html('<a id="lnkApply'+rowCnt+'" onclick="saveStudentInvtDtls('+rowCnt+','+intInvtId+',A)" style="color:red">Reject</a>');
                }
                else
                {
                    $('#tblStudInvtDtls').find(row).find('td:eq(5)').html("Rejected");
                    $('#tblStudInvtDtls').find(row).find('td:eq(7)').html('<a id="lnkApply'+rowCnt+'" onclick="saveStudentInvtDtls('+rowCnt+','+intInvtId+',R)">Apply</a>');
                   // $('#tblStudInvtDtls').find(row).find('td:eq(7)').text("Apply")
                }
                 
                generate('topRight','Saved Successfully.','success');
                generate('topRight','Click anywhere on the screen to GO back.','info'); 
       
            }
        },
       
        error: function (xhr, ajaxOptions, thrownError){ 
            alert(thrownError);
            generate('topRight','Some Error Occured, Please try again.','error');
            generate('topRight','Click anywhere on the screen to GO back.','info');
            
        }
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



