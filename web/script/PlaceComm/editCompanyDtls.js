

$(document).ready(function() { 
    
    $('#saveCompanyDtl').click(function(e) {
        
        e.preventDefault();
        
        var companyTitle=$("#companyTitle").val();
        var companyCode=$("#companyCode").val();
        var contactPersonName=$("#contactPersonName").val();
        var contactNumber=$("#contactNumber").val();
        var contactAddress=$("#contactAddress").val();
        var contactEmail=$("#contactEmail").val();
        var companyLocation=$("#companyLocation").val();
        var companyPriority='';
        var companyId=$("#companyId").val();
                   
        var radios =document.getElementsByName("companyPriority")
        for(var i=0;i<radios.length;i++)
        {
            if (radios[i].checked) {
                companyPriority =radios[i].value;
               
                break;
            }
        }
        var param = 'companyTitle='+companyTitle+'&companyCode='+companyCode+'&contactPersonName='+contactPersonName
        +'&contactNumber='+contactNumber+'&contactAddress='+contactAddress+'&contactEmail='+contactEmail
        +'&companyLocation='+companyLocation+'&companyPriority='+companyPriority+'&companyId='+companyId;
    
        saveCompanyDtlsUsingAjax(param);
       
    });
    
    
    
}); 


function saveCompanyDtlsUsingAjax(param){

    return $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/CampusLive/saveCompanyDtl.do?'+param,
        timeout: 5000,
        dataType: "json",
        success: function (data) {
          
            var companyId=0;
            
            $.each(data, function(key){
       
                if(key=="companyId"){
                    companyId=data[key];
                }
                
            }); 
            if(companyId>0){
                var compId=$("#companyId").val();
                if(compId != '')
                {
                    var rowId = document.getElementById("hdnRowId").value;
                    var row = document.getElementById(rowId);
                    updateCompanyRowData(row); 
                }
                else
                {
                    document.getElementById('companyId').value =companyId;        
                    addCompanyRowInTable();
                    resetData();
                }
                       
                generate('topRight','Company Details Saved Successfully.','success');
                generate('topRight','Click anywhere on the screen to GO back.','info'); 
       
            }
           
        },
       
        error: function (xhr, ajaxOptions, thrownError){ 
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
 
function addCompanyRowInTable() {
    
    try{
        var companyId=$("#companyId").val();
        var companyTitle=$("#companyTitle").val();
        var companyCode=$("#companyCode").val();
        var contactPersonName=$("#contactPersonName").val();
        var contactNumber=$("#contactNumber").val();
        var contactAddress=$("#contactAddress").val();
        var contactEmail=$("#contactEmail").val();
        var companyLocation=$("#companyLocation").val();
        var companyPriority = '';
        var radios =document.getElementsByName("companyPriority");
        for(var i=0;i<radios.length;i++)
        {
            if (radios[i].checked) {
                companyPriority =radios[i].value;
               
                break;
            }
        }
        
        var companyPriorityValue='';
        if(companyPriority == 'L')
        {
            companyPriorityValue = 'Low';
        }
        else if(companyPriority == 'M')
        {
            companyPriorityValue = 'Medium';
        }
        else if(companyPriority == 'H')
        {
            companyPriorityValue = 'High';
        }
        var rowCnt = document.getElementById("hdnCompanyCnt").value;
               
        $('#tblCompanyDtls').dataTable().fnAddData( [
            '<td>'+'<input type="checkbox" name="chkCompanyId" value='+companyId+'>'+'</td>',
            '<td>'+'<a data-toggle="modal" href="#myModal" onclick="populateCompanyData('+rowCnt+','+companyId+','+companyTitle+')">'+companyTitle+'</a>'+'</td>',
            '<td>'+companyCode+'</td>',
            '<td>'+contactPersonName+'</td>',
            '<td>'+contactNumber+'</td>',
            '<td>'+contactAddress+'</td>',
            '<td>'+contactEmail+'</td>',
            '<td>'+companyLocation+'</td>',
            '<td>'+companyPriorityValue+ '</td>',
            '<td align ="center"> <i class="icon-trash" onclick="deleteCompanyDtls(N,'+companyId+','+rowCnt+')"></i></td>' 
            ] );
       
              
        //        var rowCnt = document.getElementById("hdnCompanyCnt").value;
        //           
        //        var table = document.getElementById("tblCompanyDtls");
        // 
        //        var rowCount = table.rows.length;
        //        var newRow = table.insertRow(rowCount);
        //                        
        //        var newCell = newRow.insertCell(0);
        //        newCell.innerHTML = '<input type="checkbox" name="chkCompanyId" value='+companyId+'>';
        //                
        //        newCell = newRow.insertCell(1);
        //        newCell.innerHTML = '<a data-toggle="modal" href="#myModal" onclick="populateCompanyData('+rowCnt+')">'+companyTitle+'</a>';
        //                 
        //        newCell = newRow.insertCell(2);
        //        newCell.innerHTML = companyCode;
        //            
        //        newCell = newRow.insertCell(3);
        //        newCell.innerHTML = contactPersonName;
        //           
        //        newCell = newRow.insertCell(4);
        //        newCell.innerHTML = contactNumber;
        //            
        //        newCell = newRow.insertCell(5);
        //        newCell.innerHTML = contactAddress;
        //            
        //        newCell = newRow.insertCell(6);
        //        newCell.innerHTML = contactEmail;
        //            
        //        newCell = newRow.insertCell(7);
        //        newCell.innerHTML = companyLocation;
        //            
        //        newCell = newRow.insertCell(8);
        //        newCell.innerHTML = companyPriorityValue
        //        +'<input type ="hidden" id="hdnCompanyId'+rowCnt+'" name="hdnCompanyId" value='+companyId+'>'
        //        +'<input type ="hidden" id="hdnCompanyTitle'+rowCnt+'" name="hdnCompanyTitle" value='+companyTitle+'>'
        //        +'<input type ="hidden" id="hdnCompanyCode'+rowCnt+'" name="hdnCompanyCode" value='+companyCode+'>'
        //        +'<input type ="hidden" id="hdnContactPersonName'+rowCnt+'" name="hdnContactPersonName" value='+contactPersonName+'>'
        //        +'<input type ="hidden" id="hdnContactNumber'+rowCnt+'" name="hdnContactNumber" value='+contactNumber+'>'
        //        +'<input type ="hidden" id="hdnContactAddress'+rowCnt+'" name="hdnContactAddress" value='+contactAddress+'>'
        //        +'<input type ="hidden" id="hdnContactEmail'+rowCnt+'" name="hdnContactEmail" value='+contactEmail+' >'
        //        +'<input type ="hidden" id="hdnCompanyLocation'+rowCnt+'" name="hdnCompanyLocation" value='+companyLocation+'>'
        //        +'<input type ="hidden" id="hdnCompanyPriority'+rowCnt+'" name="hdnCompanyPriority" value='+companyPriority+'>';
            
        document.getElementById("hdnCompanyCnt").value=Number(rowCnt)+1;
         
    }
    catch(e)
    {
        alert(e);
    }
}  

function updateCompanyRowData(row)
{
    try{
        var companyId=$("#companyId").val();
        var companyTitle=$("#companyTitle").val();
        var companyCode=$("#companyCode").val();
        var contactPersonName=$("#contactPersonName").val();
        var contactNumber=$("#contactNumber").val();
        var contactAddress=$("#contactAddress").val();
        var contactEmail=$("#contactEmail").val();
        var companyLocation=$("#companyLocation").val();
        var companyPriority = '';
        var radios =document.getElementsByName("companyPriority");
        for(var i=0;i<radios.length;i++)
        {
            if (radios[i].checked) {
                companyPriority =radios[i].value;
               
                break;
            }
        }
        
        var companyPriorityValue='';
        if(companyPriority == 'L')
        {
            companyPriorityValue = 'Low';
        }
        else if(companyPriority == 'M')
        {
            companyPriorityValue = 'Medium';
        }
        else if(companyPriority == 'H')
        {
            companyPriorityValue = 'High';
        }
        
        var rowId = document.getElementById("hdnRowId").value;
        var rowCnt = rowId.substr(11);
   
        $('#tblCompanyDtls').dataTable().fnUpdate( [
            '<td>'+'<input type="checkbox" name="chkCompanyId" value='+companyId+'>'+'</td>',
            '<td>'+'<a data-toggle="modal" href="#myModal" onclick="populateCompanyData('+rowCnt+','+companyId+','+companyTitle+')">'+companyTitle+'</a>'+'</td>',
            '<td>'+companyCode+'</td>',
            '<td>'+contactPersonName+'</td>',
            '<td>'+contactNumber+'</td>',
            '<td>'+contactAddress+'</td>',
            '<td>'+contactEmail+'</td>',
            '<td>'+companyLocation+'</td>',
            '<td>'+companyPriorityValue+ '</td>',
            '<td align ="center"> <i class="icon-trash" onclick="deleteCompanyDtls(N,'+companyId+','+rowCnt+')"></i></td>' 
            ], row);
       
    }
    catch(e)
    {
        alert(e);
    }
}
  
function populateCompanyData(rowCnt,companyId,companyTitle)
{
    alert("populate");
    resetData();
    var row = document.getElementById("trCompanyId"+rowCnt)
        
    document.getElementById("hdnRowId").value="trCompanyId"+rowCnt;
    document.getElementById("companyId").value = companyId;
    document.getElementById("companyTitle").value = companyTitle;
    document.getElementById("companyCode").value = $('#tblCompanyDtls').dataTable().fnGetData(row,2);
    document.getElementById("contactPersonName").value = $('#tblCompanyDtls').dataTable().fnGetData(row,3);
    document.getElementById("contactNumber").value = $('#tblCompanyDtls').dataTable().fnGetData(row,4);
    document.getElementById("contactAddress").value = $('#tblCompanyDtls').dataTable().fnGetData(row,5);
    document.getElementById("contactEmail").value = $('#tblCompanyDtls').dataTable().fnGetData(row,6);
    document.getElementById("companyLocation").value = $('#tblCompanyDtls').dataTable().fnGetData(row,7);
    var companyPriority = $('#tblCompanyDtls').dataTable().fnGetData(row,8);

    if(companyPriority != '')
    {
        if(companyPriority == 'Low')
        {
            document.getElementById("companyPriorityL").checked = true;
              
        }
        else if(companyPriority == 'Medium')
        {
            document.getElementById("companyPriorityM").checked = true; 
        }
        else if(companyPriority == 'High')
        {
            document.getElementById("companyPriorityH").checked = true; 
        }
    }
    
}


function resetData()
{
    document.getElementById("companyId").value = "";
    document.getElementById("companyTitle").value = "";
    document.getElementById("companyCode").value = "";
    document.getElementById("contactPersonName").value = "";
    document.getElementById("contactNumber").value = "";
    document.getElementById("contactAddress").value = "";
    document.getElementById("contactEmail").value = "";
    document.getElementById("companyLocation").value = "";
    document.getElementById("companyPriorityL").checked = true;
    document.getElementById("companyPriorityM").checked = false;
    document.getElementById("companyPriorityH").checked = false;
}


function deleteCompanyDtls(deleteFlag,companyId,rowCnt)
{ 
    var chkCompanyId = document.getElementsByName('chkCompanyId');
    var companyIds ="";
    var flag = false;
    var rowCntStr ='';
    //For Multiple row delete
    if(deleteFlag == 'Y')
    {
        for(var i=0;i<chkCompanyId.length;i++)
        {
            if(chkCompanyId[i].checked)
            {
                if(companyIds == "")
                {
                    companyIds =  chkCompanyId[i].value;
                    rowCntStr = chkCompanyId[i].id;
                }
                else
                {
                    companyIds =companyIds +"~"+  chkCompanyId[i].value;    
                    rowCntStr =rowCntStr +"~"+ (chkCompanyId[i].id);
                }
                flag = true;
            }
        }
    }
    else
    {
        //For Single row delete
        if(companyId != "")
        {
            companyIds = companyId;
            rowCntStr = "chkCompanyId"+rowCnt;
            flag = true;
        }
    }
   
    try{
        if(flag)
        {
            return $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/CampusLive/deleteCompanyDtls.do?companyIds='+companyIds,
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
                            $('#tblCompanyDtls').dataTable().fnDeleteRow($('#tblCompanyDtls').dataTable().fnGetPosition(row));
                                                 
                        }
                        generate('topRight','Company Details Deleted Successfully.','success');
                        generate('topRight','Click anywhere on the screen to GO back.','info');
                      
                    }
                    
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

function waitFunction()
{
    window.location.reload();
}