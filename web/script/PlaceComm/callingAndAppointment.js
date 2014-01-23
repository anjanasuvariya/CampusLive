/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() { 

$('#btnSaveAppntDtl').click(function(e) {
        
        e.preventDefault();
        var appntDtlId=$("#appntDtlId").val();
        var appntTitle=$("#appntTitle").val();
        var appntPurpose=$("#appntPurpose").val();
        var appntFileName=$("#appntFileName").val();
        var appntCompany=$("#appntCompany").val();
        var assignedTo=$("#assignedTo").val();
        var appntStatus=$("#appntStatus").val();
        var appntMessage=$("#appntMessage").val();
        var appntPriority = "";
       
        var radios =document.getElementsByName("appntPriority")
        for(i=0;i<radios.length;i++)
        {
            if (radios[i].checked) {
                appntPriority =radios[i].value;
               
                break;
            }
        }
             
        var param = 'appntDtlId='+appntDtlId+'&appntTitle='+appntTitle+'&appntPurpose='+appntPurpose
        +'&appntFileName='+appntFileName+'&appntCompany='+appntCompany+'&assignedTo='+assignedTo
        +'&appntStatus='+appntStatus+'&appntMessage='+appntMessage+'&appntPriority='+appntPriority+'&callmethod=saveAppointmentDtls';
    
        var file = document.getElementById("uploadFile").files[0];
        var formdata = new FormData();
        
        alert('file is:::'+file.toString());
        
        formdata.append("uploadFile",file);
        formdata.append("appntDtlId",appntDtlId);
        formdata.append("appntTitle",appntTitle);
        formdata.append("appntPurpose",appntPurpose);
        formdata.append("appntFileName",appntFileName);
        formdata.append("appntCompany",appntCompany);
        formdata.append("assignedTo",assignedTo);
        formdata.append("appntStatus",appntStatus);
        formdata.append("appntMessage",appntMessage);
        formdata.append("appntPriority",appntPriority);
        formdata.append("callmethod","saveAppointmentDtls");
        alert("Now calling saveAjax Method");
        
        saveAppntDtlsUsingAjax(param,formdata);
       
    });
    
}); 


function saveAppntDtlsUsingAjax(param,formdata){

    alert("Formdata is..."+formdata);
    
    return $.ajax({
        type: 'POST',
        url: 'http://localhost:23236/CampusLive/saveAppointmentDtls.do',
        timeout: 50000,
        data:formdata,
        cache: false,
        enctype: 'multipart/form-data',
        dataType: 'json',
        processData: false, // Don't process the files
        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
        success: function (data) {
          
            alert(data);
          
            var appntDtlId=0;
            
            $.each(data, function(key){
       
                if(key=="appntDtlId"){
                    appntDtlId=data[key];
                }
                
            }); 
            if(appntDtlId>0){
                var appntId=$("#appntDtlId").val();
                if(appntId != '')
                {
                    var rowId = document.getElementById("hdnRowId").value;
                    var row = document.getElementById(rowId);
                    updateAppntRowData(row); 
                }
                else
                {
                    document.getElementById('appntDtlId').value =appntDtlId;        
                    addNewAppntRowData();
                    resetData();
                }
                       
                generate('topRight','Appointment Details Saved Successfully.','success');
                generate('topRight','Click anywhere on the screen to GO back.','info'); 
       
            }
        },
       
        error: function (xhr, ajaxOptions, thrownError){ 
            alert(thrownError);
            generate('topRight','Some Error Occured, Please try again.','error');
            generate('topRight','Click anywhere on the screen to GO back.','info');
            alert(data);
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

function addNewAppntRowData()
{
    try{
        
        var appntDtlId=$("#appntDtlId").val();
        var appntTitle=$("#appntTitle").val();
        var appntPurpose=$("#appntPurpose").val();
        var appntFileName=$("#appntFileName").val();
        var appntCompanyId = $("#appntCompany").val();
        var appntCompanyName=$("#appntCompany :selected").text();
        var ownerName = $("#hdnLoggedInUserName").val();
        var assignedToUserId = $("#assignedTo").val();
        var assignedToUserName=$('#assignedTo :selected').text();
        var appntStatus=$("#appntStatus").val();
        var appntMessage=$("#appntMessage").val();
        var appntPriority = '';
        var radios =document.getElementsByName("appntPriority");
        for(i=0;i<radios.length;i++)
        {
            if (radios[i].checked) {
                appntPriority =radios[i].value;
               
                break;
            }
        }
        
        var appntPriorityValue='';
        if(appntPriority == 'L')
        {
            appntPriorityValue = 'Low';
        }
        else if(appntPriority == 'M')
        {
            appntPriorityValue = 'Medium';
        }
        else if(appntPriority == 'H')
        {
            appntPriorityValue = 'High';
        }
        
        var appntDtlsTableCnt = $("#hdnAppntDtlCnt").val();
   
        $('#tblApptDtl').dataTable().fnAddData( [
            '<td><input type="checkbox" name="chkAppntDtlId" id = "chkAppntDtlId'+Number(appntDtlsTableCnt)+'" value='+appntDtlId+'></td>',
            '<td>'+'<a data-toggle="modal" href="#myModal" onclick="populateAppntData(this,'+appntDtlId+','+appntTitle+')">'+appntTitle+'</a>'+'</td>',
            '<td>'+appntPurpose+'</td>',
            '<td>Download</td>',
            '<td class="more"><input type="hidden" name="hdnAppntCompanyId" id="hdnAppntCompanyId'+Number(appntDtlsTableCnt)+'" value='+appntCompanyId+'/>'+appntCompanyName+'</td>',
            '<td>'+ownerName+'</td>',
            '<td><input type="hidden" name="hdnAssignedUserId" id="hdnAssignedUserId'+Number(appntDtlsTableCnt)+'" value='+assignedToUserId+'/>'+assignedToUserName+'</td>',
            '<td class="more">'+appntStatus+'</td>',
            '<td>'+appntMessage+'</td>',
            '<td>'+appntPriorityValue+'</td>',
            '<td><a data-toggle="modal" href="#historyModal" onclick="viewAppntHistory('+appntDtlId+','+appntTitle+','+Number(appntDtlsTableCnt)+')">Explore</a></td>',
            '<td align ="center"> <i class="icon-trash" onclick="deleteAppntDtls(N,'+appntDtlId+','+Number(appntDtlsTableCnt)+')"></i></td>' 
            ] );
        document.getElementById("hdnAppntDtlCnt").value=Number(appntDtlsTableCnt)+1;
    }
    catch(e)
    {
        alert(e);
    }
}

function updateAppntRowData(row)
{
    try{
        var appntDtlId=$("#appntDtlId").val();
        var appntTitle=$("#appntTitle").val();
        var appntPurpose=$("#appntPurpose").val();
        var appntFileName=$("#appntFileName").val();
        var appntCompanyId = $("#appntCompany").val();
        var appntCompanyName=$("#appntCompany :selected").text();
        var ownerName = $("#hdnLoggedInUserName").val();
        var assignedToUserId = $("#assignedTo").val();
        var assignedToUserName=$('#assignedTo :selected').text();
        var appntStatus=$("#appntStatus").val();
        var appntMessage=$("#appntMessage").val();
        var appntPriority = '';
        var radios =document.getElementsByName("appntPriority");
        for(i=0;i<radios.length;i++)
        {
            if (radios[i].checked) {
                appntPriority =radios[i].value;
               
                break;
            }
        }
        
        var appntPriorityValue='';
        if(appntPriority == 'L')
        {
            appntPriorityValue = 'Low';
        }
        else if(appntPriority == 'M')
        {
            appntPriorityValue = 'Medium';
        }
        else if(appntPriority == 'H')
        {
            appntPriorityValue = 'High';
        }
        
        var rowId = document.getElementById("hdnRowId").value;
        var rowCnt = rowId.substr(9);
   
        $('#tblApptDtl').dataTable().fnUpdate( [
           '<td><input type="checkbox" name="chkAppntDtlId" id = "chkAppntDtlId'+Number(rowCnt)+'" value='+appntDtlId+'></td>',
            '<td>'+'<a data-toggle="modal" href="#myModal" onclick="populateAppntData(this,'+appntDtlId+','+appntTitle+')">'+appntTitle+'</a>'+'</td>',
            '<td>'+appntPurpose+'</td>',
            '<td>Download</td>',
            '<td class="more"><input type="hidden" name="hdnAppntCompanyId" id="hdnAppntCompanyId'+Number(rowCnt)+'" value='+appntCompanyId+'/>'+appntCompanyName+'</td>',
            '<td>'+ownerName+'</td>',
            '<td><input type="hidden" name="hdnAssignedUserId" id="hdnAssignedUserId'+Number(rowCnt)+'" value='+assignedToUserId+'/>'+assignedToUserName+'</td>',
            '<td class="more">'+appntStatus+'</td>',
            '<td>'+appntMessage+'</td>',
            '<td>'+appntPriorityValue+'</td>',
            '<td><a data-toggle="modal" href="#historyModal" onclick="viewAppntHistory('+appntDtlId+','+appntTitle+','+Number(rowCnt)+')">Explore</a></td>',
            '<td align ="center"> <i class="icon-trash" onclick="deleteAppntDtls(N,'+appntDtlId+','+Number(rowCnt)+')"></i></td>'
            ], row);
       
    }
    catch(e)
    {
        alert(e);
    }
}

function deleteAppntDtls(deleteFlag,appntDtlId,rowCnt)
{
    var chkAppntDtlId = document.getElementsByName('chkAppntDtlId');
    var appntDtlIds ="";
    var flag = false;
    var rowCntStr ='';
    //For Multiple row delete
    if(deleteFlag == 'Y')
    {
        for(i=0;i<chkAppntDtlId.length;i++)
        {
            if(chkAppntDtlId[i].checked)
            {
                if(appntDtlIds == "")
                {
                    appntDtlIds =  chkAppntDtlId[i].value; 
                    rowCntStr = chkAppntDtlId[i].id;
                    
                }
                else
                {
                    appntDtlIds =appntDtlIds +"~"+  chkAppntDtlId[i].value; 
                    rowCntStr =rowCntStr +"~"+ (chkAppntDtlId[i].id);
                }
                flag = true;
            }
        }
       
    }
    else
    {
        //For Single row delete
        if(appntDtlId != "")
        {
            appntDtlIds = appntDtlId;
            rowCntStr = "chkAppntDtlId"+rowCnt;
            flag = true;
        }
    }
  
    try{
        if(flag)
        {
            return $.ajax({
                type: 'GET',
                url: 'http://localhost:23236/CampusLive/deleteAppointmentDtls.do?appntDtlIds='+appntDtlIds,
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
                            $('#tblApptDtl').dataTable().fnDeleteRow($('#tblApptDtl').dataTable().fnGetPosition(row));
                        }
                       
                    }
                    generate('topRight','Appointment Details Deleted Successfully.','success');
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
       
    document.getElementById("appntDtlId").value = "";
    document.getElementById("appntTitle").value = "";
    document.getElementById("appntPurpose").value = "";
    document.getElementById("appntCompany").value = "";
    document.getElementById("assignedTo").value = "";
    document.getElementById("appntStatus").value = "";
    document.getElementById("appntMessage").value = "";
    document.getElementById("appntStatus").disabled = false;
    document.getElementById("appntMessage").disabled = false;
    
}

function populateAppntData(rowCnt,appntDtlId,appntTitle)
{
    alert("in populate");
    resetData();
    try{
        // var row = $(obj).closest("tr").get(0);
        var row = document.getElementById("trAppntId"+rowCnt);
        document.getElementById("hdnRowId").value="trAppntId"+rowCnt;
        document.getElementById("appntDtlId").value =appntDtlId;
        document.getElementById("appntTitle").value = appntTitle;
        document.getElementById("appntPurpose").value = $('#tblApptDtl').dataTable().fnGetData(row,2);
        document.getElementById("appntCompany").value = $("#hdnAppntCompanyId"+rowCnt).val();
        document.getElementById("assignedTo").value = $("#hdnAssignedUserId"+rowCnt).val();
        document.getElementById("appntStatus").value = $('#tblApptDtl').dataTable().fnGetData(row,7);
        document.getElementById("appntMessage").value = $('#tblApptDtl').dataTable().fnGetData(row,8);
        document.getElementById("appntStatus").disabled = true;
        document.getElementById("appntMessage").disabled = true;
        var appntPriority = $('#tblApptDtl').dataTable().fnGetData(row,9);
        
        if(appntPriority != '')
        {
            if(appntPriority == 'Low')
            {
                document.getElementById("appntPriorityL").checked = true;
              
            }
            else if(appntPriority == 'Medium')
            {
                document.getElementById("appntPriorityM").checked = true; 
            }
            else if(appntPriority == 'High')
            {
                document.getElementById("appntPriorityH").checked = true; 
            }
        }
             
    }
    catch(e)
    {
        alert(e);
    }
    
       
}
function viewAppntHistory(appntDtlId,appntTitle,rowCnt)
{
   // var row = document.getElementById("trAppntId"+rowCnt);
    document.getElementById("hdnRowId").value="trAppntId"+rowCnt;
    document.getElementById("apptMessage").value = "";
    document.getElementById("apptStatus").value = "";
    document.getElementById("hdnAppntDtlId").value = appntDtlId;
    var oSettings = $('#tblAppntHst').dataTable().fnSettings();
    var iTotalRecords = oSettings.fnRecordsTotal();
    for (i=0;i<=iTotalRecords;i++) {
        $('#tblAppntHst').dataTable().fnDeleteRow(0,null,true);
    }
    return $.ajax({
        type: 'GET',
        url: 'http://localhost:23236/CampusLive/viewAppntHistory.do?callmethod=viewAppntHistory&appntDtlId='+appntDtlId,
        timeout: 5000,
        dataType: "json",
        success: function (responseJson) {
            $("#hdDisscussionTopic").html("Disscussion on : "+appntTitle);
            
            $.each (responseJson, function (rowCnt) {

                $('#tblAppntHst').dataTable().fnAddData( [
                    '<td><input type="hidden" name="hdnHstAppntDtlId" id = "hdnHstAppntDtlId'+Number(rowCnt)+'" value='+responseJson[rowCnt].hstAppntDtlId+'>'+responseJson[rowCnt].assignedUserName+'</td>',
                    '<td>'+responseJson[rowCnt].appntMessage+'</td>',
                    '<td>'+responseJson[rowCnt].appntStatus+'</td>'
                               
                    ] );
            });

        },
       
        error: function (xhr, ajaxOptions, thrownError){ 
                    
            generate('topRight','Some Error Occured, Please try again.','error');
            generate('topRight','Click anywhere on the screen to GO back.','info');
            
        }
    });   
}

function saveAppntHistory()
{
    var rowId =$("#hdnRowId").val();
    var row = document.getElementById(rowId);
       
    alert(row);
    var appntDtlId = $("#hdnAppntDtlId").val();
    var message = $("#apptMessage").val();
    var status = $("#apptStatus").val();
    var userName = $("#hdnLoggedInUserName").val();
    
    return $.ajax({
        type: 'GET',
        url: 'http://localhost:23236/CampusLive/viewAppntHistory.do?callmethod=saveAppntHstDtls&appntDtlId='+appntDtlId+'&message='+message+'&status='+status,
        timeout: 5000,
        dataType: "json",
        success: function (responseJson) {
        
            $('#tblApptDtl').dataTable().fnUpdate(status, row, 7);
            $('#tblApptDtl').dataTable().fnUpdate(message, row, 8);
  
            $('#tblAppntHst').dataTable().fnAddData( [
                '<td><input type="hidden" name="hdnHstAppntDtlId" id = "hdnHstAppntDtlId'+Number(4)+'" value='+responseJson["hstAppntDtlId"]+'>'+userName+'</td>',
                '<td>'+message+'</td>',
                '<td>'+status+'</td>'
                               
                ] );
            generate('topRight','Saved Successfully.','success');
            generate('topRight','Click anywhere on the screen to GO back.','info');
                                        
        },
       
        error: function (xhr, ajaxOptions, thrownError){ 
                    
            generate('topRight','Some Error Occured, Please try again.','error');
            generate('topRight','Click anywhere on the screen to GO back.','info');
            
        }
    });  

}