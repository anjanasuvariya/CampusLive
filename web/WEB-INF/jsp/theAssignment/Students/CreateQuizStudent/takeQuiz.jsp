<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html:html>
    
    <head>
        <title>Quiz Start</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="description" content="UI Elements: jQuery Popout Menu" />
        <meta name="keywords" content="jquery, menu, navigation, popout, slide up, slide down "/>
        <!-- The JavaScript -->
        <script type="text/javascript" src="resources/js/u/jquery.js"></script>
        <script type="text/javascript" src="resources/js/modules/quiz/submit-data.js"></script>       
        <link rel="stylesheet" href="resources/css/modules/quiz/styleAdmin.css" type="text/css" media="screen"/>
        <link href="resources/css/bootstrap.css" rel="stylesheet"/>
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet"/>
    <link href="resources/css/paginator/styles_quiz.css" rel="stylesheet" />
    
        <style>
            *{
                padding:0;
                margin:0;
            }
             body{
                background-color:#f0f0f0;
                font-family:"Helvetica Neue",Arial,Helvetica,Geneva,sans-serif;
            }
            h1{
               font-size:180px;
               line-height:180px;
               text-transform: uppercase;
               color:#ddd;
               position:absolute;
               text-shadow:0 1px 0 #fff;
               top:-25px;
               margin-top: 23px;
               white-space: nowrap;
               width: 100%;
               text-align: center;
            }
            span.reference{
                position:fixed;
                left:10px;
                bottom:10px;
                font-size:11px;
            }
            span.reference a{
                color:#666;
                text-decoration:none;
                text-transform: uppercase;
                text-shadow:0 1px 0 #fff;
            }
            span.reference a:hover{
                color:#ccc;
            }
            .m_wrapper{
                margin-top:200px;
            }
        </style>
    </head>
    <body onload="startTime()">
        
        
        <div class="navbar-wrapper">
      <!-- Wrap the .navbar in .container to center it within the absolutely positioned parent. -->
      <div class="container">

        <div class="navbar navbar-inverse navbar-fixed-top">
          <div class="navbar-inner">
            <!-- Responsive Navbar Part 1: Button for triggering responsive navbar (not covered in tutorial). Include responsive CSS to utilize. -->
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            
            <a class="brand" href="#">CampusLive</a>
            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
            <div class="nav-collapse collapse">
              <ul class="nav">
                <li class="span2"><a href="#">Select Another Quiz</a></li>
                <li class="span2"><html:link page="/GroupDiscussion.do">Review Questions</html:link></li>
                <li class="span2" ><a href="#about">Save & Quit</a></li>
                <li class="span2"><html:link page="/GroupDiscussion.do">Submit Quiz</html:link></li>
                
                
              </ul>
            <ul class="nav pull-right">
                                <li class="active">
                                    <div id="txt" class="brand" style="color: white" ></div>
                                    
                                </li>
                
                </li>
              </ul>
            </div><!--/.nav-collapse -->
          </div><!-- /.navbar-inner -->
        </div><!-- /.navbar -->

      </div> <!-- /.container -->
    </div><!-- /.navbar-wrapper -->

        <br/><br/>
        
        
          <div class="col-full">
            <div class="start">
                <br/>
                
                <div id="main">
                            <ul id="holder" style="height:200px"> 
                                <logic:iterate id="questionList" name="StudentQuizForm" property="questionList">
                                <li style="width:1113px">                
                
            <html:form styleClass="form-horizontal" action="/CreateQuizStudent.do?callmethod=insertQuestion" method="post" styleId="createQuestion" >
                    <fieldset>
                        <div class="span6">
                        <div class="control-group">
                            <textarea id="textarea"  class="col-full span11" name="qzQuestion"  rows="5" style="padding:  10px 10px 10px 10px ;"  readonly="true" >
                                <bean:write name="questionList" property="qzQuestion" />
                            </textarea></h3>
                        </div>
                        </div>
                        <br/><br/><br/><br/><br/><br/><br/><br/>
                        <div class="control-group offset1">
                        <input type= "radio" name="qzCorrectAnswer" class="validate[required] UploadCheckBox " value="1" checked="false"  > 
                        &nbsp;
                        <bean:write name="questionList" property="qzOption1" />
                        </input>
                        </div>
                        <div class="control-group offset1">
                        <input type= "radio" name="qzCorrectAnswer" class="validate[required] UploadCheckBox " value="2" checked="false"  /> 
                        &nbsp; 
                        <bean:write name="questionList" property="qzOption2" />
                            </div>
                        <div class="control-group offset1">
                         <input type= "radio" name="qzCorrectAnswer" class="validate[required] UploadCheckBox " value="3" checked="false"  /> 
                        &nbsp; 
                        <bean:write name="questionList" property="qzOption3" />
                        </div>
                        <div class="control-group offset1">
                        <input type= "radio" name="qzCorrectAnswer" class="validate[required] UploadCheckBox " value="4" checked="false"  /> 
                        &nbsp; 
                        <bean:write name="questionList" property="qzOption4" />
                        </input>    
                            
                        </div>
                        
                        <br/>
                        
                <div class="span12">
                <div class="control-group span3 ">
                <br/>
                <input type="button" class="btn jumbo offset1 previous" id="previous" value="Previous" />    
                </div>
                    
                <div class="control-group span3 ">
                <br/>
                <input type="button" class="btn jumbo offset1 saveQuit" id="saveQuit" value="Save & Quit" />    
                </div>
                
                <div class="control-group span3 ">
                <br/>
                <input type="button" class="btn jumbo offset1 Next" id="Next" value="Next" />    
                </div>    
                </div>
            
                
                        
                        
                    </fieldset>
                </html:form>
            
                </li>
                                </logic:iterate>
                                
                                
                                    
                            </ul>
                   
                </div>                
            </div>

        </div>
                
                
                
                
                
            </div><!-- end start  -->
            
     <!--           <div id="wrapper">
                        <div id="steps">
                            <form id="formElem" name="formElem" action="" method="post">
                            <fieldset class="step">
                                <legend>Create Quiz Questions</legend>
                                <p>
                                  <label for="username">Question</label>
                                  <input id="questionname" name="questionname" />
                                </p>
                                <p>
                                   <label for="option1">Option 1</label>
                                   <input id="option1" name="option1" type="text"/>
                                </p>
                                <p>
                                   <label for="option2">Option 2</label>
                                   <input id="option2" name="option2" type="text"/>
                                </p>
                                <p>
                                   <label for="option3">Option 3</label>
                                   <input id="option3" name="option3" type="text"/>
                                </p>
                                 <p>
                                   <label for="option1">Option 4</label>
                                   <input id="option4" name="option4" type="text"/>
                                </p>
                             </fieldset>
                            </form>
                        </div>
                     <div id="answeroptions">	
                      <h2>Which of these is an answer ?</h2>
                       <ul id="answermenu">
                           <li class="answerdefault" id="li1"></li>
                           <li class="answerdefault" id="li2"></li>
                           <li class="answerdefault" id="li3"></li>
                           <li class="answerdefault" id="li4"></li>
                       </ul>						
                    </div>
                </div>   -->
                 
           
              <div id="submiterrors"></div>  
                   
            <div id="navigation">
               <span id="submit">Submit</span>
                <span id="finish">Finish</span>
            </div><!-- end navigation -->  
          </div>  <!-- end col-full -->
           
           
           <div id="currentview"><!-- for loading latest question --></div>
        
        </div><!-- end ocntent -->

        
        <script src="resources/js/jquery.js"></script>
    <script src="resources/js/bootstrap-transition.js"></script>
    <script src="resources/js/bootstrap-alert.js"></script>
    <script src="resources/js/bootstrap-modal.js"></script>
    <script src="resources/js/bootstrap-dropdown.js"></script>
    <script src="resources/js/bootstrap-scrollspy.js"></script>
    <script src="resources/js/bootstrap-tab.js"></script>
    <script src="resources/js/bootstrap-tooltip.js"></script>
    <script src="resources/js/bootstrap-popover.js"></script>
    <script src="resources/js/bootstrap-button.js"></script>
    <script src="resources/js/bootstrap-collapse.js"></script>
    <script src="resources/js/bootstrap-carousel.js"></script>
    <script src="resources/js/bootstrap-typeahead.js"></script>
    <script type="text/javascript" src="resources/js/paginator/script.js"></script>
    
    <script>
var sessionTime = new Date();
sessionTime.setHours(0);
sessionTime.setMinutes(1);
sessionTime.setSeconds(0);
var counter = 0;
</script>

    <script>
function startTime()
{
var todayTime=new Date();
var seconds = "";
if(parseInt(todayTime.getSeconds()) == 0){
counter++;
seconds =  counter* 60;
} else {
if(counter == 0){
seconds = todayTime.getSeconds();
} else {
seconds =  (todayTime.getSeconds() + (counter* 60));
}
}
var remainingTime = sessionTime.getTime() - (seconds* 1000);
var displayTime=new Date(remainingTime);
var h=displayTime.getHours();
var m=displayTime.getMinutes();
var s=displayTime.getSeconds();

// add a zero in front of numbers<10
m=checkTime(m);
s=checkTime(s);
document.getElementById('txt').innerHTML=h+":"+m+":"+s;
var t=setTimeout(function(){startTime()},800);
//document.getElementById('staticTxt').innerHTML=seconds;
}

function checkTime(i)
{
if (i<10)
  {
  i="0" + i;
  }
return i;
}
</script>
    
    
    <script>
      !function ($) {
        $(function(){
          // carousel demo
          $('#myCarousel').carousel()
        })
      }(window.jQuery)
    </script>
    <script src="resourcesjs/holder/holder.js"></script>
        
    </body>
</html:html>