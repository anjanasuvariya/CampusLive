<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>

        
        <head>
            <meta charset="utf-8">
            <title>Welcome, Username :::</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="description" content="A preview of the jQuery UI Bootstrap theme.">
            <meta name="author" content="Addy Osmani">

            <!-- Le styles -->
	    <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
	    <link rel="stylesheet" href="resources/css/custom-theme/jquery-ui-1.10.3.custom.css">
            <link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">
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

        <body data-spy="scroll" data-target=".bs-docs-sidebar" data-twttr-rendered="true">

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
                    <a class="brand" href="http://github.com/addyosmani/jquery-ui-bootstrap">CampusLive</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="active">
                                <a href="./index.html">Home</a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Recruiters <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                               <li><html:link page="/viewCompanyDtls.do" tabindex="-1">Manage Recruiters</html:link></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Learn about Recruiters</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    HR Leads <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    
                                    <li><html:link page="/viewHrDtls.do" tabindex="-1">Manage Recruiters</html:link></li>
                                    <li><html:link page="/viewHrDtls.do" tabindex="-1">View/Edit HRs</html:link></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Alumni Leads <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><html:link page="/viewAlumniDtls.do" tabindex="-1">Add New Alumnis </html:link></li>
                                    <li><html:link page="/viewAlumniDtls.do" tabindex="-1">View/Edit Alumnis</html:link></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Stories <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><html:link page="/loadStoryBoardHomePage.do" tabindex="-1">Home</html:link></li>
                                    <li><html:link page="/callingAndAppointment.do" tabindex="-1">Calling & Appointment</html:link></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Custom Stories</a></li>
                                    <li><html:link page="/viewInterestInvitesDtl.do" tabindex="-1">Interest Invites</html:link></li>
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
                            <a href="https://twitter.com/share" class="twitter-share-button" data-url="http://addyosmani.github.com/jquery-ui-bootstrap/" data-text="A new jQuery UI Bootstrap theme" data-via="addyosmani" data-size="large">Tweet</a>
                            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
                        </div>
                                    <div><html:link page="/logOut.do">logout</html:link></div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Subhead
        ================================================== -->
        <header class="jumbotron subhead" id="overview">
            <div class="container">
                <h1>Placecomm</h1>
                <p class="lead">Knights Of Change</p>
            </div>
        </header>


        <div class="container">
        <!-- Docs nav ================================================== -->
        <div class="row">
        <div class="span3 bs-docs-sidebar">
            <ul class="nav nav-list bs-docs-sidenav">
                <li><a href="#block-why"><i class="icon-chevron-right"></i> Why Placecomm ?</a></li>
                <li><a href="#block-download"><i class="icon-chevron-right"></i> Installation</a></li>
                <li><a href="#block-documentation"><i class="icon-chevron-right"></i>Getting Started</a></li>
                <li><a href="#block-installation"><i class="icon-chevron-right"></i> Data Storage & Security</a></li>
                <li><a href="#block-start"><i class="icon-chevron-right"></i> Start Working</a></li>
            </ul>
        </div>
        <div class="span9">
            <!-- Download ================================================== -->
            <section id="block-why">
                <div class="page-header">
                    <h1>Why Placecomm?</h1>
                </div>
                <div class="row-fluid">
                    <p class="docs-lead">
                        Welcome! Placement Committee is the most sought after committee at every Campus. Selected after rigorous rounds of selection process, the placement committee acts as an
interface between the students and corporates, and strives for better placement on a continuous basis. The committee comprises a mix of students from first
year and second year and is headed by a placement chairperson who is appointed by the Director from among the faculty members.</p>
                    <p class="docs-lead">
The activities performed include student and corporate database management, conducting pre-placement visits across India, facilitating pre-placement talks, and
coordinating the selection procedure for Final and Summer Placements. Inputs from the Faculty Placement Advisory Committee (PAC) members provide
guidance to the Placement Committee in making strategic decisions.
                    </p>
                </div>
                <div class="alert alert-info">
                    <span class="icon-info-sign"></span> We at Placecomm, thrive to speed up and continuously improve the recruitment processes by considering IT as a part of Placecomm strategy.
                </div>
            </section>
            <section id="block-download">
                <div class="page-header">
                    <h1>Download Updates</h1>
                </div>
                <div class="row-fluid">
                    <p class="docs-lead">
                    To download the Latest Application please use below links. For trainings & help on how to use Placecomm App to align it to your placement strategy, please contact our assistant. We would be happy to help you...!!
                    </p>
                    <p>
                        <a class="download-btn ui-button-primary" href="https://github.com/addyosmani/jquery-ui-bootstrap/zipball/v0.5pre">Download stable (v0.5)</a>
                        <a class="download-btn" href="https://github.com/addyosmani/jquery-ui-bootstrap/zipball/master" >Download Latest (dev)</a>
                    </p>
                </div>
                <div class="alert alert-info">
                    <span class="icon-info-sign"></span> We believe in Kaizen - the continuous improvements, which our Developer version contains. You may use Stable version to avoid any risk. If you find a bug, please bring it to our notice.
                </div>
            </section>
            <section id="block-documentation">
                <div class="page-header">
                    <h1>Starting with Placecomm</h1>
                </div>
                <h2>Core Activities</h2>

                <p>
                    Core Activities of Placecomm at campus includes Summer Internship, Final Placements at Institute & Building/Maintaining corporate relations by managing Databases of leads.
                </p>
                <p>
                    Our solution offers a custom version of Placecomm App, that allows you to manage your all Data, Team and Activities at a finger tip. This would increase your control over the placecomm members and manage the operational activities 100 times better than earlier. It assures you of 100% Data storage and back-up plus it provides a means to communicate effectively in a team of 20-30 people. Finally, this all would result into an integrated focus approach towards the objectives the committee wants to achieve.
                </p>
                <h3>Users</h3>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>User</th>
                        <th>Purpose</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Manager - Placecomm</td>
                        <td>To co-ordinate the placement activities and manage a team of students carrying out the placement activities.</td>
                    </tr>
                    <tr>
                        <td>Admin</td>
                        <td>For managing the databases of student/alumni/HR data.</td>
                    </tr>
                    <tr>
                        <td>Students</td>
                        <td>To participate in to various placement drives plus manage their own data</td>
                    </tr>
                    <tr>
                        <td>Placecommer</td>
                        <td>To work with the Placement data to create plans and bring placements to the campus.</td>
                    </tr>
                    <tr>
                        <td>HR</td>
                        <td>To select best students from the institutes by reviewing their profiles directly available online.</td>
                    </tr>
                    </tbody>
                </table>
                <p>
                        Once the users are identified, we look forward to the management of the Placement Processes. Below are the key processes identified by industry experts and our market research team. Also we have shown the involvement of the users defined above in the process.
                </p>
                <h3>Placement Process </h3>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>Activity</th>
                        <th>Manager</th>
                        <th>Placecommer</th>
                        <th>Students</th>
                        <th>HR</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Student Data Collection</td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                    </tr>
                    <tr>
                        <td>Brochure Design & Printing</td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                    </tr>
                    <tr>
                        <td>Generating HR/Alumni Leads</td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                    </tr>
                    <tr>
                        <td>Calling & Appointments</td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                    </tr>
                    <tr>
                        <td>Floating an Interest Invite</td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                    </tr>
                    <tr>
                        <td>Shortlist Best Profiles</td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                    </tr>
                    <tr>
                        <td>Interview & Final Selection</td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                        <td><div class="label label-important"><span class="icon-remove"></span></div></td>
                        <td><div class="label label-success"><span class="icon-ok"></span></div></td>
                    </tr>
                    </tbody>
                </table>
                <div class="alert alert-info">
                    <span class="icon-lightbulb icon-large"></span>  Incase we have missed anything, please help us improve this step further. We love your feedback...!!
                </div>
                <p>
                    Taking control of placements and to work having a result-oriented approach is what pays-off. Our App not only makes things easier for you, but also securely manages the data of your Placement Process. So it's time now to forget the excel sheets and other modes of data-storage which are difficult to manage and share at one go. Some of the database features we look forward to are shown below.
                </p>
                
            </section>
            <section id="block-installation">
                <div class="page-header">
                    <h1>Data Storage & Security</h1>
                </div>
                <ol>
                    <li>Company Database</li>
                    <li>Alumni Database</li>
                    <li>HR Database</li>
                    <li>Appropriate Database linkage between the above three databases</li>
                    <li>Student Profiles Database Maintenance</li>
                    <li>Store Up to 5 GB of Data</li>
                    <li>Daily Data Back-up</li>
                </ol>

            </section>
            
            
<section id="block-start">          
    
          <div class="page-header">
                    <h1>Let's start working...</h1>
          </div>
             <div class="row-fluid">
        <ul class="thumbnails">
            <li class="span4">
                <div class="thumbnail">
                    <img src="resources/img/PlaceComm/company.jpg" alt="300x200">
                    <div class="caption">
                        <h3>Companies</h3>
                        <p>Our Database services help you work with data of thousands of organizations at a click. Also, it allows one to search flexibly and sort whenever necessary.</p>
                        <p>
                        <p><button class="ui-button-primary ui-button-warning">Explore</button><button class="ui-button-primary ui-button-info">Documentation</button></p>
                        </p>
                    </div>
                </div>
            </li>
            <li class="span4">
                <div class="thumbnail">
                    <img src="resources/img/PlaceComm/hr.jpg" alt="300x200">
                    <div class="caption">
                        <br/>
                        <h3>HRs & Alumnis</h3>
                        
                        <p>Market Research says HR and Alumnis are the greatest stimulators for the placements. Keep in continous touch with them. </p>
                        <p><button class="ui-button-primary ui-button-warning">View All</button><button class="ui-button-primary ui-button-info">Add New</button></p>
                    </div>
                </div>
            </li>
            <li class="span4">
                <div class="thumbnail">
                    <img src="resources/img/PlaceComm/story.jpg" alt="300x200" >
                    <div class="caption">
                        <br/>
                        <h3>Storyboard</h3>
                        <p>Want to look after what all is going on into the Placecomm ? Use this storyboard for managing daily operational activities.</p>
                        <p><button class="ui-button-primary ui-button-warning">View All</button><button class="ui-button-primary ui-button-info">Add New</button></p>
                    </div>
                </div>
            </li>
        </ul>
    </div>

</section>
            
            
            
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
</body>
</html>
