
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Role Management</title>
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
      <script src="resources/js/html5shiv.js"></script>
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
              <center><h2>Role Management</h2>
            <img class="img-rounded" src="resources/img/Me/personalinfo.png"/>
          
          <p>This will help you define the different roles which allows access to different screens. Now, you decide who access what features.</p>
          <p><a class="btn" href="#">Edit</a></p> </center>
            <ul class="nav nav-list">
              <li class="nav-header">Role Details Include</li>
              <li><a href="#">Role Title</a></li>
              <li><a href="#">Role Description</a></li>
              <li><a href="#">Activation Status</a></li>
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
<br/>
<!-- Text input-->
<div class="control-group">
  <label class="control-label">Role Title</label>
  <div class="controls">
    <input id="roleTitle" name="studName" type="text" placeholder="Give it some name" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label">Role Description</label>
  <div class="controls">
    <input id="roleDesc" name="desc" type="text" placeholder="Describe the role here" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Multiple Radios -->
<div class="control-group">
  <label class="control-label">Activation Status</label>
  <div class="controls">
    <label class="radio" required="">
      <input type="radio" name="gender" value="Active" checked="checked">
      Active
    </label>
    <label class="radio">
      <input type="radio" name="gender" value="Deactive">
      Deactive
    </label>
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
    <script src="resources/js/bootstrap-dropdown.js"></script>
    <script src="resources/js/bootstrap-scrollspy.js"></script>
    <script src="resources/js/bootstrap-tab.js"></script>
    <script src="resources/js/bootstrap-tooltip.js"></script>
    <script src="resources/js/bootstrap-popover.js"></script>
    <script src="resources/js/bootstrap-button.js"></script>
    <script src="resources/js/bootstrap-collapse.js"></script>
    <script src="resources/js/bootstrap-carousel.js"></script>
    <script src="resources/js/bootstrap-typeahead.js"></script>

  </body>
</html>
