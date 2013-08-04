/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//validate Project details
function validateProjectDtl()
{
    var projName = document.getElementById("projName").value;
    var projRole = document.getElementById("projRole").value;
   
    if(projName.trim() == '')
    {
        alert("Please Enter Project Name");
        document.getElementById("projName").focus();
        return false;
    }
    else if(projRole.trim() == '')
    {
        alert("Please Enter Project Role");
        document.getElementById("projRole").focus();
        return false;
    }
    return true;
}

function addNewProjRow()
{
    try
    {
        if(validateProjectDtl())
        {
            var rowCnt = document.getElementById("hdnProjCount").value;
            var table = document.getElementById("tblProjectDtl");
 
            var rowCount = table.rows.length;
            var newRow = table.insertRow(rowCount);
               
            var newCell = newRow.insertCell(0);
            newCell.innerHTML = document.getElementById("projName").value+'<input type="hidden" name="hdnProjName" id="hdnProjName'+Number(rowCnt)+'" value="'+document.getElementById("projName").value+'"/>';
                
            newCell = newRow.insertCell(1);
            newCell.innerHTML = document.getElementById("projRole").value+'<input type="hidden" name="hdnProjRole" id="hdnProjRole'+Number(rowCnt)+'" value="'+document.getElementById("projRole").value+'"/>';
                 
            newCell = newRow.insertCell(2);
            newCell.innerHTML = document.getElementById("projStartDate").value+'<input type="hidden" name="hdnProjStartDate" id="hdnProjStartDate'+Number(rowCnt)+'" value="'+document.getElementById("projStartDate").value+'"/>';
        
            newCell = newRow.insertCell(3);
            newCell.innerHTML = document.getElementById("projEndDate").value+'<input type="hidden" name="hdnProjEndDate" id="hdnProjEndDate'+Number(rowCnt)+'" value="'+document.getElementById("projEndDate").value+'"/>'
            +'<input type="hidden" name="hdnProjTeamMembers" id="hdnProjTeamMembers'+Number(rowCnt)+'" value="'+document.getElementById("projTeamMembers").value+'"/>'
            +'<input type="hidden" name="hdnProjDesc" id="hdnProjDesc'+Number(rowCnt)+'" value="'+document.getElementById("projDesc").value+'"/>';

            newCell = newRow.insertCell(4);
            newCell.innerHTML = '<a href="#" onclick="editProjRow(this,'+Number(rowCnt)+');">Edit</a>/<a href="#" onclick="removeProjRow(this);">Delete</a>';
                
            document.getElementById("hdnProjCount").value=Number(rowCnt)+1;
            resetFields();
        }
    }
    catch(e)
    {
        alert(e);
    }
                        
}  

//Remove Row from Achievement table
function removeProjRow(row)
{
    var rowObj=row.parentNode.parentNode.rowIndex;
    document.getElementById('tblProjectDtl').deleteRow(rowObj);

}

//Edit Row data
function editProjRow(row,rowCnt) {
    try {
                    
        document.getElementById("projName").value = document.getElementById("hdnProjName"+rowCnt).value;
        document.getElementById("projRole").value = document.getElementById("hdnProjRole"+rowCnt).value;
        document.getElementById("projStartDate").value = document.getElementById("hdnProjStartDate"+rowCnt).value;
        document.getElementById("projEndDate").value = document.getElementById("hdnProjEndDate"+rowCnt).value;
        document.getElementById("projTeamMembers").value = document.getElementById("hdnProjTeamMembers"+rowCnt).value;
        document.getElementById("projDesc").value = document.getElementById("hdnProjDesc"+rowCnt).value;
              
        document.getElementById("hdnProjRowCnt").value = rowCnt;
                             
        var rowObj=row.parentNode.parentNode.rowIndex;
                
        document.getElementById("hdnProjRowObj").value = rowObj;
        document.getElementById("btnUpdateProj").style.display="inline";
        document.getElementById("btnAddProj").style.display="none";
    }
    catch(e) {
        alert(e);
    }
}
             
//Update Row data       
function updateProjRowData()
{
    try {
        if(validateProjectDtl())
        {
            var rowCnt = document.getElementById("hdnProjRowCnt").value;
                
            var i = document.getElementById("hdnProjRowObj").value;
            var table = document.getElementById("tblProjectDtl");
      
            table.rows[i].cells["0"].innerHTML = document.getElementById("projName").value+'<input type="hidden" name="hdnProjName" id="hdnProjName'+Number(rowCnt)+'" value="'+document.getElementById("projName").value+'"/>';
            table.rows[i].cells["1"].innerHTML = document.getElementById("projRole").value+'<input type="hidden" name="hdnProjRole" id="hdnProjRole'+Number(rowCnt)+'" value="'+document.getElementById("projRole").value+'"/>';
                         
            table.rows[i].cells["2"].innerHTML = document.getElementById("projStartDate").value
            +'<input type="hidden" name="hdnProjStartDate" id="hdnProjStartDate'+Number(rowCnt)+'" value="'+document.getElementById("projStartDate").value+'"/>';
        
            table.rows[i].cells["3"].innerHTML = document.getElementById("projEndDate").value+'<input type="hidden" name="hdnProjEndDate" id="hdnProjEndDate'+Number(rowCnt)+'" value="'+document.getElementById("projEndDate").value+'"/>'
            +'<input type="hidden" name="hdnProjTeamMembers" id="hdnProjTeamMembers'+Number(rowCnt)+'" value="'+document.getElementById("projTeamMembers").value+'"/>'
            +'<input type="hidden" name="hdnProjDesc" id="hdnProjDesc'+Number(rowCnt)+'" value="'+document.getElementById("projDesc").value+'"/>';
    
            document.getElementById("hdnProjRowCnt").value = "";
            document.getElementById("hdnProjRowObj").value = "";
            document.getElementById("btnUpdateProj").style.display="none";
            document.getElementById("btnAddProj").style.display="inline";
       
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
    document.getElementById("projName").value = "";
    document.getElementById("projRole").value = "";
    document.getElementById("projStartDate").value = "";
    document.getElementById("projEndDate").value = "";
    document.getElementById("projTeamMembers").value = "";
    document.getElementById("projDesc").value = "";
}                 
