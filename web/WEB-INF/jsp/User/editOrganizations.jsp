<!DOCTYPE html>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<c:set var="userOrganizationDtlList" value="${requestScope.userOrganizationDtlList}"/>
<script type="text/javascript" src="script/User/editOrganizations.js"></script>


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
      
    <div class="span12">
          <div class=" sidebar-nav">
               
              <form class="form-horizontal" action="saveUserOrganizationDtls.do" target="_top">
<fieldset>
<!-- Form Name -->

<!-- Text input-->
<div class="control-group">
  <label class="control-label">Name</label>
  <div class="controls">
    <input id="orgName" name="orgName" type="text" placeholder="e.g. Tata Consultancy Services Pvt Ltd." class="input-xlarge" ><input id="hdnOrgRowCnt" name="hdnRowCnt" type="hidden"/><input id="hdnOrgRowObj" name="hdnRowObj" type="hidden"/>
  </div>
</div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label">Title</label>
  <div class="controls">
    <input id="orgTitle" name="orgTitle" type="text" placeholder="Your Designation at this company" class="input-xlarge" >
    
  </div>
</div>

            
<!-- Select Basic -->
<div class="control-group span6">
  <label class="control-label ">Start Month</label>
  <div class="controls">
    <select id="orgStartMonth" name="orgStartMonth" class="input-xlarge">
      <option value="-1">--Select--</option>
      <option value="1">Jan</option>
      <option value="2">Feb</option>
      <option value="3">Mar</option>
      <option value="4">Apr</option>
      <option value="5">May</option>
      <option value="6">Jun</option>
      <option value="7">Jul</option>
      <option value="8">Aug</option>
      <option value="9">Sep</option>
      <option value="10">Oct</option>
      <option value="11">Nov</option>
      <option value="12">Dec</option>
    </select>
  </div>
</div>
<!-- Select Basic -->
<div class="control-group span6">
  <label class="control-label ">Start Year</label>
  <div class="controls">
    <select id="orgStartYear" name="orgStartYear" class="input-xlarge">
      <option value="-1">--Select--</option>
      <option value="2001">2001</option>
      <option value="2002">2002</option>
      <option value="2003">2003</option>
      <option value="2004">2004</option>
      <option value="2005">2005</option>
      <option value="2006">2006</option>
      <option value="2007">2007</option>
      <option value="2008">2008</option>
      <option value="2009">2009</option>
      <option value="2010">2010</option>
      <option value="2011">2011</option>
      <option value="2012">2012</option>
      <option value="2013">2013</option>
    </select>
  </div>
</div>

         <div class="control-group span6">
  <label class="control-label">End Month</label>
  <div class="controls">
    <select id="orgEndMonth" name="orgEndMonth" class="input-xlarge">
      <option value="-1">--Select--</option>
      <option value="1">Jan</option>
      <option value="2">Feb</option>
      <option value="3">Mar</option>
      <option value="4">Apr</option>
      <option value="5">May</option>
      <option value="6">Jun</option>
      <option value="7">Jul</option>
      <option value="8">Aug</option>
      <option value="9">Sep</option>
      <option value="10">Oct</option>
      <option value="11">Nov</option>
      <option value="12">Dec</option>
    </select>
  </div>
</div>
         <div class="control-group span6">
  <label class="control-label">End Year</label>
  <div class="controls">
    <select id="orgEndYear" name="orgEndYear" class="input-xlarge">
      <option value="-1">--Select--</option>
      <option value="2001">2001</option>
      <option value="2002">2002</option>
      <option value="2003">2003</option>
      <option value="2004">2004</option>
      <option value="2005">2005</option>
      <option value="2006">2006</option>
      <option value="2007">2007</option>
      <option value="2008">2008</option>
      <option value="2009">2009</option>
      <option value="2010">2010</option>
      <option value="2011">2011</option>
      <option value="2012">2012</option>
      <option value="2013">2013</option>
    </select>
  </div>
</div>
 <div class="control-group span12">
  <label class="control-label">WorkEx Area</label>
  <div class="controls"> 
      <input id="orgWorkExArea" name="orgWorkExArea" type="text" placeholder="Work Experience area" class="input-xlarge" >
    
  </div>
</div>
         <div class="control-group span12">
  <label class="control-label">Location</label>
  <div class="controls">                     
        <input id="orgLocation" name="orgLocation" type="text" placeholder="City where you worked" class="input-xlarge" >
  </div>
</div>

<div class="control-group span12" >
  <label class="control-label">Description</label>
  <div class="controls">                     
    <textarea id="orgDesc" name="orgDesc"></textarea>
  </div>
</div>

<div class="control-group">
  <label class="control-label"></label>
  <div class="controls">
      <input type="button" id="btnAddOrg" name="btnAddOrg" value="Add Company" class="btn btn-primary btn-large" onclick="addNewOrganizationRow()"/>
      <input type="button" id="btnUpdateOrg" name="btnUpdateOrg" value="Update" style="display:none" class="btn btn-primary btn-large" onclick="updateOrgRowData()"/>
    
  </div>
</div>

<input type="hidden" id="hdnOrgCount" name="hdnOrgCount" value="0"/>
<table id="tblOrganizationDtl" name="tblOrganizationDtl" border="0" width="98%" size="100%" class="table">
    <thead>
    <tr>
        <th width="20%">Organization Name</td>
        <th width="10%">Title</td>
        <th width="10%">Start Month - Year</td>
        <th width="10%">End Month - Year</td>
        <th width="10%">Location</td>
        <th width="10%">Action</td>
    </tr>
    </thead>
    <tbody>
     <c:forEach items="${userOrganizationDtlList}" var="userOrganizationDtl" varStatus="rowCnt">
       <tr>
        <td width="20%">${userOrganizationDtl.orgName}<input type="hidden" name="hdnOrgName" id="hdnOrgName${rowCnt.count}" value="${userOrganizationDtl.orgName}"/></td>
        <td width="10%">${userOrganizationDtl.orgTitle}<input type="hidden" name="hdnOrgTitle" id="hdnOrgTitle${rowCnt.count}" value="${userOrganizationDtl.orgTitle}"/></td>
        <td width="10%">${userOrganizationDtl.orgStartMonth} - ${userOrganizationDtl.orgStartYear}
            <input type="hidden" name="hdnOrgStartMonth" id="hdnOrgStartMonth${rowCnt.count}" value="${userOrganizationDtl.orgStartMonth}"/>
            <input type="hidden" name="hdnOrgStartYear" id="hdnOrgStartYear${rowCnt.count}" value="${userOrganizationDtl.orgStartYear}"/>
        </td>
        <td width="10%">${userOrganizationDtl.orgEndMonth} - ${userOrganizationDtl.orgEndYear}
            <input type="hidden" name="hdnOrgEndMonth" id="hdnOrgEndMonth${rowCnt.count}" value="${userOrganizationDtl.orgEndMonth}"/>
            <input type="hidden" name="hdnOrgEndYear" id="hdnOrgEndYear${rowCnt.count}" value="${userOrganizationDtl.orgEndYear}"/>
        </td>
        <td width="10%">${userOrganizationDtl.orgLocation}
            <input type="hidden" name="hdnOrgWorkExArea" id="hdnOrgWorkExArea${rowCnt.count}" value="${userOrganizationDtl.orgWorkExArea}"/>
            <input type="hidden" name="hdnOrgLocation" id="hdnOrgLocation${rowCnt.count}" value="${userOrganizationDtl.orgLocation}"/>
            <input type="hidden" name="hdnOrgDesc" id="hdnOrgDesc${rowCnt.count}" value="${userOrganizationDtl.orgDescription}"/>
        </td>
        <td width="10%"><a href="#" onclick="editOrganizationRow(this,'${rowCnt.count}');">Edit</a>/<a href="#" onclick="removeOrgRow(this);">Delete</a></td>
       </tr>
       <script>
           var count = '${rowCnt.count}';
           document.getElementById("hdnOrgCount").value=Number(count)+1;
       </script>
    </c:forEach>
       </tbody>
</table>

<br/><br/>
<!-- Button -->
<div class="control-group">
  <label class="control-label"></label>
  <div class="controls">
    <button id="orgSubmit" name="orgSubmit" class="btn btn-success btn-large">Save</button>
  </div>
</div>
           

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
