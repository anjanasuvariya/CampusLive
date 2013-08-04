<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html:html>
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style type="text/css">@media print {  .gmnoprint {    display:none  }}@media screen {  .gmnoscreen {    display:none  }}</style>
    <meta charset="utf-8">
    <title>the Quizzer</title>
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
                <tiles:insert definition="project-template-faculty-header" >
                    <tiles:put name="faculty-header" value="/WEB-INF/jsp/Templates/faculty-header.jsp" />
                </tiles:insert>
                    

                </div>

            </div>

            <!-- Header ends -->

            <div class="row-fluid">

                <!-- Sidebar statrt -->
                <div class="span2 sidebar-container">
                    <div class="sidebar">

                        <!-- Sidebar Starts As Tiles -->
                    <tiles:insert definition="project-template-faculty-sidebar" >
                        <tiles:put name="faculty-sidebar" value="/WEB-INF/jsp/Templates/faculty-sidebar.jsp" />
                    </tiles:insert>    
                    </div>
                </div>

        <!-- Sidebar end -->

        <!-- Body start -->
            <div class="span10 body-container">



                <div class="row-fluid">

                    <div class="span12">

                       

                        
                      
                    
                </div>
</div>
        <!-- Body end -->

    </div>

    <!-- Maincontent end -->

</div> <!-- end of container -->


 <!-- Form for Block UI... -->

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
<script type="text/javascript" src="resources/js/assignmentPage.js"></script>
<script type="text/javascript" src="resources/js/freetile/jquery.freetile.min.js"></script>
<script type="text/javascript" src="resources/js/adipoli/jquery.adipoli.min.js"></script>
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