/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() { 
        
    $('#insertAlumniForm').click(function(e) {

        $("#insertAlumni").validationEngine();
 
    });
     
        
        
        
    $('#btnSaveAlumniDtl').click(function(e) {
        
        e.preventDefault();
        var alumniDtlId=$("#alumniDtlId").val();
        var alumniName=$("#alumniName").val();
        var alumniCompany=$("#alumniCompany").val();
        var alumniDesignation=$("#alumniDesignation").val();
        var alumniBatch=$("#alumniBatch").val();
        var alumniTelephone=$("#alumniTelephone").val();
        var alumniMobile=$("#alumniMobile").val();
        var alumniEmail=$("#alumniEmail").val();
        var alumniFax=$("#alumniFax").val();
        var alumniAddress=$("#alumniAddress").val();
        var alumniOtherDtls=$("#alumniOtherDtls").val();
        var facebookLink=$("#facebookLink").val();
        var twitterLink=$("#twitterLink").val();
        var linkedinLink=$("#linkedinLink").val();
             
        var param = 'alumniDtlId='+alumniDtlId+'&alumniName='+alumniName+'&alumniCompany='+alumniCompany
        +'&alumniDesignation='+alumniDesignation+'&alumniBatch='+alumniBatch+'&alumniTelephone='+alumniTelephone
        +'&alumniMobile='+alumniMobile+'&alumniEmail='+alumniEmail+'&alumniFax='+alumniFax+'&alumniAddress='+alumniAddress
        +'&alumniOtherDtls='+alumniOtherDtls+'&facebookLink='+facebookLink
        +'&twitterLink='+twitterLink+'&linkedinLink='+linkedinLink;
    
        saveAlumniDtlsUsingAjax(param);
       
    });
    
}); 


function saveAlumniDtlsUsingAjax(param){

    return $.ajax({
        type: 'GET',
        url: 'http://localhost:23236/CampusLive/saveAlumniDtls.do?'+param,
        timeout: 5000,
        dataType: "json",
        success: function (data) {
          
            var alumniDtlId=0;
            
            $.each(data, function(key){
       
                if(key=="alumniDtlId"){
                    alumniDtlId=data[key];
                }
                
            }); 
            if(alumniDtlId>0){
                var alumniId=$("#alumniDtlId").val();
                if(alumniId != '')
                {
                    var rowId = document.getElementById("hdnRowId").value;
                    var row = document.getElementById(rowId);
                    updateAlumniRowData(row); 
                }
                else
                {
                    document.getElementById('alumniDtlId').value =alumniDtlId;        
                    addNewAlumniRowData();
                    resetData();
                }
                       
                generate('topRight','Alumni Details Saved Successfully.','success');
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

function addNewAlumniRowData()
{
    try{
        var alumniDtlId=$("#alumniDtlId").val();
        var alumniName=$("#alumniName").val();
        var alumniCompany=$("#alumniCompany").val();
        var alumniCompanyName=$("#alumniCompany :selected").text();
        var alumniDesignation=$("#alumniDesignation").val();
        var alumniBatch=$("#alumniBatch").val();
        var alumniTelephone=$("#alumniTelephone").val();
        var alumniMobile=$("#alumniMobile").val();
        var alumniEmail=$("#alumniEmail").val();
        var alumniFax=$("#alumniFax").val();
        var alumniAddress=$("#alumniAddress").val();
        var alumniOtherDtls=$("#alumniOtherDtls").val();
        var facebookLink=$("#facebookLink").val();
        var twitterLink=$("#twitterLink").val();
        var linkedinLink=$("#linkedinLink").val();
        
        var alumniDtlsTableCnt = $("#hdnAlumniDtlCnt").val();
   
        $('#tblAlumniDtls').dataTable().fnAddData( [
            '<td><input type="checkbox" name="chkAlumniDtlId" id = "chkAlumniDtlId'+Number(alumniDtlsTableCnt)+'" value='+alumniDtlId+'></td>',
            '<td>'+'<a data-toggle="modal" href="#myModal" onclick="populateAlumniData(this,'+alumniDtlId+','+alumniName+','+facebookLink+','+twitterLink+','+linkedinLink+')">'+alumniName+'</a>'+'</td>',
            '<td><input type="hidden" name="hdnAlumniCompanyId" id="hdnAlumniCompanyId'+Number(alumniDtlsTableCnt)+'" value="'+alumniCompany+'"/>'+alumniCompanyName+'</td>',
            '<td>'+alumniDesignation+'</td>',
            '<td class="more">'+alumniBatch+'</td>',
            '<td>'+alumniTelephone+'</td>',
            '<td>'+alumniMobile+'</td>',
            '<td class="more">'+alumniEmail+'</td>',
            '<td>'+alumniFax+'</td>',
            '<td>'+alumniAddress+'</td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon facebook">'+facebookLink+ '</a></div></td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon twitter">'+twitterLink+ '</a></div></td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon linkedin">'+linkedinLink+ '</a></div></td>',
            '<td>'+alumniOtherDtls+'</td>',
            '<td align ="center"> <i class="icon-trash" onclick="deleteAlumniDtls(N,'+alumniDtlId+',this)"></i></td>' 
            ] );
        document.getElementById("hdnAlumniDtlCnt").value=Number(alumniDtlsTableCnt)+1;
    }
    catch(e)
    {
        alert(e);
    }
}

function updateAlumniRowData(row)
{
    try{
        var alumniDtlId=$("#alumniDtlId").val();
        var alumniName=$("#alumniName").val();
        var alumniCompany=$("#alumniCompany").val();
        var alumniCompanyName=$("#alumniCompany :selected").text();
        var alumniDesignation=$("#alumniDesignation").val();
        var alumniBatch=$("#alumniBatch").val();
        var alumniTelephone=$("#alumniTelephone").val();
        var alumniMobile=$("#alumniMobile").val();
        var alumniEmail=$("#alumniEmail").val();
        var alumniFax=$("#alumniFax").val();
        var alumniAddress=$("#alumniAddress").val();
        var alumniOtherDtls=$("#alumniOtherDtls").val();
        var facebookLink=$("#facebookLink").val();
        var twitterLink=$("#twitterLink").val();
        var linkedinLink=$("#linkedinLink").val();
        
        var rowId = document.getElementById("hdnRowId").value;
        var rowCnt = rowId.substr(10);
   
        $('#tblAlumniDtls').dataTable().fnUpdate( [
            '<td><input type="checkbox" name="chkAlumniDtlId" id = "chkAlumniDtlId'+Number(rowCnt)+'" value='+alumniDtlId+'></td>',
            '<td>'+'<a data-toggle="modal" href="#myModal" onclick="populateAlumniData(this,'+alumniDtlId+','+alumniName+','+facebookLink+','+twitterLink+','+linkedinLink+')">'+alumniName+'</a>'+'</td>',
            '<td><input type="hidden" name="hdnAlumniCompanyId" id="hdnAlumniCompanyId'+Number(rowCnt)+'" value="'+alumniCompany+'"/>'+alumniCompanyName+'</td>',
            '<td>'+alumniDesignation+'</td>',
            '<td class="more">'+alumniBatch+'</td>',
            '<td>'+alumniTelephone+'</td>',
            '<td>'+alumniMobile+'</td>',
            '<td class="more">'+alumniEmail+'</td>',
            '<td>'+alumniFax+'</td>',
            '<td>'+alumniAddress+'</td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon facebook">'+facebookLink+ '</a></div></td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon twitter">'+twitterLink+ '</a></div></td>',
            '<td><div class="social-box-icon"><a href="#" class="zocial icon linkedin">'+linkedinLink+ '</a></div></td>',
            '<td>'+alumniOtherDtls+'</td>',
            '<td align ="center"> <i class="icon-trash" onclick="deleteAlumniDtls(N,'+alumniDtlId+','+Number(rowCnt)+')"></i></td>'  
            ], row);
       
    }
    catch(e)
    {
        alert(e);
    }
}

function deleteAlumniDtls(deleteFlag,alumniDtlId,rowCnt)
{
    var chkAlumniId = document.getElementsByName('chkAlumniDtlId');
    var alumniDtlIds ="";
    var flag = false;
    var rowCntStr ='';
    //For Multiple row delete
    if(deleteFlag == 'Y')
    {
        for(i=0;i<chkAlumniId.length;i++)
        {
            if(chkAlumniId[i].checked)
            {
                if(alumniDtlIds == "")
                {
                    alumniDtlIds =  chkAlumniId[i].value; 
                    rowCntStr = chkAlumniId[i].id;
                    
                }
                else
                {
                    alumniDtlIds =alumniDtlIds +"~"+  chkAlumniId[i].value; 
                    rowCntStr =rowCntStr +"~"+ (chkAlumniId[i].id);
                }
                flag = true;
            }
        }
       
    }
    else
    {
        //For Single row delete
        if(alumniDtlId != "")
        {
            alumniDtlIds = alumniDtlId;
            rowCntStr = "chkAlumniDtlId"+rowCnt;
            flag = true;
        }
    }
  
    try{
        if(flag)
        {
            return $.ajax({
                type: 'GET',
                url: 'http://localhost:23236/CampusLive/deleteAlumniDtls.do?alumniDtlIds='+alumniDtlIds,
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
                            $('#tblAlumniDtls').dataTable().fnDeleteRow($('#tblAlumniDtls').dataTable().fnGetPosition(row));
                        }
                       
                    }
                    generate('topRight','Alumni Details Deleted Successfully.','success');
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
    
    document.getElementById("alumniDtlId").value = "";
    document.getElementById("alumniName").value = "";
    document.getElementById("alumniCompany").value = "";
    document.getElementById("alumniDesignation").value = "";
    document.getElementById("alumniBatch").value = "";
    document.getElementById("alumniTelephone").value = "";
    document.getElementById("alumniMobile").value = "";
    document.getElementById("alumniEmail").value = "";
    document.getElementById("alumniFax").value = "";
    document.getElementById("alumniAddress").value = "";
    document.getElementById("alumniOtherDtls").value = "";
    document.getElementById("facebookLink").value = "";
    document.getElementById("twitterLink").value = "";
    document.getElementById("linkedinLink").value = "";
}

function populateAlumniData(rowCnt,alumniDtlId,alumniName,facebookLink,twitterLink,linkedinLink)
{
    alert("in populate");
    resetData();
    try{
        // var row = $(obj).closest("tr").get(0);
        var row = document.getElementById("trAlumniId"+rowCnt)
        document.getElementById("hdnRowId").value="trAlumniId"+rowCnt;
        document.getElementById("alumniDtlId").value =alumniDtlId;
        document.getElementById("alumniName").value = alumniName;
        document.getElementById("alumniCompany").value = $("#hdnAlumniCompanyId"+rowCnt).val();
        document.getElementById("alumniDesignation").value = $('#tblAlumniDtls').dataTable().fnGetData(row,3);
        document.getElementById("alumniBatch").value = $('#tblAlumniDtls').dataTable().fnGetData(row,4);
        document.getElementById("alumniTelephone").value = $('#tblAlumniDtls').dataTable().fnGetData(row,5);
        document.getElementById("alumniMobile").value = $('#tblAlumniDtls').dataTable().fnGetData(row,6);
        document.getElementById("alumniEmail").value = $('#tblAlumniDtls').dataTable().fnGetData(row,7);
        document.getElementById("alumniFax").value = $('#tblAlumniDtls').dataTable().fnGetData(row,8);
        document.getElementById("alumniAddress").value = $('#tblAlumniDtls').dataTable().fnGetData(row,9);
        document.getElementById("alumniOtherDtls").value = $('#tblAlumniDtls').dataTable().fnGetData(row,13);
        document.getElementById("facebookLink").value = facebookLink;
        document.getElementById("twitterLink").value = twitterLink;
        document.getElementById("linkedinLink").value = linkedinLink;
      
    }
    catch(e)
    {
        alert(e);
    }
    
}