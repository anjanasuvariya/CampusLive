
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

       <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="http://github.com/addyosmani/jquery-ui-bootstrap">Placecomm</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li >
                                <html:link page="/loadPlaceCommHomePage.do" tabindex="-1">Home</html:link>
                            </li>
                            <li class="dropdown ">
                                <a href="/navigation.do" class="dropdown-toggle" data-toggle="dropdown">
                                    Recruiters <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    
                                    <li><html:link page="/viewCompanyDtls.do" tabindex="-1">Manage Recruiters</html:link></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Learn about Recruiters</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    HR Leads <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><html:link page="/viewHrDtls.do" tabindex="-1">Manage HRs</html:link></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Learn about HRs</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Alumni Leads <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><html:link page="/viewAlumniDtls.do" tabindex="-1">Manage Alumni</html:link></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Learn About Alumni </a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Stories <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><html:link page="/loadStoryBoardHomePage.do" tabindex="-1">Home</html:link></li>
                                <li><html:link page="/callingAndAppointment.do" tabindex="-1">Calling & Appointment</html:link></li>
                                <li><html:link page="/viewInterestInvitesDtl.do" tabindex="-1">Interest Invites</html:link></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Interview Scheduling</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Custom Stories</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Plan <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><a tabindex="-1" href="./index.html">Resource Utilization</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Performance Indicators</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    Placecomms <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                                    <li><a tabindex="-1" href="./index.html">Jyot Patel</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Arpen Vora</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Syed Shoeb</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Bhushan Zalavadia</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Saurabh Kumar</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Natali Mathew</a></li>
                                    <li><a tabindex="-1" href="theme/united/index.html">Vanditha Ravi</a></li>
                                </ul>
                            </li>
                            
                        </ul>
                        <div id="twitter-share" class="pull-right">
                            <a href="https://twitter.com/share" class="twitter-share-button" data-url="http://addyosmani.github.com/jquery-ui-bootstrap/" data-text="A new jQuery UI 
Bootstrap theme" data-via="addyosmani" data-size="large">Tweet</a>
                            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement
(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
                        </div>
                                    <div><html:link page="/logOut.do">logout</html:link></div>
                    </div>
                </div>
            </div>
        </div>