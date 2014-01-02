/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() { 
        
    $('#btnSaveInvtDtl').click(function(e) {
        
        e.preventDefault();
        var invtDtlId=$("#invtDtlId").val();
        var companyId=$("#companyId").val();
        var jobDesc=$("#jobDesc").val();
        var lastDate=$("#lastDate").val();
        var jobDescDoc=$("#jobDescDoc").val();
        var otherDetails=$("#otherDetails").val();
            
        var param = 'invtDtlId='+invtDtlId+'&companyId='+companyId+'&jobDesc='+jobDesc
        +'&lastDate='+lastDate+'&jobDescDoc='+jobDescDoc+'&otherDetails='+otherDetails+'&callmethod=saveInvtDtls';
            
        saveInvtDtlsUsingAjax(param);
       
    });
    
}); 


function saveInvtDtlsUsingAjax(param){

    return $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/CampusLive/saveInterestInviteDtl.do?'+param,
        timeout: 5000,
        dataType: "json",
        success: function (data) {
          
            var invtDtlId=0;
            
            $.each(data, function(key){
       
                if(key=="invtDtlId"){
                    invtDtlId=data[key];
                }
                
            }); 
            if(invtDtlId>0){
                var invtId=$("#invtDtlId").val();
                if(invtId != '')
                {
                    var rowId = document.getElementById("hdnRowId").value;
                    var row = document.getElementById(rowId);
                    updateInvtRowData(row); 
                }
                else
                {
                    document.getElementById('invtDtlId').value =invtDtlId;        
                    addNewInvtRowData();
                    resetData();
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

function addNewInvtRowData()
{
    try{
        
        var invtDtlId=$("#invtDtlId").val();
        var companyId=$("#companyId").val();
        var companyName=$("#companyId :selected").text();
        var jobDesc=$("#jobDesc").val();
        var lastDate=$("#lastDate").val();
        var jobDescDoc=$("#jobDescDoc").val();
        var otherDetails=$("#otherDetails").val();
        
        var invtDtlsTableCnt = $("#hdnInvtDtlCnt").val();
  
        $('#tblInvtDtls').dataTable().fnAddData( [
            '<td><input type="checkbox" name="chkInvtDtlId" id = "chkInvtDtlId'+Number(invtDtlsTableCnt)+'" value='+invtDtlId+'></td>',
            '<td>'+'<a data-toggle="modal" href="#myModal" onclick="populateInvtData(this,'+invtDtlId+','+companyId+')">'+companyName+'</a>'+'</td>',
            '<td>'+jobDesc+'</td>',
            '<td>'+lastDate+'</td>',
            '<td>Download</td>',
            '<td>'+otherDetails+'</td>',
            '<td><a data-toggle="modal" href="#applicationModal" >Show</a></td>',
            '<td align ="center"> <i class="icon-trash" onclick="deleteInvtDtls(N,'+invtDtlId+','+Number(invtDtlsTableCnt)+')"></i></td>' 
            ] );
          
         document.getElementById("hdnInvtDtlCnt").value=Number(invtDtlsTableCnt)+1;
    }
    catch(e)
    {
        alert(e);
    }
}

function updateInvtRowData(row)
{
    try{
        
        var invtDtlId=$("#invtDtlId").val();
        var companyId=$("#companyId").val();
        var companyName=$("#companyId :selected").text();
        var jobDesc=$("#jobDesc").val();
        var lastDate=$("#lastDate").val();
        var jobDescDoc=$("#jobDescDoc").val();
        var otherDetails=$("#otherDetails").val();
        
        var rowId = document.getElementById("hdnRowId").value;
        var rowCnt = rowId.substr(8);
   
        $('#tblInvtDtls').dataTable().fnUpdate( [
           '<td><input type="checkbox" name="chkInvtDtlId" id = "chkInvtDtlId'+Number(rowCnt)+'" value='+invtDtlId+'></td>',
            '<td>'+'<a data-toggle="modal" href="#myModal" onclick="populateInvtData('+Number(rowCnt)+','+invtDtlId+','+companyId+')">'+companyName+'</a>'+'</td>',
            '<td>'+jobDesc+'</td>',
            '<td>'+lastDate+'</td>',
            '<td>Download</td>',
            '<td>'+otherDetails+'</td>',
            '<td><a data-toggle="modal" href="#applicationModal" >Show</a></td>',
            '<td align ="center"> <i class="icon-trash" onclick="deleteInvtDtls(N,'+invtDtlId+','+Number(rowCnt)+')"></i></td>'
            ], row);
       
    }
    catch(e)
    {
        alert(e);
    }
}

function deleteInvtDtls(deleteFlag,invtDtlId,rowCnt)
{
    var chkInvtDtlId = document.getElementsByName('chkInvtDtlId');
    var invtDtlIds ="";
    var flag = false;
    var rowCntStr ='';
    //For Multiple row delete
    if(deleteFlag == 'Y')
    {
        for(var i=0;i<chkInvtDtlId.length;i++)
        {
            if(chkInvtDtlId[i].checked)
            {
                if(invtDtlIds == "")
                {
                    invtDtlIds =  chkInvtDtlId[i].value; 
                    rowCntStr = chkInvtDtlId[i].id;
                    
                }
                else
                {
                    invtDtlIds =invtDtlIds +"~"+  chkInvtDtlId[i].value; 
                    rowCntStr =rowCntStr +"~"+ (chkInvtDtlId[i].id);
                }
                flag = true;
            }
        }
       
    }
    else
    {
        //For Single row delete
        if(invtDtlId != "")
        {
            invtDtlIds = invtDtlId;
            rowCntStr = "chkInvtDtlId"+rowCnt;
            flag = true;
        }
    }
  
    try{
        if(flag)
        {
            return $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/CampusLive/deleteInvtDtls.do?callmethod=deleteInvtDtls&invtDtlIds='+invtDtlIds,
                timeout: 5000,
                dataType: "json",
                success: function (data) {
                    if(rowCntStr != "")
                    {
                        var rowCnt = rowCntStr.split("~");
                        for(i=0;i<rowCnt.length;i++)
                        {
                            var obj = document.getElementById(rowCnt[i]);
                            var row = $(obj).closest("tr").get(0);
                            $('#tblInvtDtls').dataTable().fnDeleteRow($('#tblInvtDtls').dataTable().fnGetPosition(row));
                        }
                       
                    }
                    generate('topRight','Deleted Successfully.','success');
                    generate('topRight','Click anywhere on the screen to GO back.','info');
                                        
                },
       
                error: function (xhr, ajaxOptions, thrownError){ 
                    
                    generate('topRight','Some Error Occured, Please try again.','error');
                    generate('topRight','Click anywhere on the screen to GO back.','info');
            
                }
            });   
        }
        else
        {
            generate('topRight','Please select at least one record.','error');
            generate('topRight','Click anywhere on the screen to GO back.','info');
        }
     
    }
    catch(e)
    {
        alert(e);
    }
}

function resetData()
{
       
    document.getElementById("invtDtlId").value = "";
    document.getElementById("companyId").value = "-1";
    document.getElementById("jobDesc").value = "";
    document.getElementById("lastDate").value = "";
    document.getElementById("jobDescDoc").value = "";
    document.getElementById("otherDetails").value = "";
      
}

function populateInvtData(rowCnt,invtDtlId,companyId)
{
    alert("in populate");
    resetData();
    try{
 
        var row = document.getElementById("trInvtId"+rowCnt);
        document.getElementById("hdnRowId").value="trInvtId"+rowCnt;
        document.getElementById("invtDtlId").value =invtDtlId;
        document.getElementById("companyId").value = companyId;
        document.getElementById("jobDesc").value = $('#tblInvtDtls').dataTable().fnGetData(row,2);
        document.getElementById("lastDate").valueAsDate = new Date($('#tblInvtDtls').dataTable().fnGetData(row,3));
        //document.getElementById("jobDescDoc").value = "";
        document.getElementById("otherDetails").value = $('#tblInvtDtls').dataTable().fnGetData(row,5);
                    
    }
    catch(e)
    {
        alert(e);
    }
    
       
}