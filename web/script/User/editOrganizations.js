/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//validate Organization details
function validateOrganizationDtl()
{
    var orgName = document.getElementById("orgName").value;
   
    if(orgName.trim() == '')
    {
        alert("Please Enter Organization Name");
        document.getElementById("orgName").focus();
        return false;
    }
    return true;
}

//Add New Row in Achievement table
function addNewOrganizationRow()
{
    try
    {
        if(validateOrganizationDtl())
        {
            var rowCnt = document.getElementById("hdnOrgCount").value;
            var table = document.getElementById("tblOrganizationDtl");
 
            var rowCount = table.rows.length;
            var newRow = table.insertRow(rowCount);
               
            var newCell = newRow.insertCell(0);
            newCell.innerHTML = document.getElementById("orgName").value+'<input type="hidden" name="hdnOrgName" id="hdnOrgName'+Number(rowCnt)+'" value="'+document.getElementById("orgName").value+'"/>';
                
            newCell = newRow.insertCell(1);
            newCell.innerHTML = document.getElementById("orgTitle").value+'<input type="hidden" name="hdnOrgTitle" id="hdnOrgTitle'+Number(rowCnt)+'" value="'+document.getElementById("orgTitle").value+'"/>';
                
            var orgStartMonth = document.getElementById("orgStartMonth").value;
            var orgStartYear = document.getElementById("orgStartYear").value;
            var orgStartMonthValue = "";
            var orgStartMonthText = "";
            var orgStartYearValue = "";
            var orgStartYearText = "";
            
            if(orgStartMonth == '-1')
            {
                orgStartMonthValue = "";
                orgStartMonthText = "";
            }
            else
            {
                orgStartMonthValue = document.getElementById("orgStartMonth").value;
                orgStartMonthText = document.getElementById("orgStartMonth").options[document.getElementById("orgStartMonth").selectedIndex].text;
            }
            
            if(orgStartYear == '-1')
            {
                orgStartYearValue = "";
                orgStartYearText = "";
            }
            else
            {
                orgStartYearValue = document.getElementById("orgStartYear").value;
                orgStartYearText = document.getElementById("orgStartYear").options[document.getElementById("orgStartYear").selectedIndex].text;
            }
            newCell = newRow.insertCell(2);
            newCell.innerHTML = orgStartMonthText + " - " + orgStartYearText
            +'<input type="hidden" name="hdnOrgStartMonth" id="hdnOrgStartMonth'+Number(rowCnt)+'" value="'+orgStartMonthValue+'"/>'
            +'<input type="hidden" name="hdnOrgStartYear" id="hdnOrgStartYear'+Number(rowCnt)+'" value="'+orgStartYearValue+'"/>';
                        
            var orgEndMonth = document.getElementById("orgEndMonth").value;
            var orgEndYear = document.getElementById("orgEndYear").value;
            var orgEndMonthValue = "";
            var orgEndMonthText = "";
            var orgEndYearValue = "";
            var orgEndYearText = "";
            
            if(orgEndMonth == '-1')
            {
                orgEndMonthValue = "";
                orgEndMonthText = "";
            }
            else
            {
                orgEndMonthValue = document.getElementById("orgEndMonth").value;
                orgEndMonthText = document.getElementById("orgEndMonth").options[document.getElementById("orgEndMonth").selectedIndex].text;
            }
            
            if(orgEndYear == '-1')
            {
                orgEndYearValue = "";
                orgEndYearText = "";
            }
            else
            {
                orgEndYearValue = document.getElementById("orgEndYear").value;
                orgEndYearText = document.getElementById("orgEndYear").options[document.getElementById("orgEndYear").selectedIndex].text;
            }    
            newCell = newRow.insertCell(3);
            newCell.innerHTML = orgEndMonthText + " - " + orgEndYearText
            +'<input type="hidden" name="hdnOrgEndMonth" id="hdnOrgEndMonth'+Number(rowCnt)+'" value="'+orgEndMonthValue+'"/>'
            +'<input type="hidden" name="hdnOrgEndYear" id="hdnOrgEndYear'+Number(rowCnt)+'" value="'+orgEndYearValue+'"/>';
        
            newCell = newRow.insertCell(4);
            newCell.innerHTML = document.getElementById("orgLocation").value
            +'<input type="hidden" name="hdnOrgLocation" id="hdnOrgLocation'+Number(rowCnt)+'" value="'+document.getElementById("orgLocation").value+'"/>'
            +'<input type="hidden" name="hdnOrgDesc" id="hdnOrgDesc'+Number(rowCnt)+'" value="'+document.getElementById("orgDesc").value+'"/>';
            
        
            newCell = newRow.insertCell(5);
            newCell.innerHTML = '<a href="#" onclick="editOrganizationRow(this,'+Number(rowCnt)+');">Edit</a>/<a href="#" onclick="removeOrgRow(this);">Delete</a>';
                
            document.getElementById("hdnOrgCount").value=Number(rowCnt)+1;
            resetFields();
        }
    }
    catch(e)
    {
        alert(e);
    }
                        
}  

//Remove Row from Achievement table
function removeOrgRow(row)
{
    var rowObj=row.parentNode.parentNode.rowIndex;
    document.getElementById('tblOrganizationDtl').deleteRow(rowObj);

}

//Edit Row data
function editOrganizationRow(row,rowCnt) {
    try {
              
          
        document.getElementById("orgName").value = document.getElementById("hdnOrgName"+rowCnt).value;
        document.getElementById("orgTitle").value = document.getElementById("hdnOrgTitle"+rowCnt).value;
        if(document.getElementById("hdnOrgStartMonth"+rowCnt).value == '')
        {
            document.getElementById("orgStartMonth").value = '-1';
        }
        else
        {
            document.getElementById("orgStartMonth").value = document.getElementById("hdnOrgStartMonth"+rowCnt).value;    
        }
        if(document.getElementById("hdnOrgStartYear"+rowCnt).value == '')
        {
            document.getElementById("orgStartYear").value = '-1';
        }
        else
        {
            document.getElementById("orgStartYear").value = document.getElementById("hdnOrgStartYear"+rowCnt).value;
        }
        if(document.getElementById("hdnOrgEndMonth"+rowCnt).value == '')
        {
            document.getElementById("orgEndMonth").value = '-1';
        }
        else
        {
            document.getElementById("orgEndMonth").value = document.getElementById("hdnOrgEndMonth"+rowCnt).value;
        }
        if(document.getElementById("hdnOrgEndYear"+rowCnt).value == '')
        {
            document.getElementById("orgEndYear").value = '-1';
        }
        else
        {
            document.getElementById("orgEndYear").value = document.getElementById("hdnOrgEndYear"+rowCnt).value;
        }
        
        document.getElementById("orgLocation").value = document.getElementById("hdnOrgLocation"+rowCnt).value;
        document.getElementById("orgDesc").value = document.getElementById("hdnOrgDesc"+rowCnt).value;
       
        document.getElementById("hdnOrgRowCnt").value = rowCnt;
                             
        var rowObj=row.parentNode.parentNode.rowIndex;
                
        document.getElementById("hdnOrgRowObj").value = rowObj;
        document.getElementById("btnUpdateOrg").style.display="inline";
        document.getElementById("btnAddOrg").style.display="none";
    }
    catch(e) {
        alert(e);
    }
}
             
//Update Row data       
function updateOrgRowData()
{
    try {
        if(validateOrganizationDtl())
        {
            var rowCnt = document.getElementById("hdnOrgRowCnt").value;
                
            var i = document.getElementById("hdnOrgRowObj").value;
            var table = document.getElementById("tblOrganizationDtl");
      
            table.rows[i].cells["0"].innerHTML = document.getElementById("orgName").value+'<input type="hidden" name="hdnOrgName" id="hdnOrgName'+Number(rowCnt)+'" value="'+document.getElementById("orgName").value+'"/>';
            table.rows[i].cells["1"].innerHTML = document.getElementById("orgTitle").value+'<input type="hidden" name="hdnOrgTitle" id="hdnOrgTitle'+Number(rowCnt)+'" value="'+document.getElementById("orgTitle").value+'"/>';
                         
            var orgStartMonth = document.getElementById("orgStartMonth").value;
            var orgStartYear = document.getElementById("orgStartYear").value;
            var orgStartMonthValue = "";
            var orgStartMonthText = "";
            var orgStartYearValue = "";
            var orgStartYearText = "";
            
            if(orgStartMonth == '-1')
            {
                orgStartMonthValue = "";
                orgStartMonthText = "";
            }
            else
            {
                orgStartMonthValue = document.getElementById("orgStartMonth").value;
                orgStartMonthText = document.getElementById("orgStartMonth").options[document.getElementById("orgStartMonth").selectedIndex].text;
            }
            
            if(orgStartYear == '-1')
            {
                orgStartYearValue = "";
                orgStartYearText = "";
            }
            else
            {
                orgStartYearValue = document.getElementById("orgStartYear").value;
                orgStartYearText = document.getElementById("orgStartYear").options[document.getElementById("orgStartYear").selectedIndex].text;
            }
            
            table.rows[i].cells["2"].innerHTML = orgStartMonthText + " - " + orgStartYearText
            +'<input type="hidden" name="hdnOrgStartMonth" id="hdnOrgStartMonth'+Number(rowCnt)+'" value="'+orgStartMonthValue+'"/>'
            +'<input type="hidden" name="hdnOrgStartYear" id="hdnOrgStartYear'+Number(rowCnt)+'" value="'+orgStartYearValue+'"/>';
        
            //            table.rows[i].cells["2"].innerHTML = document.getElementById("orgStartMonth").options[document.getElementById("orgStartMonth").selectedIndex].text + " - " + document.getElementById("orgStartYear").value
            //            +'<input type="hidden" name="hdnOrgStartMonth" id="hdnOrgStartMonth'+Number(rowCnt)+'" value="'+document.getElementById("orgStartMonth").value+'"/>'
            //            +'<input type="hidden" name="hdnOrgStartYear" id="hdnOrgStartYear'+Number(rowCnt)+'" value="'+document.getElementById("orgStartYear").value+'"/>';
            //                

            var orgEndMonth = document.getElementById("orgEndMonth").value;
            var orgEndYear = document.getElementById("orgEndYear").value;
            var orgEndMonthValue = "";
            var orgEndMonthText = "";
            var orgEndYearValue = "";
            var orgEndYearText = "";
            
            if(orgEndMonth == '-1')
            {
                orgEndMonthValue = "";
                orgEndMonthText = "";
            }
            else
            {
                orgEndMonthValue = document.getElementById("orgEndMonth").value;
                orgEndMonthText = document.getElementById("orgEndMonth").options[document.getElementById("orgEndMonth").selectedIndex].text;
            }
            
            if(orgEndYear == '-1')
            {
                orgEndYearValue = "";
                orgEndYearText = "";
            }
            else
            {
                orgEndYearValue = document.getElementById("orgEndYear").value;
                orgEndYearText = document.getElementById("orgEndYear").options[document.getElementById("orgEndYear").selectedIndex].text;
            }    
            table.rows[i].cells["3"].innerHTML = orgEndMonthText + " - " + orgEndYearText
            +'<input type="hidden" name="hdnOrgEndMonth" id="hdnOrgEndMonth'+Number(rowCnt)+'" value="'+orgEndMonthValue+'"/>'
            +'<input type="hidden" name="hdnOrgEndYear" id="hdnOrgEndYear'+Number(rowCnt)+'" value="'+orgEndYearValue+'"/>';
        
            //            table.rows[i].cells["3"].innerHTML = document.getElementById("orgEndMonth").options[document.getElementById("orgEndMonth").selectedIndex].text + " - " + document.getElementById("orgEndYear").value
            //            +'<input type="hidden" name="hdnOrgEndMonth" id="hdnOrgEndMonth'+Number(rowCnt)+'" value="'+document.getElementById("orgEndMonth").value+'"/>'
            //            +'<input type="hidden" name="hdnOrgEndYear" id="hdnOrgEndYear'+Number(rowCnt)+'" value="'+document.getElementById("orgEndYear").value+'"/>';

            table.rows[i].cells["4"].innerHTML = document.getElementById("orgLocation").value
            +'<input type="hidden" name="hdnOrgLocation" id="hdnOrgLocation'+Number(rowCnt)+'" value="'+document.getElementById("orgLocation").value+'"/>'
            +'<input type="hidden" name="hdnOrgDesc" id="hdnOrgDesc'+Number(rowCnt)+'" value="'+document.getElementById("orgDesc").value+'"/>';
            
            document.getElementById("hdnOrgRowCnt").value = "";
            document.getElementById("hdnOrgRowObj").value = "";
            document.getElementById("btnUpdateOrg").style.display="none";
            document.getElementById("btnAddOrg").style.display="inline";
            resetFields();
        }
    }
    catch(e) {
        alert(e);
    }
}

//Reset all fields data
function resetFields()
{
    document.getElementById("orgName").value = "";
    document.getElementById("orgTitle").value = "";
    document.getElementById("orgStartMonth").value = "-1";
    document.getElementById("orgStartYear").value = "-1";
    document.getElementById("orgEndMonth").value = "-1";
    document.getElementById("orgEndYear").value = "-1";
    document.getElementById("orgLocation").value = "";
    document.getElementById("orgDesc").value = "";
}   