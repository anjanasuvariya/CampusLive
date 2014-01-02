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
            <title>Story Board</title>
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

            
        <tiles:insert definition="project-template-placecomm-header" >
                    <tiles:put name="placecomm-header" value="/WEB-INF/jsp/PlaceComm/placeCommHeader.jsp" />
        </tiles:insert>    
        <!-- Navbar
        ================================================== -->
       


        <!-- Subhead
        ================================================== -->
        <header class="jumbotron subhead" id="overview">
            <div class="container">
                <h1>Storyboard</h1>
                <p class="lead">Tata Consultancy Services Pvt Ltd (When Clicked from Company Screen - retain ID+Name of company) </p>
                <p class="lead">An innovative approach for managing Placecomm (When clicked from Nav Menu>Stories>Home) </p>
            </div>
        </header>


        <div class="container">
        <!-- Docs nav ================================================== -->
        <div class="row">
        
             
            
        <div class="span12">
            <!-- Download ================================================== -->
          
            <section id="block-start">          
    
             <div class="row-fluid">
        <ul class="thumbnails">
            <li class="span3">
                <div class="thumbnail">
                    <img src="resources/img/PlaceComm/calling.jpg" alt="300x200">
                    <br/>
                    <div class="caption">
                        <h3>Calling Status</h3>
                        <p>Can't Keep track of Calling Status? Now it's easy to followup thousands of leads on the go. Explore more inside.</p>
                        <p>
                        <p><button class="ui-button-primary ui-button-warning">Explore</button><button class="ui-button-primary ui-button-info">My Calling</button></p>
                        </p>
                    </div>
                </div>
            </li>
            <li class="span3">
                <div class="thumbnail">
                    <img src="resources/img/PlaceComm/invite.jpg" alt="300x200" height="200px">
                    <div class="caption">
                        <br/>
                        <h3>Interest Invites</h3>
                        
                        <p>Finally, it's time to Invite students to sit for the company. Float an interest invite and share the list with HR.</p>
                        <p><button class="ui-button-primary ui-button-warning">Explore</button><button class="ui-button-primary ui-button-info">My Invites</button></p>
                    </div>
                </div>
            </li>
            <li class="span3">
                <div class="thumbnail">
                    <img src="resources/img/PlaceComm/interview.jpg" alt="300x200" >
                    <div class="caption">
                        <br/>
                        <h3>Interviews</h3>
                        <p>Company is coming to your campus and you need to schedule tons of interviews. It can't be easier than this.</p>
                        <p><button class="ui-button-primary ui-button-warning">Explore</button><button class="ui-button-primary ui-button-info">My Interviews</button></p>
                    </div>
                </div>
            </li>
            <li class="span3">
                <div class="thumbnail">
                    <img src="resources/img/PlaceComm/custom.jpg" alt="300x200" >
                    <div class="caption">
                        <br/>
                        <h3>Custom Stories</h3>
                        <p>Can't find what you are looking for? Create a Custom Task here and also suggest us what you are looking for.</p>
                        <p><button class="ui-button-primary ui-button-warning">Explore</button><button class="ui-button-primary ui-button-info">My Tasks</button></p>
                    </div>
                </div>
            </li>
        </ul>
    </div>

</section>
            
            
        </div>
    </div>
        <hr/>
        <div class="row">
            <div class="bs-docs-sidebar span3">
            <ul class="nav nav-list wrapper bs-docs-sidebar ">
                <li><a href="#block-calling"><i class="icon-chevron-right"></i>Calling & Appointment</a></li>
                <li><a href="#block-invite"><i class="icon-chevron-right"></i>Interest Invite</a></li>
                <li><a href="#block-interview"><i class="icon-chevron-right"></i>Interviews</a></li>
                <li><a href="#block-custom"><i class="icon-chevron-right"></i>Custom Stories</a></li>
                <li><a href="#block-help"><i class="icon-chevron-right"></i>Need Help ?</a></li>
            </ul>
        </div>
            <div class="span9">
                
            <section id="block-calling">
                <div class="page-header">
                    <h1>Calling & Appointment</h1>
                </div>
                <div class="row-fluid">
                    <p class="docs-lead">
                    Calling is an Art! Most of the business dealings and recruitment decisions are taken and conveyed over the call. As a university representative you will not like if this
                    touch point gives a bad impression to your recruiters. Decide on the criterias that you need to pitch to the recruiters before hand and train your placement committee thoroughly with the batch data and ongoing courses at your campus.
                    Following up the calls is the most important task ever. Our App does exactly the same. It manages all the calling status and to-do list easily. Let your team keep calling and we'll support the backend part.
                    
                    </p>
                </div>
                <div class="alert alert-info">
                    <span class="icon-info-sign"></span> We at Placecomm, thrive to speed up and continuously improve the recruitment processes by considering IT as a part of Placecomm strategy.
                </div>
            </section>
            <section id="block-invite">
                <div class="page-header">
                    <h1>Interest Invite</h1>
                </div>
                <div class="row-fluid">
                    <p class="docs-lead">
                    Feeling good after successful calling? Obviously, HR will ask for the profiles of interested students. Want to share this news and invite people to the next stage ? This part of the application is specifically made for handling invites. It can't be easier than this. You're going to make it. We'll be more than happy for that success. 
                    After successful creation of the invite, you'll be able to download the list of interested students from the same screen. Don't forget to set a reasonable deadline for handling tough guys.
                    </p>
                    <p>
                      
            </section>
            <section id="block-interview">
                <div class="page-header">
                    <h1>Interviews</h1>
                </div>
                
                <p class="docs-lead">
                    Finally, Company is visiting the college and you need to inform the students about their probable interview time. You can either schedule interviews with time or without time. This will inform your students about their interview date and venue. Communicate better, the results will automatically show up. Use this particular section of the App, to communicate and set all the interview parameters.
                </p>
                
            </section>
                

                <section id="block-custom">
                <div class="page-header">
                    <h1>Custom Stories</h1>
                </div>
                    <p class="docs-lead">
                    At times, there are some tasks that one can not specify into major categories, such as Visiting Cards printing, brochure design, etc. We have specifically designed this module to handle such all possible scenarios. You can also help us by providing your feedback on how to make it more structured and improvements if any. Or else, keep using when you don't find what you want to.
                </p>
            
            </section>
            
                <section id="block-help">
                <div class="page-header">
                    <h1>Need Help ?</h1>
                </div>
                    <p class="docs-lead">
                    In case you need any help, feel free to contact us on 026-5689416 or query@campuslive.com 
                </p>
                <p class="docs-lead">
                    In case you want to help, feel free to send your suggestions on suggestions@campuslive.com 
                </p>
            
            </section>
            
                
                
            </div>
            
            
        </div>
        
   
</div>

<!-- Footer
================================================== -->
<footer class="footer">
      
        <tiles:insert definition="project-template-placecomm-footer" >
                    <tiles:put name="placecomm-footer" value="/WEB-INF/jsp/PlaceComm/placeCommFooter.jsp" />
        </tiles:insert>    
    
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
