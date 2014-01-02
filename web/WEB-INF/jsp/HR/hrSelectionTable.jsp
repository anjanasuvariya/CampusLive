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
            <title>Alumni Leads</title>
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
        


<header style="background-image: linear-gradient(45deg,  #B24926 0%,#FAA523 100%);" >
    <br/>
    <div class="row-fluid">
        <div class="span6">
    <div class="container offset1 large" style="color:white" >
                <h1>Initial Screening</h1>
                <h3>TCS Interest Invite</h3>
                <p class="lead">Pick the best profiles fit for your Company</p>
      
            </div>
        </div>

<div class="span6">
        <div class="span11 well">
  	<legend>Too Many Profiles ? Use Filter 
            <html:link page="/hrSelectionScreen.do" tabindex="-1" styleClass="label label-important pull-right" style="color:white"><i class="icon-list-ul icon-
white"></i>&nbsp;Profile View </html:link>
         <html:link page="/hrCurrentSelection.do" tabindex="-1" styleClass="label label-info pull-right" style="color:white"><i class="icon-list-ul icon-circle
"></i> &nbsp;Selection Summary </html:link> &nbsp;
        </legend>
    <form  accept-charset="UTF-8" action="" method="post">
        <div class="row-fluid">    
        <input class="span3" name="name" placeholder="Name" type="text">
        <input class="span3" name="major" placeholder="Major Specialization" type="text">
        <input class="span3" name="minor" placeholder="Minor Specialization" type="text">
        <input class="span3" name="gender" placeholder="Gender" type="text">
        </div>
        <div class="row-fluid">
        <input class="span3" name="10th" placeholder="Minimum 10th %" type="text">
        <input class="span3" name="12th" placeholder="Minimum 12th %" type="text">
        <input class="span3" name="area" placeholder="WorkEx Area" type="text">
        <input class="span3" name="workex" placeholder="WorkEx Months" type="text">
        
        
        </div>
        
        <button class="btn btn-inverse" type="submit">Apply Filter</button>
        
    </form>
        </div>
</div></div>    
    
        </header>
        <br/>
           <div class="container">
        <!-- Docs nav ================================================== -->
        <div class="row">
        
        <div class="span12">
        <input type ="hidden" id="hdnAlumniDtlCnt" name="hdnAlumniDtlCnt" />
                 <div class="utopia-widget-content" style="display: block;">

                        <table class="table datatable table-striped table-bordered" id="tblAlumniDtls">


                            <thead>

                                <tr>
                                    <th><input type="checkbox" name="chkAlumniDtlId" id="chkAlumniDtlId${rowCnt.count}" value="${pcAlumniDtl.alumniDtlId}"></th>
                                    <th>Name</th>
                                    <th>Gender</th>
                                    <th>Major</th>
                                    <th>Minor</th>
                                    <th>Batch</th>
                                    <th>10th</th>
                                    <th>12th</th>
                                    <th>Graduation</th>
                                    <th>Graduation Major</th>
                                    <th>WorkEx Area</th>
                                    <th>WorkEx Duration</th>
                                    <th>Link</th>
                                    <th>Link</th>
                                    <th>Link</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${alumniDtlList}" var="pcAlumniDtl" varStatus="rowCnt">
                                <tr id="trAlumniId${rowCnt.count}">
                                    <td> <input type="checkbox" name="chkAlumniDtlId" id="chkAlumniDtlId${rowCnt.count}" value="${pcAlumniDtl.alumniDtlId}"></td>    
                                    <td><a data-toggle="modal" href="#myModal" onclick="populateAlumniData('${rowCnt.count}','${pcAlumniDtl.alumniDtlId}','${pcAlumniDtl.alumniName}','${pcAlumniDtl.facebookLink}','${pcAlumniDtl.twitterLink}','${pcAlumniDtl.linkedinLink}')">${pcAlumniDtl.alumniName}</a></td>
                                    <td>${pcAlumniDtl.alumniCompany}</td>
                                    <td>${pcAlumniDtl.alumniDesignation}</td>
                                    <td class="more">${pcAlumniDtl.alumniBatch}</td>
                                    <td>${pcAlumniDtl.alumniTelephone}</td>
                                    <td>${pcAlumniDtl.alumniMobile}</td>
                                    <td class="more">${pcAlumniDtl.alumniEmail}</td>
                                    <td>${pcAlumniDtl.alumniFax}</td>
                                    <td>${pcAlumniDtl.alumniAddress}</td>
                                    
                                        <td class="more">IT</td>
                                        <td align ="center">
                                            23 Months
                                        </td>
                                        <td><div class="social-box-icon">
                                                <a href="http://www.facebook.com" class="zocial icon facebook" target="_blank">${pcAlumniDtl.facebookLink}</a>
                                            </div>    
                                    </td>
                                        <td><div class="social-box-icon">
                                                <a href="http://www.twitter.com" class="zocial icon twitter" target="_blank">${pcAlumniDtl.twitterLink}</a>
                                            </div>    
                                        </td>
                                        <td><div class="social-box-icon">
                                                <a href="http://www.linkedin.com" class="zocial icon linkedin"  target="_blank">${pcAlumniDtl.linkedinLink}</a>
                                            </div>    
                                        </td>
                                    </tr>
                                    <script>
                                        var count = '${rowCnt.count}';
                                        document.getElementById("hdnAlumniDtlCnt").value=Number(count)+1;
                                     </script>
                                </c:forEach>
                            </tbody>

                        </table>

                        <div class="utopia-table-action">

                                <a href="http://utopiaadmin.themio.net/dashboard.html#" class="btn btn-success"><i class="icon-hand-up"></i> Approve</a>
                                &nbsp;
                                <a href="http://utopiaadmin.themio.net/dashboard.html#" class="btn btn-danger"><i class="icon-hand-down"></i> Reject</a>

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
                    <li>Lead Product Developer : <a class="targetblank" href="http://addyosmani.com/blog/" hreflang="en">Anjana Suvariya</a></li>
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




<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/assets/js/jquery-1.9.0.min.js"></script>
<script src="resources/assets/js/bootstrap.min.js"></script>
<script src="resources/assets/js/holder.js"></script>
<script src="resources/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="resources/assets/js/google-code-prettify/prettify.js"></script>
<script src="resources/assets/js/docs.js"></script>
<script src="resources/assets/js/demo.js"></script>
<script type="text/javascript" src="resources/js1/u/utopia.js"></script>
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
