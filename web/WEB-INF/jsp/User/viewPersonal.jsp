<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<html:html locale="true">

  <head>
    <meta charset="utf-8">
    <title>CampusLive-Personal Info</title>
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

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">CampusLive</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Welcome, <a href="#" class="navbar-link">Jyot Patel</a>
            </p>
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">Resume</a></li>
                <li><a href="#contact">GD</a></li>
                <li><a href="#contact">Activity Center</a></li>
                <li><a href="#contact">Announcements</a></li>
                <li><a href="#contact">Placements</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
            
          <div class="well sidebar-nav">
              <center><h2>Personal Info</h2>
            <img class="img-rounded" src="resources/img/Me/personalinfo.png"/>
          
          <p>Check your current details on the right and click Edit if you want to change it.</p>
          <p><a class="btn" href="#">Edit</a></p> </center>
            <ul class="nav nav-list">
              <li class="nav-header">Personal Details Include</li>
              <li class="active"><a href="#">Person Name</a></li>
              <li><a href="#">Image</a></li>
              <li><a href="#">Date of Birth</a></li>
              <li><a href="#">Gender</a></li>
              <li><a href="#">Interests</a></li>
              <li><a href="#">Known Languages</a></li>
              <li><a href="#">Other Known Languages</a></li>
              <li><a href="#">Need More Help ? </a></li>
              <li><a href="#">Have an idea ? Submit Here</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          <div class="well sidebar-nav">
            
              <form class="form-horizontal">
<fieldset>
    
<!-- Form Name -->
<h3 class="text-info offset1">Welcome, Jyot Patel</h3>
<!-- Text input-->
<div class="control-group offset1">
  <label class="control-label"></label>
</div>

<!-- File Button --> 
<div class="control-group offset2">
  <img class="img-rounded" src="resources/img/Me/personalinfo.png"/>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label">Date Of Birth :</label>
  <div class="controls">
  <label class="control-label">10/10/1989</label>
    
  </div>
</div>

<!-- Multiple Radios -->
<div class="control-group">
  <label class="control-label">Gender :</label>
  <div class="controls">
    <label class="control-label">Male</label>
  </div>
</div>

<!-- Prepended text-->
<div class="control-group">
  <label class="control-label">Primary Language :</label>
  <div class="controls">
    <label class="control-label">Gujarati</label>
  </div>
</div>

<!-- Prepended text-->
<div class="control-group">
  <label class="control-label">Secondary Language :</label>
  <div class="controls">
    <label class="control-label">English</label>
    
  </div>
</div>

<!-- Textarea -->
<div class="control-group">
  <label class="control-label">Interests :</label>
  <div class="controls">                     
    <label class="control-label">Interested in Sports, Reading and Hiking</label>
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label">Current City :</label>
  <div class="controls">
    <label class="control-label">Ahmedabad</label>
    
  </div>
</div>

<div class="control-group">
  
  <div class="controls">
    <button class="btn btn-large" type="submit">Edit</button>
    
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
    <script src="http://twitter.github.io/bootstrap/assets/js/jquery.js"></script>
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
</html:html>
