/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() { 
        
       
   $('#insertHRForm').click(function(e) {

        $("#insertHR").validationEngine();
 
    });
 
        
        
        
    $('#btnSaveHrDtl').click(function(e) {
        
        e.preventDefault();
        var hrDtlId=$("#hrDtlId").val();
        var hrName=$("#hrName").val();
        var companyId=$("#companyId").val();
        var designation=$("#designation").val();
        var hrTeleNo=$("#hrTeleNo").val();
        var hrMobileNo=$("#hrMobileNo").val();
        var hrEmailId=$("#hrEmailId").val();
        var faxId=$("#faxId").val();
        var address=$("#address").val();
        var otherDtls=$("#otherDtls").val(); 
        var facebookLink=$("#facebookLink").val();
        var twitterLink=$("#twitterLink").val();
        var linkedinLink=$("#linkedinLink").val();
             
        var param = 'hrDtlId='+hrDtlId+'&hrName='+hrName+'&companyId='+companyId
        +'&designation='+designation+'&hrTeleNo='+hrTeleNo+'&hrMobileNo='+hrMobileNo
        +'&hrEmailId='+hrEmailId+'&faxId='+faxId+'&address='+address+'&otherDtls='+otherDtls+'&facebookLink='+facebookLink
        +'&twitterLink='+twitterLink+'&linkedinLink='+linkedinLink;
    
        saveHrDtlsUsingAjax(param);
       
    });
    
}); 


function saveHrDtlsUsingAjax(param){

    return $.ajax({
        type: 'GET',
        url: 'http://localhost:23236/CampusLive/saveHrDtls.do?'+param,
        timeout: 5000,
        dataType: "json",
        success: function (data) {
          
            var hrDtlId=0;
            
            $.each(data, function(key){
       
                if(key=="hrDtlId"){
                    hrDtlId=data[key];
                }
                
            }); 
            if(hrDtlId>0){
                var hrId=$("#hrDtlId").val();
                if(hrId != '')
                {
                    var rowId = document.getElementById("hdnRowId").value;
                    var row = document.getElementById(rowId);
                    updateHrRowData(row); 
                }
                else
                {
                    document.getElementById('hrDtlId').value =hrDtlId;        
                    addNewHrRowData();
                    resetData();
                }
                       
                generate('topRight','HR Details Saved Successfully.','success');
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

function addNewHrRowData()
{
    try{
        var hrDtlId=$("#hrDtlId").val();
        var hrName=$("#hrName").val();
        var companyId=$("#companyId").val();
        var companyName=$("#companyId :selected").text();
        var designation=$("#designation").val();
        var hrTeleNo=$("#hrTeleNo").val();
        var hrMobileNo=$("#hrMobileNo").val();
        var hrEmailId=$("#hrEmailId").val();
        var faxId=$("#faxId").val();
        var address=$("#address").val();
        var otherDtls=$("#otherDtls").val(); 
        var facebookLink=$("#facebookLink").val();
        var twitterLink=$("#twitterLink").val();
        var linkedinLink=$("#linkedinLink").val();
        
        var hrDtlsTableCnt = $("#hdnHrDtlCnt").val();
   
        $('#tblHrDtls').dataTable().fnAddData( [
            '<td><input type="checkbox" name="chkHrDtlId" id = "chkHrDtlId'+Number(hrDtlsTableCnt)+'" value='+hrDtlId+'></td>',
            '<td>'+'<a data-toggle="modal" href="#myModal" onclick="populateHrData(this,'+hrDtlId+','+hrName+','+facebookLink+','+twitterLink+','+linkedinLink+')">'+hrName+'</a>'+'</td>',
            '<td><input type="hidden" name="hdnCompanyId" id="hdnCompanyId'+Number(hrDtlsTableCnt)+'" value="'+companyId+'"/>'+companyName+'</td>',
            '<td>'+designation+'</td>',
            '<td>'+hrTeleNo+'</td>',
            '<td>'+hrMobileNo+'</td>',
            '<td>'+hrEmailId+'</td>',
            '<td>'+faxId+'</td>',
            '<td>'+address+'</td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon facebook">'+facebookLink+ '</a></div></td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon twitter">'+twitterLink+ '</a></div></td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon linkedin">'+linkedinLink+ '</a></div></td>',
            '<td>'+otherDtls+'</td>',
            '<td align ="center"> <i class="icon-trash" onclick="deleteHrDtls(N,'+hrDtlId+',this)"></i></td>' 
            ] );
        document.getElementById("hdnHrDtlCnt").value=Number(hrDtlsTableCnt)+1;
    }
    catch(e)
    {
        alert(e);
    }
}

function updateHrRowData(row)
{
    try{
        var hrDtlId=$("#hrDtlId").val();
        var hrName=$("#hrName").val();
        var companyId=$("#companyId").val();
        var companyName=$("#companyId :selected").text();
        var designation=$("#designation").val();
        var hrTeleNo=$("#hrTeleNo").val();
        var hrMobileNo=$("#hrMobileNo").val();
        var hrEmailId=$("#hrEmailId").val();
        var faxId=$("#faxId").val();
        var address=$("#address").val();
        var otherDtls=$("#otherDtls").val(); 
        var facebookLink=$("#facebookLink").val();
        var twitterLink=$("#twitterLink").val();
        var linkedinLink=$("#linkedinLink").val();
        
        var rowId = document.getElementById("hdnRowId").value;
        var rowCnt = rowId.substr(6);
   
        $('#tblHrDtls').dataTable().fnUpdate( [
            '<td><input type="checkbox" name="chkHrDtlId" id = "chkHrDtlId'+Number(rowCnt)+'" value='+hrDtlId+'></td>',
            '<td>'+'<a data-toggle="modal" href="#myModal" onclick="populateHrData(this,'+hrDtlId+','+hrName+','+facebookLink+','+twitterLink+','+linkedinLink+')">'+hrName+'</a>'+'</td>',
            '<td><input type="hidden" name="hdnCompanyId" id="hdnCompanyId'+Number(rowCnt)+'" value="'+companyId+'"/>'+companyName+'</td>',
            '<td>'+designation+'</td>',
            '<td>'+hrTeleNo+'</td>',
            '<td>'+hrMobileNo+'</td>',
            '<td>'+hrEmailId+'</td>',
            '<td>'+faxId+'</td>',
            '<td>'+address+'</td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon facebook">'+facebookLink+ '</a></div></td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon twitter">'+twitterLink+ '</a></div></td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon linkedin">'+linkedinLink+ '</a></div></td>',
            '<td>'+otherDtls+'</td>',
            '<td align ="center"> <i class="icon-trash" onclick="deleteCompanyDtls(N,'+hrDtlId+',this)"></i></td>' 
            ], row);
       
    }
    catch(e)
    {
        alert(e);
    }
}

function deleteHrDtls(deleteFlag,hrDtlId,rowCnt)
{
    var chkHrId = document.getElementsByName('chkHrDtlId');
    var hrDtlIds ="";
    var flag = false;
    var rowCntStr ='';
    //For Multiple row delete
    if(deleteFlag == 'Y')
    {
        for(i=0;i<chkHrId.length;i++)
        {
            if(chkHrId[i].checked)
            {
                if(hrDtlIds == "")
                {
                    hrDtlIds =  chkHrId[i].value; 
                    rowCntStr = chkHrId[i].id;
                }
                else
                {
                    hrDtlIds =hrDtlIds +"~"+  chkHrId[i].value; 
                    rowCntStr =rowCntStr +"~"+ (chkHrId[i].id);
                }
                flag = true;
            }
        }
       
    }
    else
    {
        //For Single row delete
        if(hrDtlId != "")
        {
            hrDtlIds = hrDtlId;
            rowCntStr = "chkHrDtlId"+rowCnt;
            flag = true;
        }
    }
   
    try{
        if(flag)
        {
            return $.ajax({
                type: 'GET',
                url: 'http://localhost:23236/CampusLive/deleteHrDtls.do?hrdtlIds='+hrDtlIds,
                timeout: 5000,
                dataType: "json",
                success: function (data) {
                    if(rowCntStr != "")
                    {
                        var rowId = rowCntStr.split("~");
                        for(i=0;i<rowId.length;i++)
                        {
                            var obj = document.getElementById(rowId[i]);
                            var row = $(obj).closest("tr").get(0);
                            $('#tblHrDtls').dataTable().fnDeleteRow($('#tblHrDtls').dataTable().fnGetPosition(row));
                       
                            //var row = document.getElementById("trHrId"+rowCnt[i]);
                           // $('#tblHrDtls').dataTable().fnDeleteRow($('#tblHrDtls').dataTable().fnGetPosition(row));
                        }
                       // var row = $(obj).closest("tr").get(0);
                       // $('#tblHrDtls').dataTable().fnDeleteRow($('#tblHrDtls').dataTable().fnGetPosition(row));
                    }
                    generate('topRight','HR Details Deleted Successfully.','success');
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
   
    document.getElementById("hrDtlId").value = "";
    document.getElementById("hrName").value = "";
    document.getElementById("companyId").value = "";
    document.getElementById("designation").value = "";
    document.getElementById("hrTeleNo").value = "";
    document.getElementById("hrMobileNo").value = "";
    document.getElementById("hrEmailId").value = "";
    document.getElementById("faxId").value = "";
    document.getElementById("address").value = "";
    document.getElementById("otherDtls").value = "";
    document.getElementById("facebookLink").value = "";
    document.getElementById("twitterLink").value = "";
    document.getElementById("linkedinLink").value = "";
}

function populateHrData(rowCnt,hrDtlId,hrName,facebookLink,twitterLink,linkedinLink)
{
    alert("in populate");
    resetData();
    try{
        // var row = $(obj).closest("tr").get(0);
        var row = document.getElementById("trHrId"+rowCnt)
        document.getElementById("hdnRowId").value="trHrId"+rowCnt;
        document.getElementById("hrDtlId").value =hrDtlId;
        document.getElementById("hrName").value = hrName;
        document.getElementById("companyId").value = $("#hdnCompanyId"+rowCnt).val();
        document.getElementById("designation").value = $('#tblHrDtls').dataTable().fnGetData(row,3);
        document.getElementById("hrTeleNo").value = $('#tblHrDtls').dataTable().fnGetData(row,4);
        document.getElementById("hrMobileNo").value = $('#tblHrDtls').dataTable().fnGetData(row,5);
        document.getElementById("hrEmailId").value = $('#tblHrDtls').dataTable().fnGetData(row,6);
        document.getElementById("faxId").value = $('#tblHrDtls').dataTable().fnGetData(row,7);
        document.getElementById("address").value = $('#tblHrDtls').dataTable().fnGetData(row,8);
        document.getElementById("otherDtls").value = $('#tblHrDtls').dataTable().fnGetData(row,12);
        document.getElementById("facebookLink").value = facebookLink;
        document.getElementById("twitterLink").value = twitterLink;
        document.getElementById("linkedinLink").value = linkedinLink;
      
    }
    catch(e)
    {
        alert(e);
    }
    
}