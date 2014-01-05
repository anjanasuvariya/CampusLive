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
    <title>Achievements - ${sessionScope.userName}</title>
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
              <center><h2>Achievements</h2>
            <img class="img-rounded" src="resources/img/User/achievement.png"/>
          
            <p>Time to show your achievements</p>
             _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ 
                           <br/><br/>
          </center>
            <ul class="nav nav-list">
              <li class="nav-header">Achievements Include</li>
              <li><a href="#">Achievement Title</a></li>
              <li><a href="#">Achievement Description</a></li>
              <li><a href="#">Sports Participation</a></li>
              <li><a href="#">Research Publications</a></li>
              <li><a href="#">On-Campus Events</a></li>
              <li><a href="#">Off-Campus Events</a></li>
              <li><a href="#">Volunterring Experiences</a></li>
              <li><a href="#">Need More Help ? </a></li>
              <li><a href="#">Have an idea ? Submit Here</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          <div class="sidebar-nav">
            
              <form class="form-horizontal" action="saveUserAchievementDtls.do">
<fieldset>

<!-- Form Name -->

<div class="control-group"></div>
<!-- Text input-->
<div class="control-group">
  <label class="control-label">Achievement Title</label>
  <div class="controls">
    <input id="achievementTitle" name="achievementTitle" type="text" placeholder="e.g. Participated/Won 1st Prize" class="input-xlarge" >
    <input id="hdnRowCnt" name="hdnRowCnt" type="hidden"/>
    <input id="hdnRowObj" name="hdnRowObj" type="hidden"/>
  </div>
</div>

<div class="control-group">
  <label class="control-label">Category</label>
  <div class="controls">
    <input id="category" name="category" type="text" placeholder="e.g. Sports, Publications, Business Plans" class="input-xlarge">
    
  </div>
</div>


<!-- File Button --> 
<div class="control-group">
  <label class="control-label">Image, if any</label>
  <div class="controls">
    <input id="achievementImage" name="achievementImage" class="input-file" type="file">
  </div>
</div>

<div class="control-group">
  <label class="control-label">Event Name</label>
  <div class="controls">
    <input id="eventName" name="eventName" type="text" placeholder="e.g. Crisil Young Thoght Leaders" class="input-xlarge">
    
  </div>
</div>


<!-- Text input-->
<div class="control-group">
  <label class="control-label">Organizers</label>
  <div class="controls">
    <input id="organizers" name="organizers" type="text" placeholder="e.g. Indian Institute Of Management, Ahmedabad" class="input-xlarge" >
    
  </div>
</div>

<!-- Textarea -->
<div class="control-group">
  <label class="control-label">Description</label>
  <div class="controls">                     
      <textarea id="description" name="description" placeholder="How was your experience at this event?"></textarea>
  </div>
</div>


<div class="control-group">
  
  <div class="controls">
      <input class="btn btn-large btn-info" id="btnAdd" type="button" onclick="addNewAchievementRow()" value="Add Achievement"/>
      <input class="btn btn-large btn-primary" id="btnUpdate" type="button" onclick="updateAchmntRowData()" style="display: none" value="Update"/>
            
  </div>
</div>
<input type="hidden" id="hdnCount" name="hdnCount" value="0"/>

<table id="tblAchievementdtl" name="tblAchievementdtl" border="1" width="90%" size="90%" class="table">
    <thead>
    <tr>
        <th width="20%">Achievement Title</td>
        <th width="10%">Category</td>
        <th width="10%">Event Name</td>
        <th width="10%">Organizers</td>
        <th width="10%">Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userAchievementDtlList}" var="userAchievementDtl" varStatus="rowCnt">
       <tr>
        <td width="20%">${userAchievementDtl.achievementTitle}
            <input type="hidden" name="hdnAchievementTitle" id="hdnAchievementTitle${rowCnt.count}" value="${userAchievementDtl.achievementTitle}"/>
        </td>
        <td width="10%">${userAchievementDtl.achievementCategory}
            <input type="hidden" name="hdnCategory" id="hdnCategory${rowCnt.count}" value="${userAchievementDtl.achievementCategory}"/>
        </td>
        <td width="10%">${userAchievementDtl.eventName} 
            <input type="hidden" name="hdnEventName" id="hdnEventName${rowCnt.count}" value="${userAchievementDtl.eventName} "/>
            
        </td>
        <td width="10%">${userAchievementDtl.eventOrganizers}
            <input type="hidden" name="hdnOrganizers" id="hdnOrganizers${rowCnt.count}" value="${userAchievementDtl.eventOrganizers}"/>
            <input type="hidden" name="hdnDescription" id="hdnDescription${rowCnt.count}" value="${userAchievementDtl.eventDescription}"/>
        
        </td>
        <td width="10%"><a href="#" onclick="editAchievementRow(this,'${rowCnt.count}');">Edit</a>/<a href="#" onclick="removeRow(this);">Delete</a></td>
       </tr>
       <script>
           var count = '${rowCnt.count}';
           document.getElementById("hdnCount").value=Number(count)+1;
       </script>
    </c:forEach>
       </tbody>
</table>
<br/><br/>
   <button class="btn btn-large btn-success offset1" type="submit">Save</button>

</fieldset>
</form>

              
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
