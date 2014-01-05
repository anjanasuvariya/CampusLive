<!DOCTYPE html>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<c:set var="userRecommendationDtlList" value="${requestScope.userRecommendationDtlList}"/>
<script type="text/javascript" src="script/User/editRecommendations.js"></script>


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
  
              
 <form class="form-horizontal" action="saveUserRecommendationDtls.do" target="_top">
<fieldset>
<!-- Form Name -->
<table width="100%" id="mytable">
    <tbody class="clonedInput">
             <tr>
                 <td>
<!-- Text input-->
<div class="control-group">
  <label class="control-label">Title</label>
  <div class="controls">
    <input id="recmdTitle" name="recmdTitle" type="text" placeholder="e.g. At TCS Pvt Ltd" class="input-xlarge">
    <input id="hdnRecmdRowCnt" name="hdnRecmdRowCnt" type="hidden"/>
    <input id="hdnRecmdRowObj" name="hdnRecmdRowObj" type="hidden"/>
  </div>
</div>
              </td>
              <td></td>
            </tr>
            <tr><td>
<!-- Text input-->
<div class="control-group">
  <label class="control-label">Recommended by</label>
  <div class="controls">
    <input id="recmdBy" name="recmdBy" type="text" placeholder="The one who recommends you" class="input-xlarge" >
    
  </div>
</div>
</td>
<td></td>
            </tr>
            <tr>
<!-- Textarea -->
<td>
         <div class="control-group">
  <label class="control-label">Company / Location</label>
  <div class="controls">                     
        <input id="recmdLocation" name="recmdLocation" type="text" placeholder="e.g. at Wipro or Mumbai" class="input-xlarge" >
  </div>
</div>
</td><td></td>    
            </tr>
            <tr>
<!-- Textarea -->
<td>
<div class="control-group">
  <label class="control-label">Recommendation Description</label>
  <div class="controls">                     
    <textarea id="recmdDesc" name="recmdDesc"></textarea>
  </div>
</div>
<td><td></td>        </tr>
            <tr>
<!-- Button --><td>
<div class="control-group">
  <label class="control-label"></label>
  <div class="controls">
      <input type="button" id="btnAddRecmd" name="btnAddRecmd" value="Add Recommendation" class="btn btn-primary btn-large" onclick="addNewRecmdRow()"/>
      <input type="button" id="btnUpdateRecmd" name="btnUpdateRecmd" value="Update" style="display:none" class="btn btn-primary btn-large" onclick="updateRecmdRowData()"/>
    
    
  </div>
</div>
</td>
<input type="hidden" id="hdnRecmdCount" name="hdnRecmdCount" value="0"/>
<table id="tblRecommendationDtl" name="tblRecommendationDtl" border="0" width="98%" size="98%" class="table">
    <thead>
    <tr>
        <th width="20%">Title</td>
        <th width="10%">Recommended By</td>
        <th width="10%">Company / Location</td>
        <th width="10%">Action</td>
    </tr>
    </thead>
    <tbody>
     <c:forEach items="${userRecommendationDtlList}" var="userRecommendationDtl" varStatus="rowCnt">
       <tr>
        <td width="20%">${userRecommendationDtl.recmdTitle}<input type="hidden" name="hdnRecmdTitle" id="hdnRecmdTitle${rowCnt.count}" value="${userRecommendationDtl.recmdTitle}"/></td>
        <td width="10%">${userRecommendationDtl.recmdBy}<input type="hidden" name="hdnRecmdBy" id="hdnRecmdBy${rowCnt.count}" value="${userRecommendationDtl.recmdBy}"/></td>
        <td width="10%">${userRecommendationDtl.recmdCompanyLocation}
            <input type="hidden" name="hdnRecmdLocation" id="hdnRecmdLocation${rowCnt.count}" value="${userRecommendationDtl.recmdCompanyLocation}"/>
            <input type="hidden" name="hdnRecmdDesc" id="hdnRecmdDesc${rowCnt.count}" value="${userRecommendationDtl.recmdDescription}"/>
        </td>
        
       
        <td width="10%"><a href="#" onclick="editRecmdRow(this,'${rowCnt.count}');">Edit</a>/<a href="#" onclick="removeRecmdRow(this);">Delete</a></td>
       </tr>
       <script>
           var count = '${rowCnt.count}';
           document.getElementById("hdnRecmdCount").value=Number(count)+1;
       </script>
    </c:forEach>
       </tbody>
</table>
<tr>
<td>
<br/><br/>
<!-- Button -->
<div class="control-group">
  <label class="control-label"></label>
  <div class="controls">
    <button id="btnRecmdSubmit" name="btnRecmdSubmit" class="btn btn-success btn-large">Save</button>
  </div>
</div></td>
            </tr>

    </tbody>
</table>
</fieldset>
</form>

    
      
  </body>
</html>
