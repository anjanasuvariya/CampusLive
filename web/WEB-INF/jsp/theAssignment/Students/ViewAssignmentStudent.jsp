<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<html:html>
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style type="text/css">@media print {  .gmnoprint {    display:none  }}@media screen {  .gmnoscreen {    display:none  }}</style>
        <meta charset="utf-8">
        <title>the Assignment</title>
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
        <link href="resources/css/adipoli/adipoli.css" rel="stylesheet" type="text/css">
        <link href="resources/css/datepicker/datepicker.css" rel="stylesheet" type="text/css">
        
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
                <tiles:insert definition="project-template-student-header" >
                    <tiles:put name="student-header" value="/WEB-INF/jsp/Templates/student-header.jsp" />
                </tiles:insert>
                    

                </div>

            </div>

            <!-- Header ends -->

            <div class="row-fluid">

                <!-- Sidebar statrt -->
                <div class="span2 sidebar-container">
                    <div class="sidebar">

                        <!-- Sidebar Starts As Tiles -->
                    <tiles:insert definition="project-template-student-sidebar" >
                        <tiles:put name="student-sidebar" value="/WEB-INF/jsp/Templates/student-sidebar.jsp" />
                    </tiles:insert>    
                    </div>
                </div>

                <!-- Sidebar end -->

                <!-- Body start -->
                <div class="span10 body-container">

                    <div class="row-fluid">

                        <section id="formElement" class="utopia-widget utopia-form-box section">
                        
                        <div class="utopia-widget-title">
                            <img src="resources/img/icons/font_size.png" class="utopia-widget-icon">
                            <span>To-Do List of Assignments </span>
                        </div>
                            
                        <div class="row-fluid">
                            
                            <div class="utopia-widget-content" style="display: block;">

                            <logic:iterate id="assgMstList" name="CreateAssgForm" property="assgMstList">
                                <dl class="dl-horizontal">
                                <div class="span4">
                                <dt>Title</dt>
                                <dd><bean:write name="assgMstList" property="assgTitle" /></dd>
                                </div>
                                <div class="span4">
                                <dt>Subject</dt>
                                <dd><bean:write name="assgMstList" property="assgSubject" /></dd>
                                </div>
                                <div class="span4">
                                <dt>Deadline</dt>
                                <dd style="color:red"><bean:write name="assgMstList" property="assgSubmitDate" format="dd-MM-yyyy"/></dd>
                                </div>
                                
                                
                                <dt>Description</dt>
                                <dd><bean:write name="assgMstList" property="assgDetails"/></dd>
                                <dt>Submission Details</dt>
                                <dd><bean:write name="assgMstList" property="assgSubmissionDetails"/></dd>
                                <dt>Downloads</dt>
                                <dd><html:link page="/ManageAssignmentStudent.do?callmethod=download" >
                                            <html:param  name="assgFileUrl">
                                            <bean:write name="assgMstList" property="assgFileUrl" />
                                            </html:param>
                                            Download File <i class="icon-download-alt" ></i>
                                    </html:link></dd>    
                                <dt>Submission Type</dt>
                                <dd>
                                    <logic:equal name="assgMstList" property="assgSubmitType" value="0">
                                        Online Submission via Text Editor
                                    </logic:equal>
                                    <logic:equal name="assgMstList" property="assgSubmitType" value="1">
                                        Upload File
                                    </logic:equal>
                                    <logic:equal name="assgMstList" property="assgSubmitType" value="2">
                                        Hard Copy
                                    </logic:equal>
                                </dd>
                                
                                <dt>Submit Now</dt>
                                <dd>        <html:link page="/ManageAssignmentStudent.do?callmethod=ViewAssignment" style="color:green">
                                            <html:param  name="assgId">
                                            <bean:write name="assgMstList" property="assgId" />
                                            </html:param>
                                            <html:param  name="assgSubmitType">
                                            <bean:write name="assgMstList" property="assgSubmitType" />
                                            </html:param>
                                            <html:param  name="assgTitle">
                                            <bean:write name="assgMstList" property="assgTitle" />
                                            </html:param>
                                            <html:param  name="assgSubject">
                                            <bean:write name="assgMstList" property="assgSubject" />
                                            </html:param>
                                            <html:param  name="assgDetails">
                                            <bean:write name="assgMstList" property="assgDetails" />
                                            </html:param>
                                            <html:param  name="assgSubmissionDetails">
                                            <bean:write name="assgMstList" property="assgSubmissionDetails" />
                                            </html:param>
                                            
                                            Click Here <i class="icon-plus-sign" ></i>
                                            </html:link>
                                </dd> 
                              
                                
                                
                                
                                </dl>
                                <br/>
                                <hr/>
                                </logic:iterate>
                    </div>
                </div>
                    </section>
                        
                        
                        <section id="formElement2" class="utopia-widget utopia-form-box section">
                        
                        <div class="utopia-widget-title">
                            <img src="resources/img/icons/font_size.png" class="utopia-widget-icon">
                            <span> Submitted Assignments </span>
                        </div>
                            
                        <div class="row-fluid">
                            
                            <div class="utopia-widget-content" style="display: block;">

                            <logic:iterate id="assgMstSubmittedList" name="CreateAssgForm" property="assgMstSubmittedList">
                                <dl class="dl-horizontal">
                                <div class="span4">
                                <dt>Title</dt>
                                <dd><bean:write name="assgMstSubmittedList" property="assgTitle" /></dd>
                                </div>
                                <div class="span4">
                                <dt>Subject</dt>
                                <dd><bean:write name="assgMstSubmittedList" property="assgSubject" /></dd>
                                </div>
                                <div class="span4">
                                <dt>Deadline</dt>
                                <dd style="color:red"><bean:write name="assgMstSubmittedList" property="assgSubmitDate" format="dd-MM-yyyy"/></dd>
                                </div>
                                
                                
                                <dt>Description</dt>
                                <dd><bean:write name="assgMstSubmittedList" property="assgDetails"/></dd>
                                <dt>Submission Details</dt>
                                <dd><bean:write name="assgMstSubmittedList" property="assgSubmissionDetails"/></dd>
                                <dt>Downloads</dt>
                                <dd><html:link page="/ManageAssignmentStudent.do?callmethod=download" >
                                            <html:param  name="assgFileUrl">
                                            <bean:write name="assgMstSubmittedList" property="assgFileUrl" />
                                            </html:param>
                                            Download File <i class="icon-download-alt" ></i>
                                    </html:link></dd>    
                                <dt>Submission Type</dt>
                                <dd>
                                    <logic:equal name="assgMstSubmittedList" property="assgSubmitType" value="0">
                                        Online Submission via Text Editor
                                    </logic:equal>
                                    <logic:equal name="assgMstSubmittedList" property="assgSubmitType" value="1">
                                        Upload File
                                    </logic:equal>
                                    <logic:equal name="assgMstSubmittedList" property="assgSubmitType" value="2">
                                        Hard Copy
                                    </logic:equal>
                                </dd>
                                
                                <dt>Submit Now</dt>
                                <dd>        <html:link page="/ManageAssignmentStudent.do?callmethod=ViewAssignment" style="color:green">
                                            <html:param  name="assgId">
                                            <bean:write name="assgMstSubmittedList" property="assgId" />
                                            </html:param>
                                            <html:param  name="assgSubmitType">
                                            <bean:write name="assgMstSubmittedList" property="assgSubmitType" />
                                            </html:param>
                                            <html:param  name="assgTitle">
                                            <bean:write name="assgMstSubmittedList" property="assgTitle" />
                                            </html:param>
                                            <html:param  name="assgSubject">
                                            <bean:write name="assgMstSubmittedList" property="assgSubject" />
                                            </html:param>
                                            <html:param  name="assgDetails">
                                            <bean:write name="assgMstSubmittedList" property="assgDetails" />
                                            </html:param>
                                            <html:param  name="assgSubmissionDetails">
                                            <bean:write name="assgMstSubmittedList" property="assgSubmissionDetails" />
                                            </html:param>
                                            
                                            Click Here <i class="icon-plus-sign" ></i>
                                            </html:link>
                                </dd> 
                              
                                
                                
                                
                                </dl>
                                <br/>
                                <hr/>
                                </logic:iterate>
                    </div>
                </div>
                    </section>
                    </div>

                    
                </div>
                
                        
                <!-- Maincontent end -->

            </div> <!-- end of container -->


          

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
            <script type="text/javascript" src="resources/js/createAssignmentStudent.js"></script>
            <script type="text/javascript" src="resources/js/freetile/jquery.freetile.min.js"></script>
            <script type="text/javascript" src="resources/js/adipoli/jquery.adipoli.min.js"></script>
            <script type="text/javascript" src="resources/js/datepicker/bootstrap-datepicker.js"></script>
            <script type="text/javascript" src="resources/js/pagination/jquery.simplePagination.js"></script>
            
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