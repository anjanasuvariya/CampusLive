<!DOCTYPE html>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<c:set var="userAchievementDtlList" value="${requestScope.userAchievementDtlList}"/>
<script type="text/javascript" src="script/User/editAchievements.js"></script>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Resume - ${sessionScope.userName}</title>
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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="resources/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="resources/ico/favicon.png">
  </head>

  <body>

           <!-- ================================================== -->
        <tiles:insert definition="project-template-studentlogin-header" >
             <tiles:put name="studentlogin-header" value="/WEB-INF/jsp/Templates/studentlogin_header.jsp" />
        </tiles:insert>  


    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
            
          <div class="well sidebar-nav">
              <center><h2>Resume</h2>
            <img class="img-rounded" src="resources/img/User/resumeimg.png"/>
          
            <p>Time to Upload Your Resume</p>
             _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 
                           <br/><br/>
          </center>
            <ul class="nav nav-list">
              <li class="nav-header">Resume Includes</a></li>
              <li><a href="#">Personal Details</a></li>
              <li><a href="#">Conatact Details</a></li>
              <li><a href="#">Educational Details</a></li>
              <li><a href="#">Work Experience</a></li>
              <li><a href="#">Awards & Achievements</a></li>
              <li><a href="#">Participations</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          <div class="sidebar-nav">
              
              
              <html:form styleClass="form-horizontal" action="/editResume.do?callmethod=uploadResume" enctype="multipart/form-data" method="post" >
<fieldset>

    
     <html:link action="/editResume.do?callmethod=downloadResume">
         <button class="btn btn-large btn-success" type="button">Download Resume</button>
     </html:link> 
 
     <hr/>
    <br/>
    
    <h3> Upload Resume Here </h3>
<div class="control-group span12">
  
  
<html:file property="file"  styleClass="input-file"  />  </div>

<br/><br/><br/>
<button class="btn btn-large btn-info" type="submit">Upload</button>

</fieldset>
</html:form>

              
          </div>

      <hr>

    

    </div><!--/.fluid-container-->

    <!-- Le javascript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
                <script src="resources/js/jquery.js"></script>
                <script src="resources/js/bootstrap-transition.js"></script>
                <script src="resources/js/bootstrap-alert.js"></script>
                <script src="resources/js/bootstrap-modal.js"></script>
                <script src="resources/js/bootstrap-scrollspy.js"></script>
                <script src="resources/js/bootstrap-tab.js"></script>
                <script src="resources/js/bootstrap-tooltip.js"></script>
                <script src="resources/js/bootstrap-popover.js"></script>
                <script src="resources/js/bootstrap-button.js"></script>
                <script src="resources/js/bootstrap-collapse.js"></script>
                <script src="resources/js/bootstrap-carousel.js"></script>
                <script src="resources/js/bootstrap-typeahead.js"></script>

                <script src="resources/assets/js/bootstrap.min.js"></script>


                <script>
                    $(document).ready(function(){
                        $('.dropdown-toggle').dropdown()
                    });
                </script>

                </body>
                </html>
