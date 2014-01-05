<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Account Details - Jyot Patel</title>
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
              <center><h2>Account Details</h2>
            <img class="img-rounded" src="resources/img/User/settings.png"/>
          <br/><br/>
          <p>Change your Account Details</p>
          _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 
                           <br/><br/></center>
            <ul class="nav nav-list">
              <li class="nav-header">Account Details Include</li>
              <li><a href="#">Username</a></li>
              <li><a href="#">Old Password</a></li>
              <li><a href="#">New Password</a></li>
              <li><a href="#">University Name</a></li>
              <li><a href="#">Batch Year</a></li>
              <li><a href="#">Program Id</a></li>
              <li><a href="#">Section Id</a></li>
              <li><a href="#">Secret Question</a></li>
              <li><a href="#">Secret Answer </a></li>
              
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          <div class="well sidebar-nav">
            
              <form class="form-horizontal">
<fieldset>

<!-- Form Name -->

<!-- Text input-->
<h3 class="text-success span11 offset1">Username, Password & University Details</h3>
<!-- Form Name -->


<!-- Text input-->
<div class="control-group">
  <label class="control-label">Username</label>
  <div class="controls">
    <input id="userName" name="userName" type="text" placeholder="Enter your username here" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Password input-->
<div class="control-group">
  <label class="control-label">Password</label>
  <div class="controls">
    <input id="userPassword" name="userPassword" type="password" placeholder="Secret Password" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Password input-->
<div class="control-group">
  <label class="control-label">New Password</label>
  <div class="controls">
    <input id="changedPassword" name="changedPassword" type="password" placeholder="Enter only if you want to change it" class="input-xlarge">
    
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label">University</label>
  <div class="controls">
    <select id="userUniversity" name="userUniversity" class="input-xlarge">
      <option>Nirma University - NIT</option>
      <option>Nirma University - IMNU</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label">Batch</label>
  <div class="controls">
    <select id="userBatch" name="userBatch" class="input-xlarge">
      <option>2011-13</option>
      <option>2012-14</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label">Program</label>
  <div class="controls">
    <select id="userProgram" name="userProgram" class="input-xlarge">
      <option>Full-Time</option>
      <option>Part-Time</option>
      <option>Family-Business</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label">Section</label>
  <div class="controls">
    <select id="userSection" name="userSection" class="input-xlarge">
      <option>Sec A</option>
      <option>Sec B</option>
      <option>Sec C</option>
    </select>
  </div>
</div>


<div class="control-group">
  <label class="control-label">Secret Question</label>
  <div class="controls">
    <select id="userSecretQ" name="userSecretQ" class="input-xlarge">
      <option>Who is your best friend?</option>
          <option>Which is your first school?</option>
          <option>Who was your first girlfriend?</option>
          <option>Whom you kissed first?</option>
          <option>With whom you had sex for the first time?</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label">Secret Answer</label>
  <div class="controls">
    <input id="secretAnswer" name="secretAnswer" type="text" placeholder="Remember this answer.." class="input-xlarge">
    
  </div>
</div>

<div class="control-group">
  <label class="control-label">Role</label>
  <div class="controls">
    <select id="userRole" name="userRole" class="input-xlarge">
      <option>Student</option>
      <option>Placecomm Member</option>
    </select>
  </div>
</div>
<!-- Button -->
<div class="control-group">
  <label class="control-label"></label>
  <div class="controls">
    <button id="accountSubmit" name="accountSubmit" class="btn btn-success">Save</button>
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