<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style type="text/css">@media print {  .gmnoprint {    display:none  }}@media screen {  .gmnoscreen {    display:none  }}</style>
    <meta charset="utf-8">
    <title>Utopia, from Themio</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A complete admin panel theme">
    <meta name="author" content="theemio">

    <!-- styles -->

    <link href="resources/css/utopia-white.css" rel="stylesheet">
    <link href="resources/css/utopia-responsive.css" rel="stylesheet">
    <link href="resources/css/jquery-ui.css" rel="stylesheet" type="text/css">
    <link href="resources/css/weather.css" rel="stylesheet" type="text/css">
    <link href="resources/css/gallery/modal.css" rel="stylesheet">
    <link href="resources/css/validationEngine.jquery.css" rel="stylesheet" type="text/css">
    <link href="resources/css/chosen.css" media="screen" rel="stylesheet" type="text/css">
    <link href="resources/css/jgrowl/jquery.jgrowl.css" rel="stylesheet" type="text/css">
    <link href="resources/css/ie.css" rel="stylesheet">

    
    <script type="text/javascript">
        if($.cookie("css")) {
            $('link[href*="utopia-white.css"]').attr("href",$.cookie("css"));
            $('link[href*="utopia-dark.css"]').attr("href",$.cookie("css"));
            $('link[href*="utopia-wooden.css"]').attr("href",$.cookie("css"));
        }
        $(document).ready(function() {
            $(".theme-changer a").live('click', function() {
                $('link[href*="utopia-white.css"]').attr("href",$(this).attr('rel'));
                $('link[href*="utopia-dark.css"]').attr("href",$(this).attr('rel'));
                $('link[href*="utopia-wooden.css"]').attr("href",$(this).attr('rel'));
                $.cookie("css",$(this).attr('rel'), {expires: 365, path: '/'});
                $('.user-info').removeClass('user-active');
                $('.user-dropbox').hide();
            });
        });
    </script>

    <!--[if IE 8]>
    <link href="css/ie8.css" rel="stylesheet">
    <![endif]-->

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!--[if gte IE 9]>
      <style type="text/css">
        .gradient {
           filter: none;
        }
      </style>
    <![endif]-->

<style type="text/css">.jqstooltip { position: absolute;left: 0px;top: 0px;visibility: hidden;background: rgb(0, 0, 0) transparent;background-color: rgba(0,0,0,0.6);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000);-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";color: white;font: 10px arial, san serif;text-align: left;white-space: nowrap;padding: 5px;border: 1px solid white;}.jqsfield { color: white;font: 10px arial, san serif;text-align: left;}</style><script type="text/javascript" charset="UTF-8" src="resources/js/u/{common,util,geometry,directions}.js"></script><script type="text/javascript" charset="UTF-8" src="resources/js/u/{map,infowindow,marker}.js"></script><script type="text/javascript" charset="UTF-8" src="resources/js/u/{poly}.js"></script><script type="text/javascript" charset="UTF-8" src="resources/js/u/{onion}.js"></script><script type="text/javascript" charset="UTF-8" src="resources/js/u/{controls,stats}.js"></script></head>

<body>

<div class="container-fluid">

    <!-- Header starts -->
    <div class="row-fluid">
        <div class="span12">

            <div class="header-top">

                <div class="header-wrapper">

                    <a href="http://utopiaadmin.themio.net/dashboard.html#" class="utopia-logo"><img src="resources/img/GD/gd_logo.jpg" alt="Utopia"></a>

                    <div class="header-right">

                        <div class="header-divider">&nbsp;</div>

                        <div class="search-panel header-divider">
                            <div class="search-box">
                                <img src="resources/img/GD/Dashboard/zoom.png" alt="Search">
                                <form action="" method="post">
                                    <input type="text" name="search" placeholder="search">
                                </form>
                            </div>
                        </div>


                        <div class="notification header-divider">

                            <div class="notification-wrapper">

                                <a href="http://utopiaadmin.themio.net/dashboard.html#" class="notification-counter">8</a>
                                <div id="triangle-down"></div>

                                <div class="tabbable notification-box" style="display: none;">
                                    <ul class="nav nav-tabs">
                                        <li class="active"><a data-toggle="tab" href="http://utopiaadmin.themio.net/dashboard.html#message">Messages (3)</a></li>
                                        <li class=""><a data-toggle="tab" href="http://utopiaadmin.themio.net/dashboard.html#activity">Activity (5)</a></li>
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
                                <img src="resources/img/GD/Dashboard/user.png" alt="">
                                <a href="http://utopiaadmin.themio.net/dashboard.html#">Admin user</a>
                            </div>

                            <div class="user-dropbox" style="display: none;">
                                <ul>
                                    <li class="user"><a href="">Profile</a></li>
                                    <li class="settings"><a href="">Account Settings</a></li>
                                    <li class="theme-changer dark-theme"><a href="javascript:void(0)" class="dark" rel="css/themes/utopia-dark.css?v18">Dark theme</a></li>
                                    <li class="theme-changer white-theme"><a href="javascript:void(0)" class="white" rel="css/utopia-white.css?v19">White theme</a></li>
                                    <li class="theme-changer wooden-theme"><a href="javascript:void(0)" class="wooden" rel="css/themes/utopia-wooden.css">Wooden theme</a></li>
                                    <li class="logout"><a href="http://utopiaadmin.themio.net/index.html">Logout</a></li>
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

                        <div class="row-fluid">

                            <div class="span9">
                                <div class="row-fluid">

                                    <div class="span12">

                                        <section class="utopia-widget">
                                            <div class="utopia-widget-title">
                                                <img src="resources/img/GD/Dashboard/paragraph_justify.png" class="utopia-widget-icon">
                                                <span>Current Discussions</span>
                                            </div>

                                            <div class="utopia-widget-content" style="display: block;">

                                                <table class="table datatable table-striped table-bordered" id="gdTable">

                                            
                                                    <thead>
                                                    
                                                    <tr>
                                                        
                                                        <th>Subject</th>
                                                        <th>Description</th>
                                                        <th>Created By</th>
                                                        <th></th>
                                                    </tr>
                                                    </thead>

                                                    <tbody>
                                                        <logic:iterate id="chatId" name="GDActionForm" property="chatRoomList">
                                                            <tr>
                                                                <td><bean:write name="chatId" property="chatPadName" /></td>
                                                                <td><bean:write name="chatId" property="chatPadDesc" /></td>
                                                                <td><bean:write name="chatId" property="chatPadId" /> </td>
                                                                <td><html:link page="/LoadDiscussion.do?method=execute1" >
                                                                        <html:param  name="chatPadId">
                                                                            <bean:write name="chatId" property="chatPadId" />
                                                                        </html:param>
                                                                        <html:param  name="chatPadName">
                                                                            <bean:write name="chatId" property="chatPadName" />
                                                                        </html:param>
                                                                        Join
                                                                    </html:link>
                                                                </td>
                                                            </tr>
                                                        </logic:iterate>
 
                                                    </tbody>
                                                </table>

                                                <div class="utopia-table-action">
                                                    <div class="btn-group">
                                                        <a href="http://utopiaadmin.themio.net/dashboard.html#" class="btn"><i class="icon-cog"></i> Actions</a>
                                                        <a href="http://utopiaadmin.themio.net/dashboard.html#" data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></a>
                                                        <ul class="dropdown-menu">
                                                            <li><a href="http://utopiaadmin.themio.net/dashboard.html#"><i class="icon-eye-open"></i> View</a></li>
                                                            <li><a href="http://utopiaadmin.themio.net/dashboard.html#"><i class="icon-pencil"></i> Edit</a></li>
                                                            <li><a href="http://utopiaadmin.themio.net/dashboard.html#"><i class="icon-trash"></i> Delete</a></li>
                                                        </ul>
                                                    </div>
                                                </div>

                                            </div>
                                        </section>

                                    </div>

                                </div>
                                <div class="row-fluid">
                                    
                                        
                                </div>
                                
                                
                            </div><!-- Mid panel -->

                            <div class="span3">

                                <div class="row-fluid">

                                    <div class="span12">

                                            <div class="utopia-chart-legend">
                                            <div class="utopia-chart-icon">
                                           <!-- <img src="resources/img/icons/add(1).png"> -->
                                           <a class="btn utopia-round-button" href="#" id="insertGDSecret"><i class="icon-heart" ></i></a>
                                            </div>
                                           <div class="utopia-chart-heading">Add</div>
                                          <div class="utopia-chart-desc">SECRET DISCUSSION</div>
                                          </div>
                                    </div>

                                </div>
                                
                                
                                <div class="row-fluid">

                                    <div class="span12">
                                          <div class="utopia-chart-legend">
                                            <div class="utopia-chart-icon">
                                           <!-- <img src="resources/img/icons/add(1).png"> -->
                                           <a class="btn utopia-round-button" href="#" id="insertGDCampus"><i class="icon-home" ></i></a>
                                            </div>
                                           <div class="utopia-chart-heading">Add</div>
                                          <div class="utopia-chart-desc">CAMPUS DISCUSSION</div>
                                          </div>
                                    </div>

                                </div>

                                <div class="row-fluid">
                                    <div class="span12">
                                      <div class="utopia-chart-legend">
                                            <div class="utopia-chart-icon">
                                           <!-- <img src="resources/img/icons/add(1).png"> -->
                                           <a class="btn utopia-round-button" href="#" id="insertGDOpen"><i class="icon-comment" ></i></a>
                                            </div>
                                           <div class="utopia-chart-heading">Add</div>
                                          <div class="utopia-chart-desc">OPEN DISCUSSION</div>
                                          </div>
                                    </div>
                                </div>

                                </div><!-- Right panel -->

                        </div>

                    </div>

                </div>


             
            </div>
        <!-- Body end -->

    </div>

    <!-- Maincontent end -->

</div> <!-- end of container -->

<!-- ---------------------------------------------------------------------------------------- -->
<form class="form-horizontal" style="display:none" id="insertGDFormSecret">
    <table> 
        
    <div class="span3">
        <fieldset>
            <tr>
            <div class="pull-left" >Create Secret Discussion</div>
            </tr>
            <tr>   <div class="control-group">
                <td><label class="control-label" >Subject  :</label></td>
                <td>
                        <input id="gdSubject" class="span2 pull-left" name="gdSubject" type="text"/>
                    </td>
            </div>
            </tr>
            
            <tr>
            <div class="control-group">
                <td><label class="control-label" >Description  :</label></td>
                <td>
                    <input id="gdDesc" class="span2 pull-left" name="gdDesc" type="text"/>
                    
                </td>
            </div></tr>
            <tr><td></td>
                <td>
                        <button class="btn span2" onclick="" id="submitGDSecret" >Create</button>
                </td>
            </tr>
        </fieldset>
    </div>
    </table>    
</form>    

<!-- ---------------------------------------------------------------------------------------- -->
<form class="form-horizontal" style="display:none" id="insertGDFormCampus">
    <table> 
        
    <div class="span3">
        <fieldset>
            <tr>
            <div class="pull-left" >Create Campus Discussion</div>
            </tr>
            <tr>   <div class="control-group">
                <td><label class="control-label" >Subject  :</label></td>
                <td>
                        <input id="gdSubjectCampus" class="span2 pull-left" name="gdSubjectCampus" type="text"/>
                    </td>
            </div>
            </tr>
            
            <tr>
            <div class="control-group">
                <td><label class="control-label" >Description  :</label></td>
                <td>
                    <input id="gdDescCampus" class="span2 pull-left" name="gdDescCampus" type="text"/>
                    
                </td>
            </div></tr>
            <tr><td></td>
                <td>
                        <button class="btn span2" onclick="" id="submitGDCampus" >Create</button>
                </td>
            </tr>
        </fieldset>
    </div>
    </table>    
</form>    

<!-- ---------------------------------------------------------------------------------------- -->
<form class="form-horizontal" style="display:none" id="insertGDFormOpen">
    <table> 
        
    <div class="span3">
        <fieldset>
            <tr>
            <div class="pull-left" >Create Open Discussion</div>
            </tr>
            <tr>   <div class="control-group">
                <td><label class="control-label" >Subject  :</label></td>
                <td>
                        <input id="gdSubjectOpen" class="span2 pull-left" name="gdSubjectOpen" type="text"/>
                    </td>
            </div>
            </tr>
            
            <tr>
            <div class="control-group">
                <td><label class="control-label" >Description  :</label></td>
                <td>
                    <input id="gdDescOpen" class="span2 pull-left" name="gdDescOpen" type="text"/>
                    
                </td>
            </div></tr>
            <tr><td></td>
                <td>
                        <button class="btn span2" onclick="" id="submitGDOpen" >Create</button>
                </td>
            </tr>
        </fieldset>
    </div>
    </table>    
</form>    

<!-- javascript placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="resources/js/u/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/u/jquery.cookie.js"></script>
<script type="text/javascript" src="resources/js/u/utopia.js"></script>
<script type="text/javascript" src="resources/js/u/jquery.hoverIntent.min.js"></script>
<script type="text/javascript" src="resources/js/u/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="resources/js/u/jquery.datatable.js"></script>
<script type="text/javascript" src="resources/js/u/tables.js"></script>
<script type="text/javascript" src="resources/js/u/jquery.sparkline.js"></script>
<script type="text/javascript" src="resources/js/u/jquery.vticker-min.js"></script>
<script type="text/javascript" src="resources/js/u/datepicker.js"></script>
<script type="text/javascript" src="resources/js/u/load-image.min.js"></script>
<script type="text/javascript" src="resources/js/u/image-gallery.min.js"></script>
<script type="text/javascript" src="resources/js/u/jquery.simpleWeather.js"></script>
<script src="resources/js/u/jquery.validationEngine.js" type="text/javascript"></script>
<script src="resources/js/u/jquery.validationEngine-en.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/u/maskedinput.js"></script>
<script type="text/javascript" src="resources/js/u/chosen.jquery.js"></script>
<script type="text/javascript" src="resources/js/u/js"></script><script src="resources/js/u/main.js" type="text/javascript"></script>
<script type="text/javascript" src="resources/js/u/gmap3.js"></script>
<script type="text/javascript" src="resources/js/u/header.js"></script>
<script type="text/javascript" src="resources/js/u/sidebar.js"></script>
<script type="text/javascript" src="resources/js/blockui.js"></script>
<script type="text/javascript" src="resources/js/jgrowl/jquery.jgrowl.js"></script>
<script type="text/javascript" src="resources/js/noty/jquery.noty.js"></script>
<script type="text/javascript" src="resources/js/noty/layouts/top.js"></script>
<script type="text/javascript" src="resources/js/noty/layouts/topLeft.js"></script>
<script type="text/javascript" src="resources/js/noty/layouts/topRight.js"></script>
<script type="text/javascript" src="resources/js/noty/themes/default.js"></script>
<script type="text/javascript" src="script/GD/gdPage.js"></script>

<script type="text/javascript">

    $(function() {

        $( "#utopia-dashboard-datepicker" ).datepicker().css({marginBottom:'20px'});

        jQuery("#validation").validationEngine();
        $("#phone").mask("(999) 9999999999");
        $(".chzn-select").chosen(); $(".chzn-select-deselect").chosen({allow_single_deselect:true});

        $.simpleWeather({
            zipcode: '10001',
            unit: 'f',
            success: function(weather) {
                html = '<h2>'+weather.city+', '+weather.region+'</h2>';
                html += '<img style="float:left" width="125px " src="'+weather.image+'">';
                html += '<p>'+weather.temp+'&deg; '+weather.units.temp+'<br /><span>'+weather.currently+'</span></p>';
                html += '<a href="'+weather.link+'">View Forecast &raquo;</a>';

                $("#utopia-dashboard-weather").css({marginBottom:'20px'}).html(html);
            },
            error: function(error) {
                $("#utopia-dashboard-weather").html('<p>'+error+'</p>');
            }
        });


        /* maps with route directions */
        $("#utopia-google-map-5").gmap3(
            { action:'getRoute',
                options:{
                    origin:'48 Pirrama Road, Pyrmont NSW',
                    destination:'Bondi Beach, NSW',
                    travelMode:google.maps.DirectionsTravelMode.DRIVING
                },
                callback:function (results) {
                    if (!results) return;
                    $(this).gmap3(
                        { action:'init',
                            zoom:13,
                            mapTypeId:google.maps.MapTypeId.ROADMAP,
                            streetViewControl:true,
                            center:[-33.879, 151.235]
                        },
                        { action:'addDirectionsRenderer',
                            options:{
                                preserveViewport:true,
                                draggable:false,
                                directions:results
                            }
                        }
                    );
                }
            }
        );
        /* maps with route directions end */
        
    });

    
    $("#utopia-sparkline-type1").sparkline([5, 6, 7, 9, 9, 5, 3, 2, 2, 4, 6, 7, 5, 6, 7, 9, 9], {type:"line", height:48, width:140});

    $('.utopia-activity-feeds').vTicker({
        speed: 500,
        pause: 3000,
        animation: 'fade',
        height: 335,
        mousePause: true,
        showItems: 4
    });


    
</script>


<div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div></body>
</html:html>