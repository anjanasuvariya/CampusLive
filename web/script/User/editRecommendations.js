/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//validate Recommendation details
function validateRecmdDtl()
{
    var recmdTitle = document.getElementById("recmdTitle").value;
    var recmdBy = document.getElementById("recmdBy").value;
   
    if(recmdTitle.trim() == '')
    {
        alert("Please Enter Recommendation Title.");
        document.getElementById("recmdTitle").focus();
        return false;
    }
    else if(recmdBy.trim() == '')
    {
        alert("Please Enter Recommended by");
        document.getElementById("recmdBy").focus();
        return false;
    }
    return true;
}

//Add New Row in Achievement table
function addNewRecmdRow()
{
    try
    {
        if(validateRecmdDtl())
        {
            var rowCnt = document.getElementById("hdnRecmdCount").value;
            var table = document.getElementById("tblRecommendationDtl");
 
            var rowCount = table.rows.length;
            var newRow = table.insertRow(rowCount);
               
            var newCell = newRow.insertCell(0);
            newCell.innerHTML = document.getElementById("recmdTitle").value+'<input type="hidden" name="hdnRecmdTitle" id="hdnRecmdTitle'+Number(rowCnt)+'" value="'+document.getElementById("recmdTitle").value+'"/>';
                
            newCell = newRow.insertCell(1);
            newCell.innerHTML = document.getElementById("recmdBy").value+'<input type="hidden" name="hdnRecmdBy" id="hdnRecmdBy'+Number(rowCnt)+'" value="'+document.getElementById("recmdBy").value+'"/>';
        
            newCell = newRow.insertCell(2);
            newCell.innerHTML = document.getElementById("recmdLocation").value+'<input type="hidden" name="hdnRecmdLocation" id="hdnRecmdLocation'+Number(rowCnt)+'" value="'+document.getElementById("recmdLocation").value+'"/>'
            +'<input type="hidden" name="hdnRecmdDesc" id="hdnRecmdDesc'+Number(rowCnt)+'" value="'+document.getElementById("recmdDesc").value+'"/>';
                
            newCell = newRow.insertCell(3);
            newCell.innerHTML = '<a href="#" onclick="editRecmdRow(this,'+Number(rowCnt)+');">Edit</a>/<a href="#" onclick="removeRecmdRow(this);">Delete</a>';
                
            document.getElementById("hdnRecmdCount").value=Number(rowCnt)+1;
            resetFields();
        }
    }
    catch(e)
    {
        alert(e);
    }
                        
}  

//Remove Row from Achievement table
function removeRecmdRow(row)
{
    var rowObj=row.parentNode.parentNode.rowIndex;
    document.getElementById('tblRecommendationDtl').deleteRow(rowObj);

}

//Edit Row data
function editRecmdRow(row,rowCnt) {
    try {
                  
        document.getElementById("recmdTitle").value = document.getElementById("hdnRecmdTitle"+rowCnt).value;
        document.getElementById("recmdBy").value = document.getElementById("hdnRecmdBy"+rowCnt).value;
        document.getElementById("recmdLocation").value = document.getElementById("hdnRecmdLocation"+rowCnt).value;
        document.getElementById("recmdDesc").value = document.getElementById("hdnRecmdDesc"+rowCnt).value;
             
        document.getElementById("hdnRecmdRowCnt").value = rowCnt;
                             
        var rowObj=row.parentNode.parentNode.rowIndex;
                
        document.getElementById("hdnRecmdRowObj").value = rowObj;
        document.getElementById("btnUpdateRecmd").style.display="inline";
        document.getElementById("btnAddRecmd").style.display="none";
    }
    catch(e) {
        alert(e);
    }
}
             
//Update Row data       
function updateRecmdRowData()
{
    try {
        if(validateRecmdDtl())
        {
            var rowCnt = document.getElementById("hdnRecmdRowCnt").value;
                
            var i = document.getElementById("hdnRecmdRowObj").value;
            var table = document.getElementById("tblRecommendationDtl");
      
            table.rows[i].cells["0"].innerHTML = document.getElementById("recmdTitle").value+'<input type="hidden" name="hdnRecmdTitle" id="hdnRecmdTitle'+Number(rowCnt)+'" value="'+document.getElementById("recmdTitle").value+'"/>';
            table.rows[i].cells["1"].innerHTML = document.getElementById("recmdBy").value+'<input type="hidden" name="hdnRecmdBy" id="hdnRecmdBy'+Number(rowCnt)+'" value="'+document.getElementById("recmdBy").value+'"/>';
                         
            table.rows[i].cells["2"].innerHTML = document.getElementById("recmdLocation").value+'<input type="hidden" name="hdnRecmdLocation" id="hdnRecmdLocation'+Number(rowCnt)+'" value="'+document.getElementById("recmdLocation").value+'"/>'
            +'<input type="hidden" name="hdnRecmdDesc" id="hdnRecmdDesc'+Number(rowCnt)+'" value="'+document.getElementById("recmdDesc").value+'"/>';
                
        
            document.getElementById("hdnRecmdRowCnt").value = "";
            document.getElementById("hdnRecmdRowObj").value = "";
            document.getElementById("btnUpdateRecmd").style.display="none";
            document.getElementById("btnAddRecmd").style.display="inline";
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
    document.getElementById("recmdTitle").value = "";
    document.getElementById("recmdBy").value = "";
    document.getElementById("recmdLocation").value = "";
    document.getElementById("recmdDesc").value = "";
       
}   
