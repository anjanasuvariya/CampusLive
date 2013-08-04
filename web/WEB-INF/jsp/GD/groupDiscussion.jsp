<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
<head>
    
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta charset="utf-8">

    <title>Utopia, from Themio</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A complete admin panel theme">
    <meta name="author" content="theemio">

    <!-- styles -->
    <link href="resources/css/utopia-white.css" rel="stylesheet">
    <link href="resources/css/utopia-responsive.css" rel="stylesheet">
    <link href="resources/css/ie.css" rel="stylesheet">
    <link rel="stylesheet" href="resources/css/bs/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/bs/prettify.css">
    <link rel="stylesheet" href="resources/css/bs/bootstrap-wysihtml5.css">
    <link rel="stylesheet" href="resources/css/vote/vote.css">

    
    
    <script type="text/javascript" src="resources/js/jquery.js"></script>
    <script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
    
    <style type="text/css" media="screen">
	.btn.jumbo {
                font-family: Segoe UI Light;
		font-size: 20px;
		font-weight: normal;
		padding: 15px 15px;
		margin-right: 10px;
		-webkit-border-radius: 6px;
		-moz-border-radius: 6px;
		border-radius: 6px;
	}
    </style>

    <script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-30181385-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

    </script>

    <!--[if IE 8]>
    <link href="resources/css/ie8.css" rel="stylesheet">
    <![endif]-->

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body>

<div class="container-fluid">

<!-- Header starts -->
<div class="row-fluid">
    <div class="span12">

        <div class="header-top">

            <div class="header-wrapper">

                <a href="#" class="utopia-logo"><img src="resources/img/GD/gd_logo.jpg" alt="Utopia"></a>

                <div class="header-right">

                    <div class="header-divider">&nbsp;</div>

                    <div class="search-panel header-divider">
                        <div class="search-box">
                            <img src="resources/img/GD/icons/zoom.png" alt="Search">
                            <form action="" method="post">
                                <input type="text" name="search" placeholder="search"/>
                            </form>
                        </div>
                    </div>


                    <div class="notification header-divider">

                        <div class="notification-wrapper">

                            <a href="#" class="notification-counter">8</a>
                            <div id="triangle-down"></div>

                            <div class="tabbable notification-box">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a data-toggle="tab" href="#message">Messages (3)</a></li>
                                    <li class=""><a data-toggle="tab" href="#activity">Activity (5)</a></li>
                                </ul>

                                <div class="tab-content">
                                    <div id="message" class="tab-pane active">
                                        <ul class="message-list">
                                            <li class="message new">
                                                <div class="msg">
                                                    From: <a href="">Benjamiin Buttons</a> <span>40m ago</span>
                                                    <a class="subject" href="">Getting Started on Starlight Template</a>
                                                    <p>Vitae dicta sunt explicabo. Nemo enim</p>
                                                </div>
                                            </li>
                                            <li class="message new">
                                                <div class="msg">
                                                    From: <a href="">ThemePixels Team</a> <span>2 hours ago</span>
                                                    <a class="subject" href="">Thank you for using StarLight Template</a>
                                                    <p>Hi,Eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                                </div>
                                            </li>
                                            <li class="message">
                                                <div class="msg">
                                                    From: <a href="">Katherine Kate</a> <span>40m ago</span>
                                                    <p>Lorem ipsum dolor sit amet...</p>
                                                </div>
                                            </li>
                                            <li class="message">
                                                <div class="msg">
                                                    From: <a href="">ThemePixels Team</a> <span>Yesterday</span>
                                                    <a class="subject" href="">Events for the next month</a>
                                                    <p>Hi,Eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                                </div>
                                            </li>
                                        </ul>

                                        <div class="message-more"><a href="">See All Messages</a></div>

                                    </div>

                                    <div id="activity" class="tab-pane">
                                        <ul class="message-list">
                                            <li class="user new">
                                                <div class="msg">
                                                    <a href="">Justin Meller</a> added <a href="">John Doe</a> as Admin.
                                                </div>
                                            </li>
                                            <li class="call new">
                                                <div class="msg">
                                                    You missed a call from <a href="">Porfirio</a>
                                                </div>
                                            </li>
                                            <li class="calendar new">
                                                <div class="msg">
                                                    <a href="">Katherine Kate</a> invited you in an event <a href="">Rock Party</a>.
                                                </div>
                                            </li>
                                            <li class="settings">
                                                <div class="msg">
                                                    <a href="">Jane Doe</a> updated her profile.
                                                </div>
                                            </li>
                                            <li class="follow">
                                                <div class="msg">
                                                    <a href="">Jet Lee</a> is now following you.
                                                </div>
                                            </li>
                                        </ul>

                                        <div class="message-more"><a href="">View All Activities</a></div>

                                    </div>
                                </div>
                            </div>

                        </div>

                    </div><!-- Notification end -->


                    <div class="user-panel header-divider">
                        <div class="user-info">
                            <img src="resources/img/GD/icons/user.png" alt="">
                            <a href="#">Admin user</a>
                        </div>

                        <div class="user-dropbox">
                            <ul>
                                <li class="user"><a href="">Profile</a></li>
                                <li class="settings"><a href="">Account Settings</a></li>
                                <li class="theme-changer dark-theme"><a href="javascript:void(0)" class="dark" rel="css/themes/utopia-dark.css" >Dark theme</a></li>
                                <li class="theme-changer white-theme"><a href="javascript:void(0)" class="white" rel="css/utopia-white.css" >White theme</a></li>
                                <li class="theme-changer wooden-theme"><a href="javascript:void(0)" class="wooden" rel="css/themes/utopia-wooden.css" >Wooden theme</a></li>
                                <li class="logout"><a href="index.html">Logout</a></li>
                            </ul>
                        </div>

                    </div><!-- User panel end -->

                </div><!-- End header right -->

            </div><!-- End header wrapper -->

        </div><!-- End header -->

    </div>

</div>

<!-- Header ends -->


<div class="row-fluid">

<!-- Sidebar statrt -->
<div class="span2 sidebar-container">

    <div class="sidebar">

        <div class="navbar sidebar-toggle">
            <div class="container">

                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>

            </div>
        </div>

        <div class="nav-collapse collapse leftmenu">

                    <ul>
                        <li class="current"><a class="dashboard smronju" href="resources/css/Utopia, from Themio.htm" title="Dashboard"><span><em>Home</em></span></a></li>
                        <li><a class="list" href="javascript:void(0)" title="Tables"><span><em>Profile Update</em></span></a>
                            <ul class="dropdown" style="left: 222px;">
                                <li><a class="tables" href="http://utopiaadmin.themio.net/tables.html" title="Tables"><span><em>Discussions</em></span></a>
                                </li><li><a class="widgets smronju" href="http://utopiaadmin.themio.net/pricingtables.html" title="Pricing Tables"><span><em>Resume</em></span></a></li>
                            </ul>
                        </li>
                        <li><a class="tables" href="http://utopiaadmin.themio.net/typography.html" title="Typography"><span><em>Activity Center</em></span></a></li>
                        <li><a class="elements" href="http://utopiaadmin.themio.net/maps.html" title="Maps"><span><em>Events</em></span></a></li>
                        <li><a class="charts" href="http://utopiaadmin.themio.net/charts.html" title="Graphs &amp; Charts"><span><em>Announcements</em></span></a></li>
                        <li><a class="barcode" href="http://utopiaadmin.themio.net/barcode.html" title="Barcode"><span><em>Placements</em></span></a></li>
                        <li><a class="editor" href="javascript:void(0)" title="Forms"><span><em>Enterpreneurship</em></span></a>
                            <ul class="dropdown" style="left: 222px;">
                                <li><a class="simple smronju" href="http://utopiaadmin.themio.net/forms.html" title="Form Elements"><span><em>Born Global</em></span></a></li>
                                <li><a class="wizard-form smronju" href="http://utopiaadmin.themio.net/wizard_form.html" title="Wizard Form"><span><em>Traditional</em></span></a></li>
                            </ul>
                        </li>
                        <li><a class="gallery" href="javascript:void(0)" title="Galleries"><span><em>Photos</em></span></a>
                            <ul class="dropdown" style="left: 222px;">
                                <li><a class="fluidgallery" href="http://utopiaadmin.themio.net/fluid_galle-ries.html" title="Fluid Gallery"><span><em>Classroom</em></span></a></li>
                                <li><a class="slidergallery" href="http://utopiaadmin.themio.net/mixed_galleries.html" title="Mixed Gallery"><span><em>College</em></span></a></li>
                                <li><a class="videogallery" href="http://utopiaadmin.themio.net/video_galleries.html" title="Video Gallery"><span><em>All</em></span></a></li>
                            </ul>
                        </li>
                        <li><a class="grid" href="http://utopiaadmin.themio.net/grid.html" title="Grid"><span><em></em></span></a></li>
                        <li><a class="calendar" href="http://utopiaadmin.themio.net/calendar.html" title="Calendar"><span><em>Ask Questions</em></span></a></li>
                        <li><a class="icons" href="http://utopiaadmin.themio.net/icons.html" title="Icons"><span><em>Interviews</em></span></a></li>
                        <li><a class="chat" href="http://utopiaadmin.themio.net/conversation.html" title="Conversation"><span><em>Subjects</em></span></a></li>
                        <li><a class="error" href="http://utopiaadmin.themio.net/error.html" title="Error Page"><span><em>Important Links</em></span></a></li>
                    </ul>

                </div>

    </div>
</div>

<!-- Sidebar end -->

<!-- Body start -->
<div class="span10 body-container">

<div class="row-fluid">
    <div class="span12">
        <ul class="breadcrumb">
            <li>
                <html:link page="/login.do" >Home</html:link> <span class="divider">/</span>
            </li>
            <li>
                <html:link page="/GroupDiscussion.do" >Discussions</html:link> <span class="divider">/</span>
            </li>
            <li>
                <a href="#"><bean:write name="GDActionForm" property="chatPad.chatPadName" ></bean:write></a><span class="divider">/</span>
            </li>
        </ul>
    </div>
</div>





<div class="row-fluid">
    <div class="span12">
        <section class="utopia-widget">
            <div class="utopia-widget-title">
                <img src="resources/img/GD/icons/chat-exclamation.png" class="utopia-widget-icon">
                <span><bean:write name="GDActionForm" property="chatPad.chatPadName" ></bean:write>
                    </span>
            </div>
            
            <div class="utopia-widget-content">
                <logic:iterate id="chatId" name="GDActionForm" property="chatMsgList">
                
                    <div class="utopia-chat-simple" style="font-family: Segoe UI Light">
                        <img style="height:38px;width:38px" title="Display User Name Here" src="resources/img/user/<bean:write filter="false" name="chatId" property="chatUserId" />.jpg" alt="user1"/>    
                    <span class="date">
                        
                        <bean:write filter="false" name="chatId" property="chatMsgTime" format='hh:mma | dd MMM, yyyy' />
                        
                    </span>
                        <div class="container-fluid">
                    <div class="msg multiline span10">
                        <bean:write filter="false" name="chatId" property="chatMsgValue" />
                        
                    </div>
                    <div class="msg multiline span2"><br/>
                        <div class="votecard pull-right">
                <div><em><strong class="strong">
                            <bean:write filter="false" name="chatId" property="chatPositionId" />
                        </strong><span>Votes</span></em></div>
                </div>
                            <c:if test="${ chatId.chatVisible eq 0 }" >
                            <html:link styleClass="voteaction" href="#"  >
                                <input type="hidden" name="chatId" class="hidMsgId" value="<bean:write filter="false" name="chatId" property="chatMsgId" />">
                                <input type="hidden" name="chatId" class="hidPosId" value="<bean:write filter="false" name="chatId" property="chatPositionId" />">
                                <input type="hidden" name="chatId" class="hidPadId" value="<bean:write filter="false" name="chatId" property="chatPadId" />">
                                <input type="hidden" name="chatId" class="hidUserId" value="<bean:write filter="false" name="chatId" property="chatUserId" />">
                            </html:link>
                            </c:if>    

                                
                    </div>
                        </div>    
                        
                    
                </div>
                
                </logic:iterate>

                
            
                

            </div>
                    
        </section>
        <section id="texEditor" class="utopia-widget section">
    <div class="utopia-widget-title">
        <img src="resources/img/icons2/pen.png" class="utopia-widget-icon">
        <span>Post Your Comments Here</span>
    </div>

    <div class="row-fluid">
        <div class="utopia-widget-content-nopadding">
            <div class="span12 text-editor">
                <html:form action="/LoadDiscussion.do?method=GDPostMessageAction" method="POST" styleId="msgPost">
                <textarea name="textarea" class="textarea" placeholder="Enter text ..." style="width: 810px; height: 60px"></textarea>
                <a class="btn jumbo"
                <a class="btn jumbo"  onclick="$('form#msgPost').submit();">
                    <i class="icon-comment"></i>&nbsp; Comment
                </a>
                
                </html:form>    
            </div>
        </div>
    </div>
</section>


    </div>
</div>



</div>

</div><!-- Body end -->

</div><!-- Maincontent end -->

 <!-- end of container -->
<!-- javascript placed at the end of the document so the pages load faster -->
<!-- <script type="text/javascript" src="resources/js/jquery.js"></script>-->

<script type="text/javascript" src="script/vote/vote.js"></script>
<script type="text/javascript" src="resources/js/utopia.js"></script>
<script type="text/javascript" src="resources/js/jquery.hoverIntent.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="resources/js/jquery.vticker-min.js"></script>
<script type="text/javascript" src="resources/js/header.js?v1"></script>
<script type="text/javascript" src="resources/js/sidebar.js"></script>
<script type="text/javascript" src="resources/js/bs/wysihtml5-0.3.0.js"></script>
<script type="text/javascript" src="resources/js/bs/prettify.js"></script>
<script type="text/javascript" src="resources/js/bs/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/bs/bootstrap-wysihtml5.js"></script>


<script type="text/javascript">
function submitForm()
{
document.forms[0].action = "LoadDiscussion.do?method=GDPostMessage"
document.forms[0].submit();
}
</script>

<script>
	$('.textarea').wysihtml5();
</script>

<script type="text/javascript" charset="utf-8">
	$(prettyPrint);
</script>

</body>
</html:html>
