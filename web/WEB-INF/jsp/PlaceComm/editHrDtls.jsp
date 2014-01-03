<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="hrDtlList" value="${requestScope.hrDtlList}"/>
<c:set var="comanyList" value="${requestScope.comanyList}"/>
<!DOCTYPE html>
<html lang="en">

        <head>
            <meta charset="utf-8">
            <title>HR Leads</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta name="description" content="A preview of the jQuery UI Bootstrap theme.">
            <meta name="author" content="Addy Osmani">

            <!-- Le styles -->
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
            <link href="resources/css/validate/validationEngine.jquery.css" rel="stylesheet" type="text/css">

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
        <header class="jumbotron subhead" id="overview" style="background-image: linear-gradient(-45deg, #B24926 0%, rgb(25, 102, 0) 
100%)">
            <div class="container" >
                <h1>Human Resources</h1>
                <p class="lead">Add,Edit,Search,Delete,Classify & Sort HR Profiles</p>
                <a data-toggle="modal" id="insertHRForm" href="#myModal" class="btn btn-large btn-success" style="color: white" onclick="resetData()"><i class="icon-plus-sign icon-
white"></i> Add HR Profile</a>
            </div>
        </header>


<br/>
        <div class="container">
        <!-- Docs nav ================================================== -->
        <div class="row">
        
        <div class="span12">
        <input type ="hidden" id="hdnHrDtlCnt" name="hdnHrDtlCnt" />
                 <div class="utopia-widget-content" style="display: block;">

                        <table class="table datatable table-striped table-bordered" id="tblHrDtls">


                            <thead>

                                <tr>
                                    <th></th>
                                    <th>HR Name</th>
                                    <th>Company</th>
                                    <th>Designation</th>
                                    <th>Telephone</th>
                                    <th>Mobile</th>
                                    <th>Email ID</th>
                                    <th>Fax ID</th>
                                    <th>Address</th>
                                    <th>Link</th>
                                    <th>Link</th>
                                    <th>Link</th>
                                    <th>Other Details</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${hrDtlList}" var="pcHrDtls" varStatus="rowCnt">
                                <tr id="trHrId${rowCnt.count}">
                                    <td> <input type="checkbox" name="chkHrDtlId" id="chkHrDtlId${rowCnt.count}" value="${pcHrDtls.hrDtlId}"></td> 
                                    <td><a data-toggle="modal" href="#myModal" onclick="populateHrData('${rowCnt.count}','${pcHrDtls.hrDtlId}','${pcHrDtls.hrName}','${pcHrDtls.facebookLink}','${pcHrDtls.twitterLink}','${pcHrDtls.linkedinLink}')">${pcHrDtls.hrName}</a></td>
                                        
                                        <td><input type="hidden" name="hdnCompanyId" id="hdnCompanyId${rowCnt.count}" value="${pcHrDtls.companyId}"/>${pcHrDtls.companyTitle}</td>
                                        <td>${pcHrDtls.designation}</td>
                                        <td>${pcHrDtls.hrTeleNo}</td>
                                        <td>${pcHrDtls.hrMobileNo}</td>
                                        <td class="more">${pcHrDtls.hrEmailId}</td>
                                        <td>${pcHrDtls.faxId}</td>
                                        <td>${pcHrDtls.address}</td>
                                        <td><div class="social-box-icon">
                                                <a href="#" class="zocial icon facebook">${pcHrDtls.facebookLink}</a>
                                            </div>    
                                        </td>
                                        <td><div class="social-box-icon">
                                                <a href="#" class="zocial icon twitter">${pcHrDtls.twitterLink}</a>
                                            </div>    
                                        </td>
                                        <td><div class="social-box-icon">
                                                <a href="#" class="zocial icon linkedin">${pcHrDtls.linkedinLink}</a>
                                            </div>    
                                        </td>
                                        <td class="more">${pcHrDtls.otherDtls}</td>
                                        <td align ="center">
                                            <i class="icon-trash" onclick="deleteHrDtls('N','${pcHrDtls.hrDtlId}','${rowCnt.count}')"></i> 
                                        </td>
                                    </tr>
                                    <script>
                                        var count = '${rowCnt.count}';
                                        document.getElementById("hdnHrDtlCnt").value=Number(count)+1;
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
                                    <li><a href="#" id="deleteHrDtl" onclick="deleteHrDtls('Y','')"><i class="icon-trash"></i> Delete</a></li>
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

  <div class="modal fade" id="myModal" style="display:none">
    <div class="modal-dialog" style="z-index: 901" >
      <div class="modal-content" style="z-index: 902">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Add HR Profiles</h4>
        </div>
          <form class="form-horizontal" id="insertHR">
          <div class="modal-body">
          
<fieldset>
<div class="control-group">
  <label class="control-label" for="hrName">HR Name</label>
  <div class="controls">
    <input type ="hidden" id="hrDtlId" name="hrDtlId" />
    <input type ="hidden" id="hdnRowId" name="hdnRowId" />
    <input id="hrName" name="hrName" type="text" placeholder="Enter the Name of Lead" class="validate[required,maxSize[300]] input-large" required="">
    
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="hrCompany">Select Company</label>
  <div class="controls">
    <select id="companyId" name="companyId" class="validate[required] input-large">
         <c:forEach items="${comanyList}" var="companyDtl">
              <option value="${companyDtl.id}">${companyDtl.value}</option>
         </c:forEach>
       
    </select>
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="designation">Designation</label>
  <div class="controls">
    <input id="designation" name="designation" type="text" placeholder="e.g. Manager-HR" class="validate[maxSize[150]] input-large">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="hrTeleNo">Telephone</label>
  <div class="controls">
    <input id="hrTeleNo" name="hrTeleNo" type="text" placeholder="e.g. 079-1234564" class="validate[minSize[10],maxSize[50]] input-large">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="hrMobileNo">Mobile</label>
  <div class="controls">
    <input id="hrMobileNo" name="hrMobileNo" type="text" placeholder="e.g. 9876543210" class="validate[minSize[10],maxSize[15]] input-large">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="hrEmailId">Email ID</label>
  <div class="controls">
    <input id="hrEmailId" name="hrEmailId" type="text" placeholder="e.g. jyotpatel.imnu@gmail.com" class="validate[maxSize[150],custom[email]] input-large">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="faxId">Fax ID</label>
  <div class="controls">
    <input id="faxId" name="faxId" type="text" placeholder="" class="validate[minSize[6],maxSize[150]] input-large">
    
  </div>
</div>

<!-- Textarea -->
<div class="control-group">
  <label class="control-label" for="address">Address</label>
  <div class="controls">                     
    <textarea id="address" name="address" class="validate[maxSize[250]] "></textarea>
  </div>
</div>

<!-- Textarea -->
<div class="control-group">
  <label class="control-label" for="otherDtls">Other Details</label>
  <div class="controls">                     
    <textarea id="otherDtls" name="otherDtls" class="validate[maxSize[250]]" ></textarea>
  </div>
</div>

<!-- Prepended text-->
<div class="control-group">
  <label class="control-label" for="facebookLink">Facebook Link</label>
  <div class="controls">
    <div class="input-prepend">
      <span class="add-on">www.facebook.com/</span>
      <input id="facebookLink" name="facebookLink" class="validate[maxSize[150]] input-small"  type="text">
    </div>
    
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="twitterLink">Twitter Link</label>
  <div class="controls">
    <div class="input-prepend">
      <span class="add-on">www.twitter.com/</span>
      <input id="twitterLink" name="twitterLink"  class="validate[maxSize[150]] input-small"  type="text">
    </div>
    
  </div>
</div>


<div class="control-group">
  <label class="control-label" for="linkedinLink">LinkedIn Link</label>
  <div class="controls">
    <div class="input-prepend">
      <span class="add-on">www.LinkedIn.com/</span>
      <input id="linkedinLink" name="linkedinLink"  class="validate[maxSize[150]] input-small"  type="text">
    </div>
    
  </div>
</div>

</fieldset>

        </div>
        <div class="modal-footer">
          <a href="#" class="btn btn-inverse"><i class="icon-retweet icon-white"></i> Reset</a>
          
          <a href="#" class="btn btn-primary" id="btnSaveHrDtl"><i class="icon-share-alt icon-white"></i> Save</a>
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
<script type="text/javascript" src="script/PlaceComm/editHrDtls.js"></script>

<script type="text/javascript" src="resources/js/validate/jquery.validationEngine.js"></script>
<script type="text/javascript" src="resources/js/validate/jquery.validationEngine-en.js"></script>

</body>
</html>
