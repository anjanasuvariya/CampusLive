<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="alumniDtlList" value="${requestScope.alumniDtlList}"/>
<!DOCTYPE html>
<html lang="en">

        <head>
            <meta charset="utf-8">
            <title>Current Selection</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="description" content="A preview of the jQuery UI Bootstrap theme.">
            <meta name="author" content="Addy Osmani">

            <!-- Le styles -->
    <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/custom-theme/jquery-ui-1.10.3.custom.css">
    <link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">
    
    <link href="http://utopiaadmin.themio.net/css/utopia-responsive.css" rel="stylesheet">
    <link href="http://utopiaadmin.themio.net/css/ie.css" rel="stylesheet">
    <link href="http://utopiaadmin.themio.net/css/social_icon/icons.css" rel="stylesheet" type="text/css"/>
    <link href="http://utopiaadmin.themio.net/css/koottam/css/koottam.css" rel="stylesheet"/>

    <script type="text/javascript" src="http://utopiaadmin.themio.net/js/jquery.min.js"></script>
    <script type="text/javascript" src="http://utopiaadmin.themio.net/js/jquery.cookie.js"></script>



            <!--[if IE 7]>
            <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css">
            <![endif]-->
            <!--[if lt IE 9]>
            <link rel="stylesheet" href="css/custom-theme/jquery.ui.1.10.2.ie.css">
            <![endif]-->
            <link rel="stylesheet" href="resources/assets/css/docs.css">
            <link rel="stylesheet" href="resources/assets/js/google-code-prettify/prettify.css">

            <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
            <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
            <![endif]-->

            <!-- Le fav and touch icons -->
            <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/assets/ico/apple-touch-icon-144-precomposed.png">
            <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/assets/ico/apple-touch-icon-114-precomposed.png">
            <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/assets/ico/apple-touch-icon-72-precomposed.png">
            <link rel="apple-touch-icon-precomposed" href="resources/assets/ico/apple-touch-icon-57-precomposed.png">
            <link rel="shortcut icon" href="resources/assets/ico/favicon.png">

        </head>

        <body data-spy="scroll" data-target=".bs-docs-sidebar" data-twttr-rendered="true" style="z-index:1800">

        <!-- Navbar
        ================================================== -->
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="http://github.com/addyosmani/jquery-ui-bootstrap">Placecomm</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li >
                                <a href="./index.html">Home</a>
                            </li>
                            <li class="dropdown active">
                                <a href="/navigation.do" class="dropdown-toggle" data-toggle="dropdown">
                                    Recruiters <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    
                                    <li><html:link page="/NevigationHandler.do" tabindex="-1">Manage Recruiters</html:link></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Learn about Recruiters</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    HR Leads <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><a tabindex="-1" href="./index.html">Manage HRs</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Learn about HRs</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Alumni Leads <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><a tabindex="-1" href="./index.html">Manage Alumni </a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Learn About Alumni </a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Stories <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><a tabindex="-1" href="./index.html">Calling & Appointment</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Custom Stories</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Interest Invites</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Interview Scheduling</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Plan <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><a tabindex="-1" href="./index.html">Resource Utilization</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Performance Indicators</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Placecomms <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><a tabindex="-1" href="./index.html">Jyot Patel</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Arpen Vora</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Syed Shoeb</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Bhushan Zalavadia</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Saurabh Kumar</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Natali Mathew</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Vanditha Ravi</a></li>
                                </ul>
                            </li>
                            
                        </ul>
                        <div id="twitter-share" class="pull-right">
                            <a href="https://twitter.com/share" class="twitter-share-button" data-url="http://addyosmani.github.com/jquery-ui-bootstrap/" data-text="A new jQuery UI 
Bootstrap theme" data-via="addyosmani" data-size="large">Tweet</a>
                            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement
(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Subhead
        ================================================== -->
        <header class="jumbotron subhead" id="overview" style="background-image: linear-gradient(45deg, #404926 0%, rgb(255, 128, 0) 
100%)">
            <div class="container" >
                <h1>Selection Summary</h1>
                <p class="lead">Have a look at the profiles for any final changes</p>
                <a href="hrSelectionScreen.do" class="btn btn-large btn-inverse" style="color: white"><i class="icon-backward"></i> Profile View</a>
                <a href="hrSelectionTable.do" class="btn btn-large btn-inverse" style="color: white"><i class="icon-backward"></i> Table View</a>
            </div>
        </header>


<br/>
                    <div class="container">



                <div class="row-fluid">

                    <div class="span12">

                        <div class="row-fluid">

                            <div class="span10">
                                <div class="row-fluid">

                                    
                                    <div class="span12">
                                        <div class="utopia-widget-content" style="display: block;">

                                                <table class="table datatable table-striped table-bordered" id="gdTable">

                                            
                                                    <thead>
                                                    
                                                    <tr>
                                                        
                                                        <th>Name</th>
                                                        <th>Major</th>
                                                        <th>Email</th>
                                                        <th>Mobile</th>
                                                        <th>Status</th>
                                                        <th>Action</th>
                                                    </tr>
                                                    </thead>

                                                    <tbody>
                                                        <tr>    
                                                    <td>Jyot N Patel</td>
                                                    <td>Finance</td>    
                                                    <td>jyotpatel.imnu@gmail.com</td>
                                                    <td>9429500361</td>
                                                    <td>Selected</td>
                                                    <td><a href="#">Reject</a></td>
                                                    </tr>
                                                    <tr>    
                                                    <td>Hiren H Patadia</td>
                                                    <td>Finance</td>    
                                                    <td>hirenp.imnu@gmail.com</td>
                                                    <td>9427289976</td>
                                                    <td>Rejected</td>
                                                    <td><a href="#">Select</a></td>
                                                    </tr>
                                                    </tbody>
                                                </table>

                                               
                                            </div>
                                    </div>

                                </div>
                                
                                
                            </div><!-- Mid panel -->
                            <div class="span2">
                                    
                                <div class="well" style="width:300px; padding: 8px 0;">
    <div style=" overflow-x: hidden; height: 500px;">
        <ul class="nav nav-list">
            <li><label class="tree-toggler nav-header">Total</label>
                <ul class="nav nav-list tree">
                    <li><a href="#">Selected - 26</a></li>
                    <li><a href="#">Rejected - 40</a></li>
                </ul>
            </li>
        
            <li><label class="tree-toggler nav-header">Gender</label>
                <ul class="nav nav-list tree">
                    <li><a href="#">Boys - 15</a></li>
                    <li><a href="#">Girls - 11</a></li>
                </ul>
            </li>
            <li><label class="tree-toggler nav-header">Work Experience</label>
                <ul class="nav nav-list tree">
                    <li><a href="#">Freshers - 14</a></li>
                    <li><a href="#">Experienced - 12</a></li>
                </ul>
            </li>
            <li><label class="tree-toggler nav-header">Location</label>
                <ul class="nav nav-list tree">
                    <li><a href="#">Rajkot- 12</a></li>
                    <li><a href="#">Delhi- 14</a></li>
                </ul>
            </li>
        </ul>
    </div></div>
                            </div>
                            

                        </div>

                    </div>

                </div>


             
            </div>

<!-- Footer
================================================== -->
<footer class="footer">
    <div class="container">
        <div class="row">
          <div class="span3">
            <h3><span class="icon-envelope"></span> Contact</h3>
            <ul class="icons">
              <li><i class="icon-link"></i> Blog: <a class="targetblank" href="http://addyosmani.com/blog/">Jyot Patel</a></li>
              <li><i class="icon-twitter"></i> Twitter: <a class="targetblank" href="https://twitter.com/addyosmani">@jyotpatel</a></li>
              <li><i class="icon-github"></i> Github: <a class="targetblank" href="https://github.com/addyosmani/jquery-ui-bootstrap/issues?state=open">Issues</a></li>
            </ul>
          </div>
          <div class="span9">
            <div class="span4">
                <h3><span class="icon-group"></span> Team</h3>
                <ul class="unstyled">
                    <li>Lead Product Developer : <a class="targetblank" href="http://addyosmani.com/blog/" hreflang="en">Hiren Patadia</a></li>
                    <li>Chief Product Designer : <a class="targetblank" href="http://blog.aurelien-gerits.be" hreflang="fr">Jyot Patel</a></li>
                </ul>
            </div>
            <div class="span4">
                <h3><span class="icon-lightbulb"></span> Credits</h3>
                <ul class="unstyled">
                    <li>jQuery UI Bootstrap &copy; <strong class="text-info">Addy Osmani</strong> 2012 - 2013.</li>
                    <li>Twitter Bootstrap &copy; <strong class="text-info">Twitter</strong> 2012 - 2013</li>
                    <li>Nirma University &copy; <strong class="text-info">IMNU</strong> 2012 - 2014</li>
                </ul>
            </div>
          </div>
        </div>
    </div>
</footer>

  <script>
    $(document).ready(function () {
        $('label.tree-toggler').click(function () {
            $(this).parent().children('ul.tree').toggle(300);
        });
    });
</script>


<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/assets/js/jquery-1.9.0.min.js"></script>
<script src="resources/assets/js/bootstrap.min.js"></script>
<script src="resources/assets/js/holder.js"></script>
<script src="resources/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="resources/assets/js/google-code-prettify/prettify.js"></script>
<script src="resources/assets/js/docs.js"></script>
<script src="resources/assets/js/demo.js"></script>
<script type="text/javascript" src="resources/js/u/utopia.js"></script>
<script type="text/javascript" src="resources/assets/js/module/placecomm/jquery.easyModal.js"></script>     
<script type="text/javascript" src="resources/assets/js/module/placecomm/jquery.shorten.js"></script>     
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" />
<script type="text/javascript">

$(function() {

    $(".more").shorten({
                
		width: 40,
		tail: ' <a href="#">more</a>',
		tooltip: true
	});

    });

</script>
<script type="text/javascript" src="resources/js/u/jquery.min.js"></script>

<script type="text/javascript" src="resources/js/u/utopia.js"></script>
<script type="text/javascript" src="resources/js/u/jquery.datatable.js"></script>
<script type="text/javascript" src="resources/js/u/tables.js"></script>
<script type="text/javascript" src="resources/css/utopia-white.css"></script>

    <script type="text/javascript" src="http://utopiaadmin.themio.net/js/koottam/js/jquery.koottam.js"></script>
    <script type="text/javascript" src="http://utopiaadmin.themio.net/js/api.js"></script>
    <script type="text/javascript" src="http://utopiaadmin.themio.net/js/header.js?v1"></script>
    <script type="text/javascript" src="http://utopiaadmin.themio.net/js/sidebar.js"></script>
    
    <script type="text/javascript" src="resources/js/noty/jquery.noty.js"></script>
<script type="text/javascript" src="resources/js/noty/layouts/top.js"></script>
<script type="text/javascript" src="resources/js/noty/layouts/topLeft.js"></script>
<script type="text/javascript" src="resources/js/noty/layouts/topRight.js"></script>
<script type="text/javascript" src="resources/js/noty/themes/default.js"></script>
<script type="text/javascript" src="script/PlaceComm/editAlumniDtls.js"></script>


</body>
</html>
