<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="alumniDtlList" value="${requestScope.alumniDtlList}"/>
<c:set var="comanyList" value="${requestScope.comanyList}"/>
<!DOCTYPE html>
<html lang="en">

        <head>
            <meta charset="utf-8">
            <title>Alumni Leads</title>
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
        <header class="jumbotron subhead" id="overview" style="background-image: linear-gradient(45deg, #404926 0%, rgb(255, 128, 0) 
100%)">
            <div class="container" >
                <h1>Alumni Relations</h1>
                <p class="lead">Add,Edit,Search,Delete,Classify & Sort Alumni Profiles</p>
                <a data-toggle="modal" href="#myModal" class="btn btn-large btn-inverse" style="color: white" onclick="resetData()"><i class="icon-plus-sign icon-
white"></i> Add Alumni Profile</a>
            </div>
        </header>


<br/>
        <div class="container">
        <!-- Docs nav ================================================== -->
        <div class="row">
        
        <div class="span12">
        <input type ="hidden" id="hdnAlumniDtlCnt" name="hdnAlumniDtlCnt" />
                 <div class="utopia-widget-content" style="display: block;">

                        <table class="table datatable table-striped table-bordered" id="tblAlumniDtls">


                            <thead>

                                <tr>
                                    <th></th>
                                    <th>Alumni Name</th>
                                    <th>Company</th>
                                    <th>Designation</th>
                                    <th>Batch</th>
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
                                <c:forEach items="${alumniDtlList}" var="pcAlumniDtl" varStatus="rowCnt">
                                <tr id="trAlumniId${rowCnt.count}">
                                    <td> <input type="checkbox" name="chkAlumniDtlId" id="chkAlumniDtlId${rowCnt.count}" value="${pcAlumniDtl.alumniDtlId}"></td>    
                                    <td><a data-toggle="modal" href="#myModal" onclick="populateAlumniData('${rowCnt.count}','${pcAlumniDtl.alumniDtlId}','${pcAlumniDtl.alumniName}','${pcAlumniDtl.facebookLink}','${pcAlumniDtl.twitterLink}','${pcAlumniDtl.linkedinLink}')">${pcAlumniDtl.alumniName}</a></td>
                                    <td><input type="hidden" name="hdnAlumniCompanyId" id="hdnAlumniCompanyId${rowCnt.count}" value="${pcAlumniDtl.alumniCompany}"/>${pcAlumniDtl.alumniCompany}</td>
                                    <td>${pcAlumniDtl.alumniDesignation}</td>
                                    <td class="more">${pcAlumniDtl.alumniBatch}</td>
                                    <td>${pcAlumniDtl.alumniTelephone}</td>
                                    <td>${pcAlumniDtl.alumniMobile}</td>
                                    <td class="more">${pcAlumniDtl.alumniEmail}</td>
                                    <td>${pcAlumniDtl.alumniFax}</td>
                                    <td>${pcAlumniDtl.alumniAddress}</td>
                                    <td><div class="social-box-icon">
                                                <a href="http://www.facebook.com" class="zocial icon facebook" target="_blank">${pcAlumniDtl.facebookLink}</a>
                                            </div>    
                                    </td>
                                        <td><div class="social-box-icon">
                                                <a href="http://www.twitter.com" class="zocial icon twitter" target="_blank">${pcAlumniDtl.twitterLink}</a>
                                            </div>    
                                        </td>
                                        <td><div class="social-box-icon">
                                                <a href="http://www.linkedin.com" class="zocial icon linkedin"  target="_blank">${pcAlumniDtl.linkedinLink}</a>
                                            </div>    
                                        </td>
                                        <td class="more">${pcAlumniDtl.alumniOtherDtls}</td>
                                        <td align ="center">
                                            <i class="icon-trash" onclick="deleteAlumniDtls('N','${pcAlumniDtl.alumniDtlId}','${rowCnt.count}')"></i> 
                                        </td>
                                    </tr>
                                    <script>
                                        var count = '${rowCnt.count}';
                                        document.getElementById("hdnAlumniDtlCnt").value=Number(count)+1;
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
                                    <li><a id="deleteAlumniDtl" onclick="deleteAlumniDtls('Y','')"><i class="icon-trash"></i> Delete</a></li>
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
          <h4 class="modal-title">Add Alumni Profiles</h4>
        </div>
          <form class="form-horizontal">
          <div class="modal-body">
          
<fieldset>
<div class="control-group">
  <label class="control-label" for="alumniName">Alumni Name</label>
  <div class="controls">
    <input type ="hidden" id="alumniDtlId" name="alumniDtlId" />
    <input type ="hidden" id="hdnRowId" name="hdnRowId" />
    <input id="alumniName" name="alumniName" type="text" placeholder="Enter the Name of Alumni" class="input-large" required="">
    
  </div>
</div>

<!-- Select Basic -->
<div class="control-group">
  <label class="control-label" for="alumniCompany">Select Company</label>
  <div class="controls">
    <select id="alumniCompany" name="alumniCompany" class="input-large">
         <c:forEach items="${comanyList}" var="companyDtl">
              <option value="${companyDtl.id}">${companyDtl.value}</option>
         </c:forEach>
       
    </select>
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="alumniDesignation">Designation</label>
  <div class="controls">
    <input id="alumniDesignation" name="alumniDesignation" type="text" placeholder="e.g. Manager-HR" class="input-large">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="alumniBatch">Batch</label>
  <div class="controls">
    <input id="alumniBatch" name="alumniBatch" type="text" placeholder="e.g. 2012-14" class="input-large">
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="alumniTelephone">Telephone</label>
  <div class="controls">
    <input id="alumniTelephone" name="alumniTelephone" type="text" placeholder="e.g. 079-1234564" class="input-large">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="alumniMobile">Mobile</label>
  <div class="controls">
    <input id="alumniMobile" name="alumniMobile" type="text" placeholder="e.g. 9876543210" class="input-large">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="alumniEmail">Email ID</label>
  <div class="controls">
    <input id="alumniEmail" name="alumniEmail" type="text" placeholder="e.g. jyotpatel.imnu@gmail.com" class="input-large">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="alumniFax">Fax ID</label>
  <div class="controls">
    <input id="alumniFax" name="alumniFax" type="text" placeholder="" class="input-large">
    
  </div>
</div>

<!-- Textarea -->
<div class="control-group">
  <label class="control-label" for="alumniAddress">Address</label>
  <div class="controls">                     
    <textarea id="alumniAddress" name="alumniAddress"></textarea>
  </div>
</div>

<!-- Textarea -->
<div class="control-group">
  <label class="control-label" for="alumniOtherDtls">Other Details</label>
  <div class="controls">                     
    <textarea id="alumniOtherDtls" name="alumniOtherDtls"></textarea>
  </div>
</div>

<!-- Prepended text-->
<div class="control-group">
  <label class="control-label" for="facebookLink">Facebook Link</label>
  <div class="controls">
    <div class="input-prepend">
      <span class="add-on">www.facebook.com/</span>
      <input id="facebookLink" name="facebookLink" class="input-small"  type="text">
    </div>
    
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="twitterLink">Twitter Link</label>
  <div class="controls">
    <div class="input-prepend">
      <span class="add-on">www.twitter.com/</span>
      <input id="twitterLink" name="twitterLink" class="input-small"  type="text">
    </div>
    
  </div>
</div>


<div class="control-group">
  <label class="control-label" for="linkedinLink">LinkedIn Link</label>
  <div class="controls">
    <div class="input-prepend">
      <span class="add-on">www.LinkedIn.com/</span>
      <input id="linkedinLink" name="linkedinLink" class="input-small"  type="text">
    </div>
    
  </div>
</div>

</fieldset>


            
            
        </div>
        <div class="modal-footer">
          <a href="#" class="btn btn-inverse"><i class="icon-retweet icon-white"></i> Reset</a>
          <a href="#" class="btn btn-primary" id="btnSaveAlumniDtl"><i class="icon-share-alt icon-white"></i> Save</a>
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
<script type="text/javascript" src="script/PlaceComm/editAlumniDtls.js"></script>


</body>
</html>
