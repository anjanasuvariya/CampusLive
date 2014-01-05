<!DOCTYPE html>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<c:set var="userProjectDtlList" value="${requestScope.userProjectDtlList}"/>
<script type="text/javascript" src="script/User/editProjects.js"></script>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Work Experience</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
    </style>
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://twitter.github.io/bootstrap/assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="http://twitter.github.io/bootstrap/assets/ico/favicon.png">
                                   

    <script>
function myFunction(name,job)
{

                var num     = $('.clonedInput').length; // how many "duplicatable" input fields we currently have
                var newNum  = new Number(num + 1);      // the numeric ID of the new input field being added
 
                // create the new element via clone(), and manipulate it's ID using newNum value
                var newElem = $('#input' + num).clone().attr('id', 'input' + newNum);
 
                // manipulate the name/id values of the input inside the new element
                newElem.children(':first').attr('id', 'name' + newNum).attr('name', 'name' + newNum);
 
                // insert the new element after the last "duplicatable" input field
                $('#input' + num).after(newElem);
 
                // enable the "remove" button
                $('#btnDel').attr('disabled','');
 
                // business rule: you can only add 5 names
                if (newNum == 5)
                    $('#btnAdd').attr('disabled','disabled');
    
alert("Welcome " + name + ", the " + job);
}
</script>


  </head>

  <body>
      
 <br><br>
            
 
 <form class="form-horizontal" action="saveUserProjectDtls.do" target="_top">
<fieldset>
<!-- Form Name -->
<table width="100%" id="mytable">
    <tbody class="clonedInput">
             <tr>
                 <td>
<!-- Text input-->
<div class="control-group">
  <label class="control-label">Project Name</label>
  <div class="controls">
    <input id="projName" name="projName" type="text" placeholder="e.g. Supply Management System" class="input-xlarge" >
    <input id="hdnProjRowCnt" name="hdnProjRowCnt" type="hidden"/>
    <input id="hdnProjRowObj" name="hdnProjRowObj" type="hidden"/>
  </div>
</div>
              </td>
              <td></td>
            </tr>
            <tr><td>
<!-- Text input-->
<div class="control-group">
  <label class="control-label">Role</label>
  <div class="controls">
    <input id="projRole" name="projRole" type="text" placeholder="Your Role in this project" class="input-xlarge" >
    
  </div>
</div>
</td>
<td></td>
            </tr>
            <tr><td>
<!-- Select Basic -->
<div class="control-group span4">
  <label class="control-label">Start Date</label>
  <div class="controls">
    <input type="date" id="projStartDate" name ="projStartDate" placeholder="Project joining date" class="input-xlarge"/>
  </div>
</div>
</td>
<td>
<!-- Select Basic -->
<div class="control-group pull-left">
  <label class="control-label">End Date</label>
  <div class="controls">
      <input type="date" id ="projEndDate" name ="projEndDate" placeholder="Project release date" class="input-xlarge"/>
  </div>
</div>
</td>            </tr>
            <tr>
<!-- Select Basic -->
<td>
         
</td>
<!-- Select Basic -->
<td>
         
</td>
            </tr>
            <tr>
<!-- Textarea -->
<td>
         <div class="control-group">
  <label class="control-label">Team Members</label>
  <div class="controls">                     
    <textarea id="projTeamMembers" name="projTeamMembers"></textarea>
  </div>
</div>
</td><td></td>    
            </tr>
            <tr>
<!-- Textarea -->
<td>
<div class="control-group">
  <label class="control-label">Description</label>
  <div class="controls">                     
    <textarea id="projDesc" name="projDesc"></textarea>
  </div>
</div>
<td><td></td>        </tr>
            <tr>
<!-- Button --><td>
<div class="control-group">
  <label class="control-label"></label>
  <div class="controls">
      <input type="button" id="btnAddProj" name="btnAddProj" value="Add Project" class="btn btn-primary btn-large" onclick="addNewProjRow()"/>
      <input type="button" id="btnUpdateProj" name="btnUpdateProj" value="Update" style="display:none" class="btn btn-primary btn-large" onclick="updateProjRowData()"/>
        
  </div>
</div>
</td>
<div size="100%">
    <input type="hidden" id="hdnProjCount" name="hdnProjCount" value="0"/>
<table id="tblProjectDtl" name="tblProjectDtl" border="0" width="98%" size="90%" class="table">
    <thead>
    <tr>
        <th width="20%">Project Name</td>
        <th width="10%">Role</td>
        <th width="10%">Start Date</td>
        <th width="10%">End Date</td>
        <th width="10%">Action</td>
    </tr>
    </thead>
    <tbody>
     <c:forEach items="${userProjectDtlList}" var="userProjectDtl" varStatus="rowCnt">
       <tr>
        <td width="20%">${userProjectDtl.projName}<input type="hidden" name="hdnProjName" id="hdnProjName${rowCnt.count}" value="${userProjectDtl.projName}"/>
        <td width="10%">${userProjectDtl.projRole}<input type="hidden" name="hdnProjRole" id="hdnProjRole${rowCnt.count}" value="${userProjectDtl.projRole}"/></td>
        <td width="10%">${userProjectDtl.projStartDate}
            <input type="hidden" name="hdnProjStartDate" id="hdnProjStartDate${rowCnt.count}" value="${userProjectDtl.projStartDate}"/>
       </td>
       <td width="10%">${userProjectDtl.projEndDate}
            <input type="hidden" name="hdnProjEndDate" id="hdnProjEndDate${rowCnt.count}" value="${userProjectDtl.projEndDate}"/>
            <input type="hidden" name="hdnProjTeamMembers" id="hdnProjTeamMembers${rowCnt.count}" value="${userProjectDtl.projTeamMembers}"/>
            <input type="hidden" name="hdnProjDesc" id="hdnProjDesc${rowCnt.count}" value="${userProjectDtl.projDescription}"/>
       </td>
       
        <td width="10%"><a href="#" onclick="editProjRow(this,'${rowCnt.count}');">Edit</a>/<a href="#" onclick="removeProjRow(this);">Delete</a></td>
       </tr>
       <script>
           var count = '${rowCnt.count}';
           document.getElementById("hdnProjCount").value=Number(count)+1;
       </script>
    </c:forEach>
</tbody>
</table>
</div>
<td>
<br/><br/>
<!-- Button -->
<div class="control-group">
  <label class="control-label"></label>
  <div class="controls">
    <button id="btnProjSubmit" name="btnProjSubmit" class="btn btn-inverse btn-large">Save</button>
  </div>
</div></td>
            </tr>
           
    </tbody>
</table>
</fieldset>

</form>

   
    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="resources/js/jquery.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-transition.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-alert.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-modal.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-dropdown.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-scrollspy.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-tab.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-tooltip.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-popover.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-button.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-collapse.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-carousel.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-typeahead.js"></script>

  </body>
</html>
