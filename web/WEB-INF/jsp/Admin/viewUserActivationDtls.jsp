<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="userActivationList" value="${requestScope.userActivationList}"/>

<!DOCTYPE html>
<html lang="en">

        <head>
            <meta charset="utf-8">
            <title>User Activation Detail</title>
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
         <tiles:insert definition="project-template-placecomm-header" >
             <tiles:put name="placecomm-header" value="/WEB-INF/jsp/PlaceComm/placeCommHeader.jsp" />
        </tiles:insert>  

        <!-- Subhead
        ================================================== -->
        <header class="jumbotron subhead" id="overview" style="background-image: linear-gradient(rgb(30, 87, 153) 0%, rgb(32, 124, 202) 35%, rgb(125, 185, 232) 100%)">
            
            
            <div class="container" >
                <h1>User Activation Detail</h1>
                <p class="lead">Share User Activation Detail via sending email</p>
            
            </div>
        </header>


<br/>
        <div class="container">
        <!-- Docs nav ================================================== -->
        <div class="row">
        
        <div class="span12">
                   <div class="utopia-widget-content" style="display: block;">

                        <table class="table datatable table-striped table-bordered" id="tblUserActivationDtls">


                            <thead>

                                <tr>
                                    <th><input type="checkbox" /></th>
                                    <th>Roll No.</th>
                                    <th>User Name</th>
                                    <th>Email Id</th>
                                    <th>User Type</th>
                                    <th>Activation Code</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                              <c:forEach items="${userActivationList}" var="userActivationDtl" varStatus="rowCnt">
                                <tr id ="trUserActId${rowCnt.count}">
                                    <td><input type="checkbox" name="chkUserActId" id="chkUserActId${rowCnt.count}" value="${userActivationDtl.id}"></td>
                                    <td>${userActivationDtl.rollNo}</td>
                                    <td>${userActivationDtl.userFullName}</td>
                                    <td>${userActivationDtl.emailId}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${userActivationDtl.userType eq  'A'}">
                                                Alumni
                                            </c:when>
                                             <c:when test="${userActivationDtl.userType eq  'F'}">
                                                Faculty
                                            </c:when>
                                             <c:when test="${userActivationDtl.userType eq  'S'}">
                                                Student
                                            </c:when>
                                            <c:otherwise>
                                                -
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>${userActivationDtl.activationCode}</td>
                                    <td>
                                       Edit/Delete
                                    </td>
                                                             
                                </tr>
                               </c:forEach>                                   
                            </tbody>

                        </table>

                        

                    </div>
            
        </div>
    </div>
</div>
<div >
                 
    <a href="#" class="btn btn-primary" id="btnSaveHrDtl" onclick="sendUserActivationDtlByMail();"><i class="icon-share-alt icon-white"></i> Send Mail</a>
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
<script type="text/javascript" src="script/Admin/viewUserActivationDtls.js"></script>

</body>
</html>
