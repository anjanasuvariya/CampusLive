<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="appntDtlList" value="${requestScope.appntDtlList}"/>
<c:set var="comanyList" value="${requestScope.comanyList}"/>
<c:set var="placeCommMemList" value="${requestScope.placeCommMemList}"/>
<c:set var="appointmentHst" value="${requestScope.appointmentHst}"/>
<c:set var="loggedInUserId" value="${sessionScope.cmnUserMst.userId}"/>


<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Calling & Appointment</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A preview of the jQuery UI Bootstrap theme.">
        <meta name="author" content="Addy Osmani">

        <!-- Le styles -->
        <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/custom-theme/jquery-ui-1.10.3.custom.css">
        <link rel="stylesheet" href="resources/assets/css/font-awesome.min.css">
        <link href="resources/css/validate/validationEngine.jquery.css" rel="stylesheet" type="text/css">
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
                <h1>Calling & Appointment</h1>
                <p class="lead">Manage your calling status and appointments here</p>
                <a data-toggle="modal" href="#myModal" id="insertCalling" class="btn btn-large btn-danger" style="color: white"  onclick="resetData()"><i class="icon-plus-sign icon-white"></i> Add Calling</a>
            </div>
        </header>

        <br/>
        <div class="container">
            <!-- Docs nav ================================================== -->
            <div class="row">

                <div class="span12">
                    <input type ="hidden" id="hdnAppntDtlCnt" name="hdnAppntDtlCnt" />
                    <div class="utopia-widget-content" style="display: block;">

                        <table class="table datatable table-striped table-bordered" id="tblApptDtl">


                            <thead>

                                <tr>
                                    <td></td>
                                    <th>Appointment Title</th>
                                    <th>Purpose</th>
                                    <th>Documents</th>
                                    <th>Company</th>
                                    <th>Owner</th>
                                    <th>Assigned To</th>
                                    <th>Status</th>
                                    <th>Latest Update</th>
                                    <th>Priority</th>
                                    <th>History</th>
                                    <th>Delete</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${appntDtlList}" var="pcAppntDtl" varStatus="rowCnt">
                                    <tr id="trAppntId${rowCnt.count}">
                                        <td> <input type="checkbox" name="chkAppntDtlId" id="chkAppntDtlId${rowCnt.count}" value="${pcAppntDtl.appntDtlId}"></td>    
                                        <td>
                                            <c:choose>
                                                <c:when test="${loggedInUserId eq pcAppntDtl.ownerId}">
                                                    <a data-toggle="modal" href="#myModal" onclick="populateAppntData('${rowCnt.count}','${pcAppntDtl.appntDtlId}','${pcAppntDtl.appntTitle}')">${pcAppntDtl.appntTitle}</a>
                                                </c:when>
                                                <c:otherwise>
                                                    ${pcAppntDtl.appntTitle}
                                                </c:otherwise>
                                            </c:choose>

                                        </td>
                                        <td>${pcAppntDtl.appntPurpose}</td>
                                        <td><a>Download</a></td>
                                        <td class="more"><input type="hidden" name="hdnAppntCompanyId" id="hdnAppntCompanyId${rowCnt.count}" value="${pcAppntDtl.appntCompanyId}"/>${pcAppntDtl.appntCompanyName}</td>
                                        <td>${pcAppntDtl.ownerName}</td>
                                        <td><input type="hidden" name="hdnAssignedUserId" id="hdnAssignedUserId${rowCnt.count}" value="${pcAppntDtl.assignedUserId}"/>${pcAppntDtl.assignedUserName}</td>
                                        <td>${pcAppntDtl.appntStatus}</td>
                                        <td>${pcAppntDtl.lastUpdatedMsg}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${pcAppntDtl.appntPriority == 'M'}">
                                                    Medium
                                                </c:when>
                                                <c:when test="${pcAppntDtl.appntPriority == 'H'}">
                                                    High
                                                </c:when>
                                                <c:otherwise>
                                                    Low    
                                                </c:otherwise>
                                            </c:choose>

                                        </td>
                                        <td><a data-toggle="modal" href="#historyModal" onclick="viewAppntHistory('${pcAppntDtl.appntDtlId}','${pcAppntDtl.appntTitle}','${rowCnt.count}')">Explore</a></td>
                                        <td align ="center">
                                            <c:choose>
                                                <c:when test="${loggedInUserId eq pcAppntDtl.ownerId}">
                                                    <i class="icon-trash" onclick="deleteAppntDtls('N','${pcAppntDtl.appntDtlId}','${rowCnt.count}')"></i> 
                                                </c:when>
                                                <c:otherwise>
                                                    -
                                                </c:otherwise>
                                            </c:choose>

                                        </td>
                                    </tr>
                                <script>
                                        var count = '${rowCnt.count}';
                                        document.getElementById("hdnAppntDtlCnt").value=Number(count)+1;
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
                                    <li><a id="deleteAppntDtl" onclick="deleteAppntDtls('Y','')"><i class="icon-trash"></i> Delete</a></li>

                                </ul>
                            </div>
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
                    <h4 class="modal-title">Add Calling / Appointment</h4>
                </div>
                <form class="form-horizontal" enctype="multipart/form-data" id="insertAppt" >
                    <div class="modal-body">

                        <fieldset>

                            <!-- Form Name -->


                            <!-- Text input-->
                            <div class="control-group">
                                <label class="control-label">Title</label>
                                <div class="controls">
                                    <input type ="hidden" id="appntDtlId" name="appntDtlId" />
                                    <input type ="hidden" id="hdnRowId" name="hdnRowId" />
                                    <input id="appntTitle" name="appntTitle" type="text" class="validate[required,maxSize[200]]" placeholder="e.g. PPV Calling " class="input-xlarge" required="">

                                </div>
                            </div>

                            <!-- Text input-->
                            <div class="control-group">
                                <label class="control-label">Purpose</label>
                                <div class="controls">
                                    <input id="appntPurpose" name="appntPurpose" type="text" class="validate[required,maxSize[200]]" placeholder="E.g. Cold Calling" class="input-xlarge" required="">

                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" >Calling Doc</label>
                                <div class="controls">
                                    <input type="file" name="uploadFile" id="uploadFile" />
                                </div>
                            </div>

                            <div class="control-group">
                                <label class="control-label" for="appntCompany">Company</label>
                                <div class="controls">
                                    <select id="appntCompany" name="appntCompany" class="validate[required] input-xlarge">
                                        <option disabled="true" selected="true"></option>
                                        <c:forEach items="${comanyList}" var="companyDtl">
                                            <option value="${companyDtl.id}">${companyDtl.value}</option>
                                        </c:forEach>

                                    </select>
                                </div>
                            </div>



                            <div class="control-group">
                                <label class="control-label" for="assignedTo">Assigned To</label>
                                <div class="controls">
                                    <select id="assignedTo" name="assignedTo" class="validate[required] input-xlarge">
                                        <option disabled="true" selected="true"></option>
                                        <c:forEach items="${placeCommMemList}" var="placeCommMemDtl">
                                            <option value="${placeCommMemDtl.id}">${placeCommMemDtl.value}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>



                            <div class="control-group">
                                <label class="control-label" for="appntStatus">Status</label>
                                <div class="controls">
                                    <select id="appntStatus" name="appntStatus" class="validate[required] input-xlarge">
                                        <option disabled="true" selected="true"></option>
                                        <option  >Open</option>
                                        <option >Work In Progress</option>
                                        <option >Closed</option>
                                    </select>
                                </div>
                            </div>





                            <!-- Textarea -->
                            <div class="control-group">
                                <label class="control-label" >Initial Message</label>
                                <div class="controls">                     
                                    <textarea id="appntMessage" class="validate[required,maxSize[300]]" name="appntMessage"></textarea>
                                </div>
                            </div>


                            <!-- Multiple Radios -->
                            <div class="control-group">
                                <label class="control-label">Priority</label>
                                <div class="controls">
                                    <label class="radio">
                                        <input type="radio" name="appntPriority" id ="appntPriorityL" value="L" checked="checked">
                                        Low
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="appntPriority" id ="appntPriorityM" value="M">
                                        Medium
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="appntPriority" id ="appntPriorityH" value="H">
                                        High
                                    </label>
                                </div>
                            </div>

                        </fieldset>




                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-inverse" onclick=""><i class="icon-retweet icon-white"></i> Reset</a>

                        <a href="#" class="btn btn-primary" id="btnSaveAppntDtl" ><i class="icon-share-alt icon-white"></i> Save</a>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div class="modal fade" id="historyModal" style="z-index: 1500; display: none">
        <div class="modal-dialog" style="z-index: 901" >
            <div class="modal-content" style="z-index: 902">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="hdDisscussionTopic">Discussions on : Calling TCS</h4>
                </div>
                <form class="form-horizontal"  id="insertApptHst" >
                    <div class="modal-body">

                        <fieldset>
                            <div class="utopia-widget-content" style="display: block;">
                                <input type ="hidden" id="hdnLoggedInUserName" name="hdnLoggedInUserName" value="${sessionScope.userName}" />
                                <input type ="hidden" id="hdnAppntDtlId" name="hdnAppntDtlId" />
                                <table class="table  table-striped table-bordered" id="tblAppntHst">


                                    <thead>

                                        <tr>
                                            <th>User</th>
                                            <th>Message</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                    </tbody>

                                </table>


                        </fieldset>




                    </div>

                    <div class="control-group">
                        <label class="control-label">Message</label>
                        <div class="controls">                     
                            <textarea id="apptMessage" name="apptMessage"></textarea>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="selectbasic">Status</label>
                        <div class="controls">
                            <select id="apptStatus" name="apptStatus" class="validate[required] input-large">
                                <option disabled="true" selected="true"></option>
                                <option  >Open</option>
                                <option >Work In Progress</option>
                                <option >Closed</option>
                            </select>
                        </div>
                    </div>

                    <div class="modal-footer">

                        <a href="#" class="btn btn-primary" onclick="saveAppntHistory()" id="insertApptHstLink"><i class="icon-share-alt icon-white"></i>Update</a>
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
    <script type="text/javascript" src="resources/js/validate/jquery.validationEngine.js"></script>
    <script type="text/javascript" src="resources/js/validate/jquery.validationEngine-en.js"></script>

    <script type="text/javascript" src="resources/js/u/utopia.js"></script>
    <script type="text/javascript" src="resources/js/u/jquery.min.js"></script>
    <script type="text/javascript" src="resources/js/u/jquery.datatable.js"></script>
    <script type="text/javascript" src="resources/js/u/tables.js"></script>
    <script type="text/javascript" src="resources/js/jquery/jquery.form.min.js"></script>

    <script type="text/javascript" src="resources/js/noty/jquery.noty.js"></script>
    <script type="text/javascript" src="resources/js/noty/layouts/top.js"></script>
    <script type="text/javascript" src="resources/js/noty/layouts/topLeft.js"></script>
    <script type="text/javascript" src="resources/js/noty/layouts/topRight.js"></script>
    <script type="text/javascript" src="resources/js/noty/themes/default.js"></script>
    <script type="text/javascript" src="script/PlaceComm/callingAndAppointment.js"></script>
</body>
</html>
