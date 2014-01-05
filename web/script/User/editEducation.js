/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//validate education details
function validateEducationDtl()
{
    var schoolCollegeName = document.getElementById("name").value;
    var gradTitle =  document.getElementById("title").value;
    if(schoolCollegeName.trim() == '')
    {
        alert("Please Enter School/High School/College/Institute Name");
        document.getElementById("name").focus();
        return false;
    }
    else if(gradTitle.trim() == '')
    {
        alert("Please Enter Graduation/Masters/Doctorate title");
        document.getElementById("title").focus();
        return false;
    }
    return true;
}
//Add New Row in education table
function addNewEducationRow()
{
    try
    {
        if(validateEducationDtl())
        {
        
            var rowCnt = document.getElementById("hdnCount").value;
            var table = document.getElementById("tblEducationdtl");
 
            var rowCount = table.rows.length;
            var newRow = table.insertRow(rowCount);
               
            var newCell = newRow.insertCell(0);
            newCell.innerHTML = document.getElementById("name").value+'<input type="hidden" name="hdnName" id="hdnName'+Number(rowCnt)+'" value="'+document.getElementById("name").value+'"/>';
                
            newCell = newRow.insertCell(1);
            newCell.innerHTML = document.getElementById("city").value+'<input type="hidden" name="hdnCity" id="hdnCity'+Number(rowCnt)+'" value="'+document.getElementById("city").value+'"/>';
                
            var fromYear = document.getElementById("fromYear").value;
            var toYear = document.getElementById("toYear").value
            if(fromYear == '-1')
            {
                fromYear = "";  
            }
            if(toYear == '-1')
            {
                toYear = "";
            }
            alert("adding");
            newCell = newRow.insertCell(2);
            newCell.innerHTML = fromYear +' - '+ toYear
                +'<input type="hidden" name="hdnFromYear" id="hdnFromYear'+Number(rowCnt)+'" value="'+fromYear+'"/>'
                +'<input type="hidden" name="hdnToYear" id="hdnToYear'+Number(rowCnt)+'" value="'+toYear+'"/>'
           
                
            newCell = newRow.insertCell(3);
            newCell.innerHTML = document.getElementById("specialization").value
            +'<input type="hidden" name="hdnSpecialization" id="hdnSpecialization'+Number(rowCnt)+'" value="'+document.getElementById("specialization").value+'"/>'
            +'<input type="hidden" name="hdnTitle" id="hdnTitle'+Number(rowCnt)+'" value="'+document.getElementById("title").value+'"/>'
            +'<input type="hidden" name="hdnMajor" id="hdnMajor'+Number(rowCnt)+'" value="'+document.getElementById("major").value+'"/>'
            +'<input type="hidden" name="hdnMinorMajor" id="hdnMinorMajor'+Number(rowCnt)+'" value="'+document.getElementById("minorMajor").value+'"/>'
            +'<input type="hidden" name="hdnPercentage" id="hdnPercentage'+Number(rowCnt)+'" value="'+document.getElementById("percentage").value+'"/>';

            newCell = newRow.insertCell(4);
            newCell.innerHTML = '<a href="#" onclick="editRow(this,'+Number(rowCnt)+');">Edit</a>/<a href="#" onclick="removeRow(this);">Delete</a>';
                
            document.getElementById("hdnCount").value=Number(rowCnt)+1;
            resetFields();
        }
    }
    catch(e)
    {
        alert(e);
    }
                        
}  

//Remove Row from education table
function removeRow(row)
{
    var i=row.parentNode.parentNode.rowIndex;
    document.getElementById('tblEducationdtl').deleteRow(i);

}

//Edit Row data
function editRow(row,rowCnt) {
    try {
                
        document.getElementById("name").value = document.getElementById("hdnName"+rowCnt).value;
        document.getElementById("city").value = document.getElementById("hdnCity"+rowCnt).value;
        document.getElementById("specialization").value = document.getElementById("hdnSpecialization"+rowCnt).value;
        document.getElementById("fromYear").value = document.getElementById("hdnFromYear"+rowCnt).value;
        document.getElementById("toYear").value = document.getElementById("hdnToYear"+rowCnt).value;
        document.getElementById("title").value = document.getElementById("hdnTitle"+rowCnt).value;
        document.getElementById("major").value = document.getElementById("hdnMajor"+rowCnt).value;
        document.getElementById("minorMajor").value = document.getElementById("hdnMinorMajor"+rowCnt).value;
        document.getElementById("percentage").value = document.getElementById("hdnPercentage"+rowCnt).value;
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
function updateRowData()
{
    try {
        if(validateEducationDtl())
        {
        
            var rowCnt = document.getElementById("hdnRowCnt").value;

            var i = document.getElementById("hdnRowObj").value;
            var table = document.getElementById("tblEducationdtl");

            table.rows[i].cells["0"].innerHTML = document.getElementById("name").value+'<input type="hidden" name="hdnName" id="hdnName'+Number(rowCnt)+'" value="'+document.getElementById("name").value+'"/>';
            table.rows[i].cells["1"].innerHTML = document.getElementById("city").value+'<input type="hidden" name="hdnCity" id="hdnCity'+Number(rowCnt)+'" value="'+document.getElementById("city").value+'"/>';

            var fromYear = document.getElementById("fromYear").value;
            var toYear = document.getElementById("toYear").value
            if(fromYear == '-1')
            {
                fromYear = "";  
            }
            if(toYear == '-1')
            {
                toYear = "";
            }
            table.rows[i].cells["2"].innerHTML = fromYear +' - '+ toYear
            +'<input type="hidden" name="hdnFromYear" id="hdnFromYear'+Number(rowCnt)+'" value="'+fromYear+'"/>'
            +'<input type="hidden" name="hdnToYear" id="hdnToYear'+Number(rowCnt)+'" value="'+toYear+'"/>';

            table.rows[i].cells["3"].innerHTML = document.getElementById("specialization").value
            +'<input type="hidden" name="hdnSpecialization" id="hdnSpecialization'+Number(rowCnt)+'" value="'+document.getElementById("specialization").value+'"/>'
            +'<input type="hidden" name="hdnTitle" id="hdnTitle'+Number(rowCnt)+'" value="'+document.getElementById("title").value+'"/>'
            +'<input type="hidden" name="hdnMajor" id="hdnMajor'+Number(rowCnt)+'" value="'+document.getElementById("major").value+'"/>'
            +'<input type="hidden" name="hdnMinorMajor" id="hdnMinorMajor'+Number(rowCnt)+'" value="'+document.getElementById("minorMajor").value+'"/>'
            +'<input type="hidden" name="hdnPercentage" id="hdnPercentage'+Number(rowCnt)+'" value="'+document.getElementById("percentage").value+'"/>';


            document.getElementById("hdnName"+rowCnt).value = document.getElementById("name").value ;
            document.getElementById("hdnCity"+rowCnt).value = document.getElementById("city").value ;
            document.getElementById("hdnSpecialization"+rowCnt).value = document.getElementById("specialization").value;
            document.getElementById("hdnTitle"+rowCnt).value = document.getElementById("title").value;
            document.getElementById("hdnMajor"+rowCnt).value = document.getElementById("major").value ;
            document.getElementById("hdnMinorMajor"+rowCnt).value = document.getElementById("minorMajor").value ;
            document.getElementById("hdnPercentage"+rowCnt).value = document.getElementById("percentage").value ;
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
    document.getElementById("name").value = "";
    document.getElementById("city").value = "";
    document.getElementById("fromYear").value="-1";
    document.getElementById("toYear").value="-1";
    document.getElementById("specialization").value = "";
    document.getElementById("title").value = "";
    document.getElementById("major").value = "";
    document.getElementById("minorMajor").value = "";
    document.getElementById("percentage").value="";
    document.getElementById("hdnRowCnt").value = "";
    alert("here");
    
}

