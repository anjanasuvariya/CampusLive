<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
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
            <link href="resources/css/utopia-white.css" rel="stylesheet">
        <link href="resources/css/utopia-responsive.css" rel="stylesheet">
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
                    <tiles:put name="placecomm-header" value="/WEB-INF/jsp/tiles/placecomm_header.jsp" />
                </tiles:insert>  



        <!-- Subhead
        ================================================== -->
        <header class="jumbotron subhead" id="overview" style="background-image: linear-gradient(45deg, #B24926 0%, rgb(170, 150,200) 100%)">
            <div class="container" >
                <h1>Calling & Appointment</h1>
                <p class="lead">Manage your calling status and appointments here</p>
                <a data-toggle="modal" href="#myModal" class="btn btn-large btn-danger" style="color: white"><i class="icon-plus-sign icon-white"></i> Add Calling</a>
            </div>
        </header>

<br/>
        <div class="container">
        <!-- Docs nav ================================================== -->
        <div class="row">
        
        <div class="span12">

                 <div class="utopia-widget-content" style="display: block;">

                        <table class="table datatable table-striped table-bordered" id="gdTable">


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
                                    
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td> <input type="checkbox" name="checkboxes" value="Option one"></td>    
                                    <td>TCS Calling</td>
                                    <td>PPV Appointment and Cold Calling</td>
                                    <td><a>Download</a></td>
                                    <td>Tata Consultancy Services Pvt Ltd</td>
                                    <td>Jyot Patel</td>
                                    <td>Bhushan Zalavadia</td>
                                    <td>Work In Progress</td>
                                    <td>Done!!</td>
                                    <td>High</td>
                                    <td><a data-toggle="modal" href="#historyModal">Explore</a></td>
                                    </tr>
                                

                            </tbody>

                        </table>

                        <div class="utopia-table-action">
                            <div class="btn-group">
                                <a href="http://utopiaadmin.themio.net/dashboard.html#" class="btn"><i class="icon-cog"></i> Actions</a>
                                <a href="http://utopiaadmin.themio.net/dashboard.html#" data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="http://utopiaadmin.themio.net/dashboard.html#"><i class="icon-eye-open"></i> View</a></li>
                                    <li><a href="http://utopiaadmin.themio.net/dashboard.html#"><i class="icon-pencil"></i> Edit</a></li>
                                    <li><a href="http://utopiaadmin.themio.net/dashboard.html#"><i class="icon-trash"></i> Delete</a></li>
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
                    <tiles:put name="placecomm-footer" value="/WEB-INF/jsp/tiles/placecomm_footer.jsp" />
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
    <input id="apptTitle" name="apptTitle" type="text" placeholder="e.g. PPV Calling " class="input-xlarge" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label">Purpose</label>
  <div class="controls">
    <input id="apptPurpose" name="apptPurpose" type="text" placeholder="E.g. Cold Calling" class="input-xlarge" required="">
    
  </div>
</div>

<div class="control-group">
    <label class="control-label" >Question Document</label>
    <div class="controls">
        <input type="file" name="apptFile"/>
    </div>
</div>

<div class="control-group">
                                                <label class="control-label" for="selectbasic">Company</label>
                                                <div class="controls">
                                                    <select id="selectbasic" name="apptCompany" class="validate[required] input-xlarge">
                                                        <option disabled="true" selected="true"></option>
                                                        <option  >TCS</option>
                                                        <option >COG</option>
                                                        <option >INFY</option>
                                                        <option >CRSL</option>
                                                        <option >KMB</option>
                                                    </select>
                                                </div>
                                            </div>
 


<div class="control-group">
                                                <label class="control-label" for="selectbasic">Assigned To</label>
                                                <div class="controls">
                                                    <select id="selectbasic" name="assignedTo" class="validate[required] input-xlarge">
                                                        <option disabled="true" selected="true"></option>
                                                        <option  >Jyot Patel</option>
                                                        <option >Bhushan Zalavadia</option>
                                                        <option >Saurabh Kumar</option>
                                                        <option >Vivek Sanghvi</option>
                                                        <option >Mahesh Patel</option>
                                                    </select>
                                                </div>
                                            </div>
    

                                                
<div class="control-group">
    <label class="control-label" for="selectbasic">Status</label>
    <div class="controls">
        <select id="selectbasic" name="asstStatus" class="validate[required] input-xlarge">
            <option disabled="true" selected="true"></option>
            <option  >Open</option>
            <option >Work In Progress</option>
            <option >Closed</option>
        </select>
    </div>
</div>





<!-- Textarea -->
<div class="control-group">
  <label class="control-label">Initial Message</label>
  <div class="controls">                     
    <textarea id="contactAddress" name="apptMessage"></textarea>
  </div>
</div>


<!-- Multiple Radios -->
<div class="control-group">
  <label class="control-label">Priority</label>
  <div class="controls">
    <label class="radio">
      <input type="radio" name="companyPriority" value="Low" checked="checked">
      Low
    </label>
    <label class="radio">
      <input type="radio" name="companyPriority" value="Medium">
      Medium
    </label>
    <label class="radio">
      <input type="radio" name="companyPriority" value="High">
      High
    </label>
  </div>
</div>

</fieldset>


            
            
        </div>
        <div class="modal-footer">
          <a href="#" class="btn btn-inverse"><i class="icon-retweet icon-white"></i> Reset</a>
          <a href="#" class="btn btn-primary"><i class="icon-share-alt icon-white"></i> Save</a>
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
          <h4 class="modal-title">Discussions on : Calling TCS</h4>
        </div>
        <form class="form-horizontal">
          <div class="modal-body">
          
<fieldset>
                 <div class="utopia-widget-content" style="display: block;">

                        <table class="table  table-striped table-bordered" id="msgTable">


                            <thead>

                                <tr>
                                    <th>User</th>
                                    <th>Message</th>
                                    <th>Status</th>
                                </tr>
                            </thead>

                            <tbody>
                                    <tr>
                                    
                                    <td>Jyot Patel</td>
                                    <td>PPV Appointment and Cold Calling must be completed in this week.</td>
                                    <td>Work In Progress</td>
                                    
                                    </tr>
                                
                                    <tr>
                                    
                                    <td>Neeraj Arora</td>
                                    <td>Done!!</td>
                                    <td>Closed</td>
                                    
                                    </tr>
                                    <tr>
                                    
                                    <td>Neeraj Arora</td>
                                    <td>Done!!</td>
                                    <td>Closed</td>
                                    
                                    </tr>
                                    

                            </tbody>

                        </table>


</fieldset>


            
            
        </div>
    
    <div class="control-group">
  <label class="control-label">Message</label>
  <div class="controls">                     
    <textarea id="contactAddress" name="apptMessage"></textarea>
  </div>
</div>
        
        <div class="control-group">
    <label class="control-label" for="selectbasic">Status</label>
    <div class="controls">
        <select id="selectbasic" name="asstStatus" class="validate[required] input-large">
            <option disabled="true" selected="true"></option>
            <option  >Open</option>
            <option >Work In Progress</option>
            <option >Closed</option>
        </select>
    </div>
</div>
    
        <div class="modal-footer">
        
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

<script type="text/javascript" src="resources/js1/u/utopia.js"></script>
<script type="text/javascript" src="resources/js1/u/jquery.min.js"></script>
<script type="text/javascript" src="resources/js1/u/jquery.datatable.js"></script>
<script type="text/javascript" src="resources/js1/u/tables.js"></script>

</body>
</html>
