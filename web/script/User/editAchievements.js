/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//validate Achievement details
function validateAchievementDtl()
{
    var achievementTitle = document.getElementById("achievementTitle").value;
   
    if(achievementTitle.trim() == '')
    {
        alert("Please Enter achievement title");
        document.getElementById("achievementTitle").focus();
        return false;
    }
    return true;
}
//Add New Row in Achievement table
function addNewAchievementRow()
{
    try
    {
        if(validateAchievementDtl())
        {
            var rowCnt = document.getElementById("hdnCount").value;
            var table = document.getElementById("tblAchievementdtl");
 
            var rowCount = table.rows.length;
            var newRow = table.insertRow(rowCount);
               
            var newCell = newRow.insertCell(0);
            newCell.innerHTML = document.getElementById("achievementTitle").value+'<input type="hidden" name="hdnAchievementTitle" id="hdnAchievementTitle'+Number(rowCnt)+'" value="'+document.getElementById("achievementTitle").value+'"/>';
                
            newCell = newRow.insertCell(1);
            newCell.innerHTML = document.getElementById("category").value+'<input type="hidden" name="hdnCategory" id="hdnCategory'+Number(rowCnt)+'" value="'+document.getElementById("category").value+'"/>';
                
            newCell = newRow.insertCell(2);
            newCell.innerHTML = document.getElementById("eventName").value 
            +'<input type="hidden" name="hdnEventName" id="hdnEventName'+Number(rowCnt)+'" value="'+document.getElementById("eventName").value+'"/>';
                        
                
            newCell = newRow.insertCell(3);
            newCell.innerHTML = document.getElementById("organizers").value
            +'<input type="hidden" name="hdnOrganizers" id="hdnOrganizers'+Number(rowCnt)+'" value="'+document.getElementById("organizers").value+'"/>'
            +'<input type="hidden" name="hdnDescription" id="hdnDescription'+Number(rowCnt)+'" value="'+document.getElementById("description").value+'"/>';
        
            newCell = newRow.insertCell(4);
            newCell.innerHTML = '<a href="#" onclick="editAchievementRow(this,'+Number(rowCnt)+');">Edit</a>/<a href="#" onclick="removeRow(this);">Delete</a>';
                
            document.getElementById("hdnCount").value=Number(rowCnt)+1;
            resetFields();
        }
    }
    catch(e)
    {
        alert(e);
    }
                        
}  

//Remove Row from Achievement table
function removeRow(row)
{
    var rowObj=row.parentNode.parentNode.rowIndex;
    document.getElementById('tblAchievementdtl').deleteRow(rowObj);

}

//Edit Row data
function editAchievementRow(row,rowCnt) {
    try {
              
          
        document.getElementById("achievementTitle").value = document.getElementById("hdnAchievementTitle"+rowCnt).value;
        document.getElementById("category").value = document.getElementById("hdnCategory"+rowCnt).value;
        document.getElementById("eventName").value = document.getElementById("hdnEventName"+rowCnt).value;
        document.getElementById("organizers").value = document.getElementById("hdnOrganizers"+rowCnt).value;
        document.getElementById("description").value = document.getElementById("hdnDescription"+rowCnt).value;
       
        document.getElementById("hdnRowCnt").value = rowCnt;
                             
        var rowObj=row.parentNode.parentNode.rowIndex;
                
        document.getElementById("hdnRowObj").value = rowObj;
        document.getElementById("btnUpdate").style.display="inline";
        document.getElementById("btnAdd").style.display="none";
    }
    catch(e) {
        alert(e);
    }
}
             
//Update Row data       
function updateAchmntRowData()
{
    try {
        if(validateAchievementDtl())
        {
            var rowCnt = document.getElementById("hdnRowCnt").value;
                
            var i = document.getElementById("hdnRowObj").value;
            var table = document.getElementById("tblAchievementdtl");
      
            table.rows[i].cells["0"].innerHTML = document.getElementById("achievementTitle").value+'<input type="hidden" name="hdnAchievementTitle" id="hdnAchievementTitle'+Number(rowCnt)+'" value="'+document.getElementById("achievementTitle").value+'"/>';
            table.rows[i].cells["1"].innerHTML = document.getElementById("category").value+'<input type="hidden" name="hdnCategory" id="hdnCategory'+Number(rowCnt)+'" value="'+document.getElementById("category").value+'"/>';
                         
            table.rows[i].cells["2"].innerHTML = document.getElementById("eventName").value
            +'<input type="hidden" name="hdnEventName" id="hdnEventName'+Number(rowCnt)+'" value="'+document.getElementById("eventName").value+'"/>';
        
                 
            table.rows[i].cells["3"].innerHTML = document.getElementById("organizers").value
            +'<input type="hidden" name="hdnOrganizers" id="hdnOrganizers'+Number(rowCnt)+'" value="'+document.getElementById("organizers").value+'"/>'
            +'<input type="hidden" name="hdnDescription" id="hdnDescription'+Number(rowCnt)+'" value="'+document.getElementById("description").value+'"/>';

            document.getElementById("hdnRowCnt").value = "";
            document.getElementById("hdnRowObj").value = "";
            document.getElementById("btnUpdate").style.display="none";
            document.getElementById("btnAdd").style.display="inline";
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
    document.getElementById("achievementTitle").value = "";
    document.getElementById("category").value = "";
    document.getElementById("eventName").value="";
    document.getElementById("organizers").value="";
    document.getElementById("description").value = "";
    document.getElementById("hdnRowCnt").value = "";
}

    
