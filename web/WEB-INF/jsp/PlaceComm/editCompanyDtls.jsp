<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="companyDtlList" value="${requestScope.companyDtlList}"/>

<!DOCTYPE html>
<html lang="en">

        <head>
            <meta charset="utf-8">
            <title>Company Database</title>
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

        <body data-spy="scroll" data-target=".bs-docs-sidebar" data-twttr-rendered="true" style="z-index:1800">

        <!-- Navbar
        ================================================== -->
        <tiles:insert definition="project-template-placecomm-header" >
             <tiles:put name="placecomm-header" value="/WEB-INF/jsp/PlaceComm/placeCommHeader.jsp" />
        </tiles:insert>  


        <!-- Subhead
        ================================================== -->
        <header class="jumbotron subhead" id="overview" style="background-image: linear-gradient(45deg, #B24926 0%, rgb(170, 150,200) 100%)">
            <div class="container" >
                <h1>Recruiters</h1>
                <p class="lead">Add,Edit,Search,Delete,Classify & Sort Recruiters</p>
                <a id="insertCompany" data-toggle="modal" href="#myModal" class="btn btn-large btn-danger" style="color: white" onclick="resetData()"><i class="icon-plus-sign icon-white"></i> Add Company</a>
            </div>
        </header>

<br/>
        <div class="container">
        <!-- Docs nav ================================================== -->
        <div class="row">
        
        <div class="span12">
                <input type="hidden" name="hdnCompanyCnt" id="hdnCompanyCnt"/>
                 <div class="utopia-widget-content" style="display: block;">
                        <table class="table datatable table-striped table-bordered" id="tblCompanyDtls">
                            <thead>
                                <tr>
                                    <td></td>
                                    <th><a>Name</a></th>
                                    <th><a>Code</a></th>
                                    <th><a>Contact Person</a></th>
                                    <th><a>Contact Number</a></th>
                                    <th><a>Address</a></th>
                                    <th><a>Email</a></th>
                                    <th><a>Location</a></th>
                                    <th><a>Priority</a></th>
                                    <th><a>Delete</a></th>
                                </tr>
                            </thead>

                            <tbody>
                                
                                <c:forEach items="${companyDtlList}" var="pcCompanyDtls" varStatus="rowCnt">
                                    <tr id="trCompanyId${rowCnt.count}">
                                        <td> <input type="checkbox" name="chkCompanyId" id="chkCompanyId${rowCnt.count}" value="${pcCompanyDtls.companyId}"></td>    
                                        <td><a data-toggle="modal" href="#myModal" onclick="populateCompanyData('${rowCnt.count}','${pcCompanyDtls.companyId}','${pcCompanyDtls.companyTitle}')">${pcCompanyDtls.companyTitle}</a></td>
                                        <td>${pcCompanyDtls.companyCode}</td>
                                        <td>${pcCompanyDtls.contactPersonName}</td> 
                                        <td>${pcCompanyDtls.contactNumber}</td>
                                        <td>${pcCompanyDtls.contactAddress}</td>
                                        <td>${pcCompanyDtls.contactEmail}</td>
                                        <td>${pcCompanyDtls.companyLocation}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${pcCompanyDtls.companyPriority == 'M'}">
                                                    Medium
                                                </c:when>
                                                <c:when test="${pcCompanyDtls.companyPriority == 'H'}">
                                                    High
                                                </c:when>
                                                <c:otherwise>
                                                    Low    
                                                </c:otherwise>
                                             </c:choose>
                                        </td>
                                        <td align ="center">
                                            <i class="icon-trash" onclick="deleteCompanyDtls('N','${pcCompanyDtls.companyId}','${rowCnt.count}')"></i> 
                                        </td>
                                        
                                    </tr>
                                    <script>
                                        var count = '${rowCnt.count}';
                                        document.getElementById("hdnCompanyCnt").value=Number(count)+1;
                                     </script>
                                </c:forEach> 

                            </tbody>

                        </table>

                        <div class="utopia-table-action">
                            <div class="btn-group">
                                <a href="http://utopiaadmin.themio.net/dashboard.html#" class="btn"><i class="icon-cog"></i> Actions</a>
                                <a href="http://utopiaadmin.themio.net/dashboard.html#" data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="http://utopiaadmin.themio.net/dashboard.html#"><i class="icon-eye-open"></i> View</a></li>
                                    <li><a href="http://utopiaadmin.themio.net/dashboard.html#"><i class="icon-pencil"></i> Edit</a></li>
                                    <li><a href="#" id="deleteCompanyDtl" onclick="deleteCompanyDtls('Y','')"><i class="icon-trash"></i> Delete</a></li>
                                </ul>
                            </div>
                        </div>

                    </div>
            
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

  <div class="modal fade" id="myModal" style="z-index: 1500; display: none">
    <div class="modal-dialog" style="z-index: 901" >
      <div class="modal-content" style="z-index: 902">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Add Recruiters</h4>
        </div>
        <form class="form-horizontal">
          <div class="modal-body">
          
<fieldset>

<!-- Form Name -->


<!-- Text input-->
<div class="control-group">
  <label class="control-label">Title</label>
  <div class="controls">
      <input type ="hidden" id="companyId" name="companyId" />
      <input type ="hidden" id="hdnRowId" name="hdnRowId" />
      <input id="companyTitle" name="companyTitle" type="text" placeholder="e.g. Tata Consultancy Services Pvt Ltd" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label">3-Digit Code</label>
  <div class="controls">
    <input id="companyCode" name="companyCode" type="text" placeholder="E.g. TCS" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label">Contact Person</label>
  <div class="controls">
    <input id="contactPersonName" name="contactPersonName" type="text" placeholder="Primary Contact Person" class="input-xlarge">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label">Contact Number</label>
  <div class="controls">
    <input id="contactNumber" name="contactNumber" type="text" placeholder="e.g. 9876543210" class="input-xlarge">
    
  </div>
</div>

<!-- Textarea -->
<div class="control-group">
  <label class="control-label">Contact Address</label>
  <div class="controls">                     
    <textarea id="contactAddress" name="contactAddress"></textarea>
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label">Email</label>
  <div class="controls">
    <input id="contactEmail" name="contactEmail" type="text" placeholder="xxx@xxx.com" class="input-xlarge">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label">Location</label>
  <div class="controls">
    <input id="companyLocation" name="companyLocation" type="text" placeholder="e.g. Banglore" class="input-xlarge" required="">
    
  </div>
</div>

<!-- Multiple Radios -->
<div class="control-group">
  <label class="control-label">Priority</label>
  <div class="controls">
    <label class="radio">
      <input type="radio" name="companyPriority" id="companyPriorityL" value="L" checked="checked">
      Low
    </label>
    <label class="radio">
      <input type="radio" name="companyPriority" id="companyPriorityM" value="M">
      Medium
    </label>
    <label class="radio">
      <input type="radio" name="companyPriority" id="companyPriorityH" value="H">
      High
    </label>
  </div>
</div>

</fieldset>


            
            
        </div>
        <div class="modal-footer">
          <a href="#" class="btn btn-inverse" onclick="resetData()"><i class="icon-retweet icon-white"></i> Reset</a>
          
          <a href="#" class="btn btn-primary" id="saveCompanyDtl" ><i class="icon-share-alt icon-white"></i> Save</a>
        </div>
          </form>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
  </div><!-- /.modal -->



<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/assets/js/jquery-1.9.0.min.js"></script>
<script src="resources/assets/js/bootstrap.min.js"></script>
<script src="resources/assets/js/holder.js"></script>
<script src="resources/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="resources/assets/js/google-code-prettify/prettify.js"></script>
<script src="resources/assets/js/docs.js"></script>
<script src="resources/assets/js/demo.js"></script>

<!-- REPLACE THIS WITH ALREADY EXISTING PATHS OF THE FILES -->

<script type="text/javascript" src="resources/js/u/utopia.js"></script>
<script type="text/javascript" src="resources/js/u/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/u/jquery.datatable.js"></script>
<script type="text/javascript" src="resources/js/u/tables.js"></script>

<script type="text/javascript" src="resources/js/noty/jquery.noty.js"></script>
<script type="text/javascript" src="resources/js/noty/layouts/top.js"></script>
<script type="text/javascript" src="resources/js/noty/layouts/topLeft.js"></script>
<script type="text/javascript" src="resources/js/noty/layouts/topRight.js"></script>
<script type="text/javascript" src="resources/js/noty/themes/default.js"></script>
<script type="text/javascript" src="script/PlaceComm/editCompanyDtls.js"></script>
</body>
</html>
