<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
function setFrameSrc(tab)
{
    var contextPath = "${pageContext.request.contextPath}";
    if(tab == "tab1")
    {
        document.getElementById("frmWorkExp").src = contextPath+"/viewUserOrganizations.do"
    }
    else if(tab == "tab2")
    {
        document.getElementById("frmWorkExp").src = contextPath+"/viewUserProjects.do"
    }
    else if(tab == "tab3")
    {
        document.getElementById("frmWorkExp").src = contextPath+"/viewUserRecommendations.do"
    }
}
</script>

<c:set var="contextPath" value ="${pageContext.request.contextPath}"/>

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
              <center><h2>Work Experience</h2>
            <img class="img-rounded" src="resources/img/User/workex.png"/>
          
          <p>Add your Work Experience including Organization and the projects you have worked upon. Don't forget to include the role you performed in a team</p>
          <p><a class="btn" href="#">Edit</a></p> </center>
            <ul class="nav nav-list">
              <li class="nav-header">WorkEx Includes</li>
              <li><a href="#">Organization Name</a></li>
              <li><a href="#">City</a></li>
              <li><a href="#">Joining Date</a></li>
              <li><a href="#">Ending Date</a></li>
              <li><a href="#">Team Members</a></li>
              <li><a href="#">Description</a></li>
              <li><a href="#" style="color: lightcoral">Need More Help ? Click Here</a></li>
              <li><a href="#" style="color: crimson">Have an idea ? Submit Here</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          <div class="well sidebar-nav">
             
<h4 class="offset1" style="color: #999">Good judgment comes from experience, and experience comes from bad judgment.</h4>  
              
<ul class="nav nav-tabs offset1 span9">
                
  <li onclick="setFrameSrc('tab1')"><a href="#" data-toggle="tab">Organization</a></li>
  <li onclick="setFrameSrc('tab2')"><a href="#" data-toggle="tab" class="offset2">Projects</a></li>
  <li onclick="setFrameSrc('tab3')"><a href="#" data-toggle="tab" class="offset2">Recommendations</a></li>
  <iframe id="frmWorkExp" height="700" width="760" border="no" src="${contextPath}/viewUserOrganizations.do">
               
</ul>
<table width="100%" id="mytable">
    <tbody class="clonedInput">
             
    <tr>
                <td>

                    <div class="control-group" >
                        <br/>
                    </div>
                    <hr>

      <footer>
          <p class="offset2">CampusLive Initiative by <a href="#">Jyot Patel</a> & <a href="#">Bhushan Zalavadia</a></p>
      </footer>
                </td><td></td>
</tr>
    </tbody>
</table>          
             
  </body>
  
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

</html>
