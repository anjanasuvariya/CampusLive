<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>




<c:set var="userPersonalDtl" value="${requestScope.userPersonalDtl}"/>
<c:set var="cmnUserMst" value="${sessionScope.cmnUserMst}"/>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Bootstrap, from Twitter</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Le styles -->
        <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">  
        <!-- <link href="resources/css/bootstrap.css" rel="stylesheet"> -->
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
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-57-precomposed.png">
        <link rel="shortcut icon" href="http://twitter.github.io/bootstrap/assets/ico/favicon.png">
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
                        <center><h2>Personal Info</h2>
                            <img class="img-rounded" src="resources/img/User/personalinfo.png"/>
                            <br/><br/>
                            <p>Check your current details on the right and Update if it's not correct.</p>
                           _________________________
                           <br/><br/>
                        <ul class="nav nav-list">
                            <li class="nav-header active">Personal Details Include</li>
                            <li ><a href="#">Person Name</a></li>
                            <li><a href="#">Image</a></li>
                            <li><a href="#">Date of Birth</a></li>
                            <li><a href="#">Gender</a></li>
                            <li><a href="#">Interests</a></li>
                            <li><a href="#">Known Languages</a></li>
                            <li><a href="#">Current City</a></li>
                            <li><a href="#">Social Media Links</a></li>
                            
                        </ul>
                    </div><!--/.well -->
                </div><!--/span-->
                <div class="span9">
                    <div class="well sidebar-nav">
                        <html:errors/>            

                        <form class="form-horizontal" action="saveUserPersonalDtl.do" method="post" enctype="multipart/form-data"  runat="server">
                            <fieldset>

                                <!-- Form Name -->

                                <!-- Text input-->
                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label">Name</label>
                                        <div class="controls">
                                            <input type="hidden" id="personalDtlId" name="personalDtlId" value="${userPersonalDtl.personalDtlId}"/>
                                            <input type="hidden" id="createdUserId" name="createdUserId" value="${userPersonalDtl.createdUserId}"/>
                                            <input type="hidden" id="createdDate" name="createdDate" value="${userPersonalDtl.createdDate}"/>
                                            <input type="hidden" id="universityId" name="universityId" value="${userPersonalDtl.universityId}"/>
                                            <input type="text" class="input-text" Placeholder="First Name" id="userFirstName" name="userFirstName" style="width: 11%;" value="${cmnUserMst.userFirstName}" /> 
                                            <input type="text" class="input-text" Placeholder="Middle Name" id="userMiddleName" name="userMiddleName" style="width: 11%;" value="${cmnUserMst.userMiddleName}"/> 
                                            <input type="text" class="input-text" Placeholder="Last Name" id="userLastName" name="userLastName" style="width: 11%;" value="${cmnUserMst.userLastName}"/><br/>
                                        </div>
                                    </div>
                                </div>


                                <!-- File Button --> 
                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label">Image</label>
                                        <div class="controls">
                                            <input type="file" id="file" class="input-file" onchange="readImageURL(this)"/>

                                            <br/>
                                            <img id="photoImage" data-src="holder.js/140x140" alt="your image" height="150" width="160"  class="img-square"/>

                                        </div>
                                    </div>
                                </div>

                                <!-- Text input-->
                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label">Date Of Birth</label>
                                        <div class="controls">
                                            <input type="date" name ="dateOfBirth" placeholder="When were you born? (dd/mm/yyyy)" class="input-xlarge" value="${userPersonalDtl.dateOfBirth}"/>

                                        </div></div>
                                </div>

                                <!-- Multiple Radios -->
                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label">Gender</label>
                                        <div class="controls">
                                            <label class="radio">
                                                <input type="radio" name="gender" value="M" checked="checked">
                                                Male
                                            </label>
                                            <label class="radio">
                                                <input type="radio" name="gender" value="F">
                                                Female
                                            </label>
                                        </div></div>
                                </div>

                                <!-- Prepended text-->
                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label">Primary Language</label>
                                        <div class="controls">
                                            <div class="input-prepend">
                                                <span class="add-on">Mother Tounge</span>
                                                <input id="language1" name="primaryLangauge" class="span2" placeholder="Mostly Spoken" type="text" value="${userPersonalDtl.primaryLangauge}">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Prepended text-->
                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label">Secondary Language</label>
                                        <div class="controls">
                                            <div class="input-prepend">
                                                <span class="add-on">Language</span>
                                                <input id="language2" name="secondaryLanguage" class="span2" placeholder="" type="text"  value="${userPersonalDtl.secondaryLanguage}">
                                            </div>
                                            
                                        </div>
                                    </div></div>

                                <!-- Textarea -->
                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label">Interests</label>
                                        <div class="controls">                     
                                            <textarea id="interest" name="interests" placeholder="Enter Your Multiple Interests Here">${userPersonalDtl.interests}</textarea>
                                        </div></div>
                                </div>

                                <!-- Text input-->
                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label">Current City</label>
                                        <div class="controls">
                                            <input id="currentCity" name="currentCity" type="text" placeholder="Where are you right now?" class="input-xlarge" value="${userPersonalDtl.currentCity}">
                                        </div>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label">Facebook Link</label>
                                        <div class="controls">
                                            <div class="input-prepend">
                                                <span class="add-on">www.facebook.com/</span>
                                                <input id="facebookLink" name="facebookLink" class="input-small"  type="text" value="${userPersonalDtl.facebookLink}">
                                            </div></div>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label" for="twitterLink">Twitter Link</label>
                                        <div class="controls">
                                            <div class="input-prepend">
                                                <span class="add-on">www.twitter.com/</span>
                                                <input id="twitterLink" name="twitterLink" class="input-small"  type="text" value="${userPersonalDtl.twitterLink}">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="row row-fluid offset1">
                                        <label class="control-label">LinkedIn Link</label>
                                        <div class="controls">
                                            <div class="input-prepend">
                                                <span class="add-on">www.LinkedIn.com/</span>
                                                <input id="linkedInLink" name="linkedInLink" class="input-small"  type="text" value="${userPersonalDtl.linkedInLink}">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="row row-fluid offset1"> 
                                        <div class="controls">
                                            <button class="btn btn-large btn-success" type="submit">Save / Update</button>

                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            <script>
                                function readImageURL(input) {
                                    if (input.files && input.files[0]) {
                                        alert("path of file = "+document.getElementById("file").value);
                                        var reader = new FileReader();
            
                                        reader.onload = function (e) {
                                            document.getElementById("photoImage").src=e.target.result;
                                        }
            
                                        reader.readAsDataURL(input.files[0]);
            
                                    }
                                }
                            </script>
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
                <script src="resources/js/holder.js"></script>

                <script src="resources/assets/js/bootstrap.min.js"></script>


                <script>
                    $(document).ready(function(){
                        $('.dropdown-toggle').dropdown()
                    });
                </script>

                </body>
                </html>
