<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

    
    
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>

   
    <!-- NAVBAR
    ================================================== -->
    <div class="navbar-wrapper">
      <!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
      <div class="container">

      <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">&nbsp; Placecom </a>
            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
            <div class="nav-collapse collapse">
              <ul class="nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">Resume</a></li>
                <li><html:link page="/GroupDiscussion.do">GD</html:link></li>
                <li><html:link page="/theAssignmentStudent.do">the asSignment</html:link></li>
                <li><html:link page="/theAssignment.do">Faculty</html:link></li>
                <li><html:link page="/loadPlaceCommHomePage.do">Placements</html:link></li>
                <!-- Read about Bootstrap dropdowns at http://twitter.github.com/bootstrap/javascript.html#dropdowns -->
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Settings<b class="caret"></b></a>
                  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                     <li><html:link action="/viewUserPersonalinfo.do" >Personal Info</html:link></li>
                      <li><html:link action="/viewUserContactDtls.do" >Contact Info</html:link></li>
                      <li><html:link action="/viewUserEducationDtls.do" >Education</html:link></li>
                      <li><html:link action="/editWorKExperience.do" > Work Experience</html:link></li>
                      <li><html:link action="/viewUserAchievementDtls.do" >Achievements</html:link></li>
                      <li><html:link action="/editAccountDtl.do" >Account Details</html:link></li>

                      <li class="divider"></li>
                      <li class="nav-header">Nav header</li>
                      <li><a href="#">Separated link</a></li>
                      <li><a href="#">One more separated link</a></li> 
                  </ul>
                </li>
                <li><html:link page="/studentInterestInvites.do">Student interest invite</html:link></li>
                <li><html:link page="/logOut.do">logout</html:link></li>
              </ul>
                <ul class="nav pull-right">
                    <li class="active"><a href="#">Welcome, ${sessionScope.userName}</a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->

      </div> <!-- /.container -->
    </div><!-- /.navbar-wrapper -->



   