<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<c:set var="userContactDtl" value="${requestScope.userContactDtl}"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Contact Details - ${sessionScope.userName}</title>
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
              <center><h2>Contact Info</h2>
            <img class="img-rounded" src="resources/img/User/contactinfo.png"/>
          
          <p>Check your current contact details on the right and update the same.</p>
                                      _________________________
                           <br/><br/>
            </center>
            <ul class="nav nav-list">
              <li class="nav-header active">Contact Details Include</li>
              <li><a href="#">Mobile Number</a></li>
              <li><a href="#">Home Contact</a></li>
              <li><a href="#">Work Phone</a></li>
              <li><a href="#">Campus Webmail</a></li>
              <li><a href="#">Email ID</a></li>
              <li><a href="#">Website Addr</a></li>
              <li><a href="#">Blog Address</a></li>
              <li><a href="#">Current Address</a></li>
              
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          <div class="well sidebar-nav">
<html:errors/>            
<form class="form-horizontal" action="saveUserContactDtls.do">
<fieldset>
    <input type="hidden" id="userContactId" name="userContactId" value="${userContactDtl.userContactId}"/>
    <input type="hidden" id="createdUserId" name="createdUserId" value="${userContactDtl.createdUserId}"/>
    <input type="hidden" id="createdDate" name="createdDate" value="${userContactDtl.createdDate}"/>
    <input type="hidden" id="universityId" name="universityId" value="${userContactDtl.universityId}"/>
<!-- Form Name -->

<!-- Text input-->
<h3 class="span11 offset1">Phone, Web & Address Details</h3>
<div class="control-group">
  <label class="control-label">Mobile Number</label>
  <div class="controls">
      <input id="mobileNo" name="mobileNo" type="text" placeholder="e.g. +942-950-0361" class="input-xlarge" value="${userContactDtl.mobileNo}">
  </div>
</div>

<div class="control-group">
 
<label class="control-label">Home Contact</label>
<div class="controls"> 
<input id="homeContactNo" name="homeContactNo" type="text" placeholder="e.g. +91-281-2584420" class="input-xlarge"  value="${userContactDtl.homeContactNo}">    
  </div>
</div>
<div class="control-group">
  <label class="control-label">Work Phone</label>
  <div class="controls">
    <input id="workPhoneNo" name="workPhoneNo" type="text" placeholder="Extn:079-6671-2678" class="input-xlarge"  value="${userContactDtl.workPhoneNo}">
    
  </div>
</div>

<div class="control-group">
  <label class="control-label">University Webmail</label>
  <div class="controls">
    <input id="universityWebmailId" name="universityWebmailId" type="text" placeholder="jpatel_12@student.imnu.ac.in" class="input-xlarge" value="${userContactDtl.universityWebmailId}">
  </div>
</div>

<div class="control-group">
  <label class="control-label">Email ID</label>
  <div class="controls">
    <input id="personalEmailId" name="personalEmailId" type="text" placeholder="e.g. john.kotler@gmail.com" class="input-xlarge" value="${userContactDtl.personalEmailId}">
  </div>
</div>

<div class="control-group">
  <label class="control-label">Website</label>
  <div class="controls">
      <input id="website" name="website" type="text" placeholder="e.g. www.campuslive.com" class="input-xlarge" value="${userContactDtl.website}">
  </div>
</div>

<div class="control-group">
  <label class="control-label">Blog</label>
  <div class="controls">
    <input id="blog" name="blog" type="text" placeholder="e.g. www.campuslive.blogspot.com" class="input-xlarge" value="${userContactDtl.blog}">
  </div>
</div>
<!-- Textarea -->
<div class="control-group">
  <label class="control-label">Current Address</label>
  <div class="controls">                     
      <textarea id="currentAddress" name="currentAddress" placeholder="Where Do You Live ?">${userContactDtl.currentAddress}</textarea>
  </div>
</div>

<div class="control-group">
  <label class="control-label">Permanent Address</label>
  <div class="controls">                     
      <textarea id="permanentAddress" name="permanentAddress" placeholder="Pemanenet Address">${userContactDtl.permanentAddress}</textarea>
  </div>
</div>

<div class="control-group">
  
  <div class="controls">
    <button class="btn btn-large btn-success" type="submit">Save</button>
    
  </div>
</div>



</fieldset>
</form>

              
          </div>
          
      <hr>

      <footer>
        <p>&copy; Company 2013</p>
      </footer>

    </div><!--/.fluid-container-->

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
