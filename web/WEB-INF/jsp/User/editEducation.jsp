<!DOCTYPE html>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<c:set var="userEducationDtlList" value="${requestScope.userEducationDtlList}"/>
<c:set var="educationList" value="${requestScope.educationList}"/>
<script type="text/javascript" src="script/User/editEducation.js"></script>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Educational Details</title>
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
  </head>

  <body>

           <!-- ================================================== -->
        <tiles:insert definition="project-template-studentlogin-header" >
             <tiles:put name="studentlogin-header" value="/WEB-INF/jsp/Templates/studentlogin_header.jsp" />
        </tiles:insert>  


    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
            
          <div class="well sidebar-nav">
              <center><h2>Education</h2>
            <img class="img-rounded" src="resources/img/User/education.png"/>
          
          <p>Add/Update your Educational Background here. Including schooling, graduation, post-graduation & doctorate details.</p>
                          _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 
                           <br/><br/>
            </center>
            <ul class="nav nav-list">
              <li class="nav-header">Education Includes</li>
              <li><a href="#">School Name</a></li>
              <li><a href="#">City</a></li>
              <li><a href="#">Batch Year</a></li>
              <li><a href="#">Major Spcl</a></li>
              <li><a href="#">Minor Spcl</a></li>
              <li><a href="#">High School Details</a></li>
              <li><a href="#">Graduation Details</a></li>
              <li><a href="#">Masters Details</a></li>
              <li><a href="#">Doctorate Details</a></li>
              <li><a href="#" style="color: lightcoral">Need More Help ? Click Here</a></li>
              <li><a href="#" style="color: crimson">Have an idea ? Submit Here</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->

        <div class="span9">
            <html:errors/> 
<form class="form-horizontal" action="saveUserEducationDtl.do">
<fieldset>
            

             


  
<!-- Form Name -->

<!-- Text input-->
<br/>

<div class="control-group span5">
  <label class="control-label">Institute Name</label>
  <div class="controls">
      <input id="name" name="name" type="text"  class="input-xlarge" >
      <input id="hdnRowCnt" name="hdnRowCnt" type="hidden"/>
      <input id="hdnRowObj" name="hdnRowObj" type="hidden"/>
  </div>
</div>


<!-- File Button --> 
<div class="control-group span5">
  <label class="control-label">City</label>
  <div class="controls">
    <input id="city" name="city" type="text" placeholder="City Name" class="input-xlarge" >
  </div>
</div>

<!-- Text input-->
<div class="control-group span5">
  <label class="control-label">From</label>
  <div class="controls">
     <select id="fromYear" name="fromYear" style="width: 50%">
          <option value="-1">--Select--</option> 
          <option value="2010">2010</option>
          <option value="2011">2011</option>
          <option value="2012">2012</option>
      </select>
    
  </div>
</div>

<!-- File Button --> 
<div class="control-group span5">
  <label class="control-label">To</label>
  <div class="controls">
   <select id="toYear" name="toYear" style="width: 50%">
          <option value="-1">--Select--</option> 
          <option value="2010">2010</option>
          <option value="2011">2011</option>
          <option value="2012">2012</option>
      </select>
  </div>
</div>



<!-- File Button --> 
<div class="control-group span4">
    <div style="border-bottom: 1px;border-bottom-color: grey" >
  <label class="control-label">University(Spec)</label>
  <div class="controls">
    <input id="specialization" name="specialization" type="text" placeholder="e.g. Technical, Science" class="input-xlarge">
  </div>
</div>
</div>

<div class="control-group span3 offset1">
  <label class="control-label">Title</label>
  <div class="controls">
     
    <select id="title" name="title" class="input-large">
        <option value="-1">-- Select --</option>
        <c:forEach items="${educationList}" var="education">
              <option value="${education.id}">${education.value}</option>
         </c:forEach>
     </select>
  </div>
</div>

<div class="control-group span5">
  <label class="control-label">Major</label>
  <div class="controls">
    <input id="major" name="major" type="text" placeholder="e.g. Operations, Human Resource" class="input-xlarge">
  </div>
</div>
<div class="control-group span5">
  <label class="control-label">Minor</label>
  <div class="controls">
    <input id="minorMajor" name="minorMajor" type="text" placeholder="e.g. Finance,Marketing" class="input-xlarge">
    
  </div>
</div>
<div class="control-group span5">
  <label class="control-label">Percentage</label>
  <div class="controls">
    <input id="percentage" name="percentage" type="text" placeholder="Percentage Out of 100" class="input-xlarge">
  </div>
</div>

<div class="control-group span9">
  
  <div class="controls" >
      <input class="btn btn-large btn-primary" id="btnAdd" type="button" onclick="addNewEducationRow()" value="Add / Update"/>
      <input class="btn btn-large btn-primary" id="btnUpdate" type="button" onclick="updateRowData()" style="display: none" value="Update"/>
      
  </div>
</div>

        

        
       
<div size="100%">
    <input type="hidden" id="hdnCount" name="hdnCount" value="0"/>
<table id="tblEducationdtl" name="tblEducationdtl" border="0" width="90%" size="90%" class="table">
    <thead>
    <tr>
        <th width="20%">Institute Name</td>
        <th width="10%">City</td>
        <th width="10%">From - To</td>
        <th width="10%">Specialization</td>
        <th width="10%">Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userEducationDtlList}" var="userEducationDtl" varStatus="rowCnt">
       <tr>
        <td width="20%">${userEducationDtl.schoolCollegeName}<input type="hidden" name="hdnName" id="hdnName${rowCnt.count}" value="${userEducationDtl.schoolCollegeName}"/></td>
        <td width="10%">${userEducationDtl.schoolCollegeCity}<input type="hidden" name="hdnCity" id="hdnCity${rowCnt.count}" value="${userEducationDtl.schoolCollegeCity}"/></td>
        <td width="10%">${userEducationDtl.schoolCollegeFromYear} - ${userEducationDtl.schoolCollegeToYear}
            <input type="hidden" name="hdnFromYear" id="hdnFromYear${rowCnt.count}" value="${userEducationDtl.schoolCollegeFromYear}"/>
            <input type="hidden" name="hdnToYear" id="hdnToYear${rowCnt.count}" value="${userEducationDtl.schoolCollegeToYear}"/>
        </td>
        <td width="10%">${userEducationDtl.specialization}
            <input type="hidden" name="hdnSpecialization" id="hdnSpecialization${rowCnt.count}" value="${userEducationDtl.specialization}"/>
            <input type="hidden" name="hdnTitle" id="hdnTitle${rowCnt.count}" value="${userEducationDtl.graduationMasterTitle}"/>
            <input type="hidden" name="hdnMajor" id="hdnMajor${rowCnt.count}" value="${userEducationDtl.majorSubject}"/>
            <input type="hidden" name="hdnMinorMajor" id="hdnMinorMajor${rowCnt.count}" value="${userEducationDtl.otherMinorMajorSubject}"/>
            <input type="hidden" name="hdnPercentage" id="hdnPercentage${rowCnt.count}" value="${userEducationDtl.percentage}"/>
        </td>
        <td width="10%"><a href="#" onclick="editRow(this,'${rowCnt.count}');">Edit</a>/<a href="#" onclick="removeRow(this);">Delete</a></td>
       </tr>
       <script>
           var count = '${rowCnt.count}';
           document.getElementById("hdnCount").value=Number(count)+1;
       </script>
    </c:forEach>
       </tbody>
</table>
</div>
       
<br><br><br>


<div class="control-group span9">
  
  <div class="controls">
    <button class="btn btn-large btn-success" type="submit">Save</button>
    
  </div>
</div>

</fieldset>
</form>
          


       </div>
    </div>
 </div>
      <hr>
    
      <footer>
          <p>CampusLive Initiative by <a href="#">Jyot Patel</a> & <a href="#">Bhushan Zalavadia</a></p>
      </footer>

    <!--/.fluid-container-->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
                <script src="resources/js/jquery.js"></script>
                <script src="resources/js/bootstrap-transition.js"></script>
                <script src="resources/js/bootstrap-alert.js"></script>
                <script src="resources/js/bootstrap-modal.js"></script>
                <script src="resources/js/bootstrap-scrollspy.js"></script>
                <script src="resources/js/bootstrap-tab.js"></script>
                <script src="resources/js/bootstrap-tooltip.js"></script>
                <script src="resources/js/bootstrap-popover.js"></script>
                <script src="resources/js/bootstrap-button.js"></script>
                <script src="resources/js/bootstrap-collapse.js"></script>
                <script src="resources/js/bootstrap-carousel.js"></script>
                <script src="resources/js/bootstrap-typeahead.js"></script>

                <script src="resources/assets/js/bootstrap.min.js"></script>


                <script>
                    $(document).ready(function(){
                        $('.dropdown-toggle').dropdown()
                    });
                </script>

                </body>
                </html>
