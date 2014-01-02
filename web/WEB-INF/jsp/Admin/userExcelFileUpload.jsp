<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:icecore="http://www.icefaces.org/icefaces/core"
      xmlns:ace="http://www.icefaces.org/icefaces/components"
      xmlns:ice="http://www.icesoft.com/icefaces/component"
      >
  <head>
    <title>Pathshala Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- Bootstrap -->
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet"></link>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen"/>
    <link href="resources/css/bootstrap.css" rel="stylesheet" media="screen"/>
  <link href="resources/css/bootstrap-responsive.css" rel="stylesheet" media="screen"/>
  <link href="resources/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen"/>
  
  <!-- Sticky Footer Style -->
  <style type="text/css">

      /* Sticky footer styles
      -------------------------------------------------- */

      html,
      body {
        height: 100%;
        /* The html and body elements cannot have any padding or margin. */
      }

      /* Wrapper for page content to push down footer */
      #wrap {
        min-height: 100%;
        height: auto !important;
        height: 100%;
        /* Negative indent footer by it's height */
        margin: 0 auto -60px;
      }

      /* Set the fixed height of the footer here */
      #push,
      #footer {
        height: 60px;
      }
      #footer {
        background-color: #f5f5f5;
      }

      /* Lastly, apply responsive CSS fixes as necessary */
      @media (max-width: 767px) {
        #footer {
          margin-left: -20px;
          margin-right: -20px;
          padding-left: 20px;
          padding-right: 20px;
          
        }
      }



      /* Custom page CSS
      -------------------------------------------------- */
      /* Not required for template or sticky footer method. */

      .container {
        width: auto;
        max-width: 680px;
      }
      .container .credit {
        margin: 20px 0;
      }

    </style>
  
     <link rel="apple-touch-icon-precomposed"  href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-144-precomposed.png"/>
    <link rel="apple-touch-icon-precomposed"  href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-114-precomposed.png"/>
      <link rel="apple-touch-icon-precomposed"  href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-72-precomposed.png"/>
                    <link rel="apple-touch-icon-precomposed" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-57-precomposed.png"/>
                                   <link rel="shortcut icon" href="http://twitter.github.io/bootstrap/assets/ico/favicon.png"/>
  
  </head>
    <body>    
        <form id="frmExcelData" name="frmExcelData" action="userExcelFileUpload.do" method="post"   >
            <div class="control-group">
  <label class="control-label">User type :</label>
  <div class="controls">
    <label class="radio inline">
      <input type="radio" name="userType" value="S" checked="checked"/>
      Student
    </label>
  
    <label class="radio inline">
      <input type="radio" name="userType" value="A"/>
      Alumni
    </label>
      
    <label class="radio inline">
      <input type="radio" name="userType" value="F" checked="checked"/>
      Faculty
    </label>
  </div>
</div>
            <input type="file" id="myFile" name="myFile"/>
            <input type="button" id="btnsave" value="save" onclick="saveExcelData()"/>

        </form>
        <script>
            function saveExcelData()
            {
                
                var myFile = document.getElementById("myFile").value;
                
                document.forms[0].url = "http://localhost:8080/CampusLive/userExcelFileUpload.do&myFile="+myFile;
                document.forms[0].submit();
            }
            </script>
    </body>
</html>
