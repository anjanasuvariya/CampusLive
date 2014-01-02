<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="interestInvitesDtlList" value="${requestScope.interestInvitesDtlList}"/>
<c:set var="comanyList" value="${requestScope.comanyList}"/>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Interest Invite</title>
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
                <h1>Interest Invite</h1>
                <p class="lead">Invite candidate applications for recruitment</p>
                <a data-toggle="modal" href="#myModal" class="btn btn-large btn-danger" style="color: white"><i class="icon-plus-sign icon-white"></i> Float an Invite</a>
            </div>
        </header>

        <br/>
        <div class="container">
            <!-- Docs nav ================================================== -->
            <div class="row">

                <div class="span12">

                    <div class="utopia-widget-content" style="display: block;">
                        <input type ="hidden" id="hdnInvtDtlCnt" name="hdnInvtDtlCnt" />
                        <table class="table datatable table-striped table-bordered" id="tblInvtDtls">


                            <thead>

                                <tr>
                                    <td></td>
                                    <th>Title</th>
                                    <th>Description</th>
                                    <th>Deadline</th>
                                    <th>JD Document </th>
                                    <th>Other Details</th>
                                    <th>Applications</a></th>
                                    <th>Delete</a></th>
                                </tr>

                            </thead>

                            <tbody>
                                <c:forEach items="${interestInvitesDtlList}" var="pcInvtDtl" varStatus="rowCnt">
                                <tr id="trInvtId${rowCnt.count}">
                                    <td> <input type="checkbox" name="chkInvtDtlId" id="chkInvtDtlId${rowCnt.count}" value="${pcInvtDtl.invtDtlId}"></td>    
                                    <td>
                                        <a data-toggle="modal" href="#myModal" onclick="populateInvtData('${rowCnt.count}','${pcInvtDtl.invtDtlId}','${pcInvtDtl.companyId}')">${pcInvtDtl.companyTitle}</a>
                                    </td>
                                    <td>${pcInvtDtl.jobDesc}</td>
                                    <td><fmt:formatDate value="${pcInvtDtl.lastDate}" pattern="dd-MMM-yyyy" /></td>
                                    <td><a>Download</a></td>
                                    <td>${pcInvtDtl.otherDetails}</td>
                                    <td><a data-toggle="modal" href="#applicationModal" >Show</a></td>
                                    
                                    <td align ="center">
                                        <i class="icon-trash" onclick="deleteInvtDtls('N','${pcInvtDtl.invtDtlId}','${rowCnt.count}')"></i> 
                                           
                                    </td>
                                </tr>
                                    <script>
                                        var count = '${rowCnt.count}';
                                        document.getElementById("hdnInvtDtlCnt").value=Number(count)+1;
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
                                    <li><a id="deleteInvtDtl" onclick="deleteInvtDtls('Y','')"><i class="icon-trash"></i> Delete</a></li>
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
                        <h4 class="modal-title">Create Interest Invite</h4>
                    </div>
                    <form class="form-horizontal">
                        <div class="modal-body">

                            <fieldset>

                                <!-- Form Name -->


                                <!-- Text input-->
                                <div class="control-group">
                                    <label class="control-label">Title</label>
                                    <div class="controls">
                                        <input type ="hidden" id="invtDtlId" name="invtDtlId" />
                                        <input type ="hidden" id="hdnRowId" name="hdnRowId" />
                                         <select id="companyId" name="companyId" class="input-large">
                                             <option value="-1">--Select--</option>
                                            <c:forEach items="${comanyList}" var="companyDtl">
                                                <option value="${companyDtl.id}">${companyDtl.value}</option>
                                            </c:forEach>
       
                                        </select>
                                       
                                    </div>
                                </div>

                                <!-- Text input-->
                                <div class="control-group">
                                    <label class="control-label">Description</label>
                                    <div class="controls">
                                        <input id="jobDesc" name="jobDesc" type="text" placeholder="E.g. For Marketing Students Only" class="input-xlarge" required="">

                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" for="datepicker">Deadline</label>
                                    <div class="controls">
                                        <input type="date" name ="lastDate" id ="lastDate" placeholder="Last Date" class="input-xlarge" />
                                       
                                    </div>
                                </div>


                                <div class="control-group">
                                    <label class="control-label" >Job Description Document</label>
                                    <div class="controls">
                                        <input type="file" name="jobDescDoc" id="jobDescDoc"/>
                                    </div>
                                </div>
                                
                                 <div class="control-group">
                                    <label class="control-label">Other Details</label>
                                    <div class="controls">
                                        <input id="otherDetails" name="otherDetails" type="text" placeholder="e.g. Please submit your CGPA on www.goo.gl/dE4XsF" class="input-xlarge" required="">

                                    </div>
                                </div>


                            </fieldset>
                        </div>
                        <div class="modal-footer">
                            <a href="#" class="btn btn-inverse"><i class="icon-retweet icon-white"></i> Reset</a>
                            <a href="#" class="btn btn-primary" id="btnSaveInvtDtl"><i class="icon-share-alt icon-white"></i> Save</a>
                        </div>
                    </form>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <!--  --- -->

        <div class="modal fade" id="applicationModal" style="z-index: 1500; display: none">
    <div class="modal-dialog" style="z-index: 901" >
      <div class="modal-content" style="z-index: 902">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Applications Received</h4>
        </div>
        <form class="form-horizontal">
          <div class="modal-body">
          
<fieldset>
                 <div class="utopia-widget-content" style="display: block;">

                        <table class="table  table-striped table-bordered" id="msgTable">


                            <thead>

                                <tr>
                                    <th>Student Name</th>
                                    <th>Roll Number</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>

                            <tbody>
                                    <tr>
                                    
                                    <td>Jyot Patel</td>
                                    <td>121127</td>
                                    <td><a href="#"><i class="icon-remove-circle"></i><a/></td>
                                    
                                    </tr>
                                    
                                     <tr>
                                    
                                    <td>Jyot Patel</td>
                                    <td>121127</td>
                                    <td><a href="#"><i class="icon-remove-circle"></i><a/></td>
                                    
                                    </tr>
                                     <tr>
                                    
                                    <td>Jyot Patel</td>
                                    <td>121127</td>
                                    <td><a href="#"><i class="icon-remove-circle"></i><a/></td>
                                    </tr>
                                    
                                     <tr>
                                    
                                    <td>Jyot Patel</td>
                                    <td>121127</td>
                                    <td><a href="#"><i class="icon-remove-circle"></i><a/></td>
                                    
                                    </tr>
                                     <tr>
                                    
                                    <td>Jyot Patel</td>
                                    <td>121127</td>
                                    <td><a href="#"><i class="icon-remove-circle"></i><a/></td>
                                    
                                    </tr>
                                     <tr>
                                    
                                    <td>Jyot Patel</td>
                                    <td>121127</td>
                                    <td><a href="#"><i class="icon-remove-circle"></i><a/></td>
                                    
                                    </tr>
                                     <tr>
                                    
                                    <td>Jyot Patel</td>
                                    <td>121127</td>
                                    <td><a href="#"><i class="icon-remove-circle"></i><a/></td>
                                    
                                    </tr>
                                     <tr>
                                    
                                    <td>Jyot Patel</td>
                                    <td>121127</td>
                                    <td><a href="#"><i class="icon-remove-circle"></i><a/></td>
                                    
                                    </tr>
                                    
                                
                                    <tr>
                                    
                                    <td>Bhushan Zalavadia</td>
                                    <td>121118</td>
                                    <td><a href="#"><i class="icon-remove-circle"></i><a/></td>
                                    
                                    </tr>
                                    <tr>
                                    
                                    <td>Anant Kumar Vishwas</td>
                                    <td>121232</td>
                                    <td><a href="#"><i class="icon-remove-circle"></i><a/></td>
                                    
                                    </tr>
                                    

                            </tbody>

                        </table>


</fieldset>
      
            
        </div>

    
        <div class="modal-footer">
          <a href="#" class="btn btn-inverse"><i class="icon-share-alt icon-file-alt "></i>&nbsp; Download XLS</a>
          <a href="#" class="btn btn-primary"><i class="icon-share-alt icon-white"></i>Update</a>
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
<script type="text/javascript" src="script/PlaceComm/editInterestInvites.js"></script>
    </body>
</html>
