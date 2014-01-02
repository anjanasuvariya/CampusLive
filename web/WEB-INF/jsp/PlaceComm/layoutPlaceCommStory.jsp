<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<html>
    <head>
        
<title>Circle Navigation</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="resources/screen11/reset.css" type="text/css" media="all">
  <link rel="stylesheet" href="resources/screen11/layout.css" type="text/css" media="all">
  <link rel="stylesheet" href="resources/screen11/style.css" type="text/css" media="all">
  <link rel="stylesheet" href="resources/screen11/prettyPhoto.css" type="text/css" media="all">
  <script type="text/javascript" src="resources/js1/u/jquery.min.js" ></script>
  <script type="text/javascript" src="resources/screen11/mobilyblocks.js"></script>
  <script type="text/javascript" src="resources/screen11/script.js"></script>
  <script src="resources/screen11/jquery.transform-0.9.3.min.js"></script>
  <script src="resources/screen11/superfish.js"></script>
  <script type="text/javascript" src="resources/screen11/atooltip.jquery.js"></script>
  <script type="text/javascript" src="resources/screen11/pages.js"></script>
  <script type="text/javascript" src="resources/screen11/jScrollPane.js"></script>
  <script type="text/javascript" src="resources/screen11/jquery.mousewheel.js"></script>
  <script type="text/javascript" src="resources/screen11/contact-form.js"></script>
  <script type="text/javascript" src="resources/screen11/jquery.prettyPhoto.js"></script>
  

    </head>    
    <body>
        
        <!-- sidebar starts -->
     
            <tiles:insert attribute="placecomm-story" />
            <script>
$(window).load(function() {	
	$('.jspinner').hide();
	$('body').css({overflow:'inherit'});
})
</script>
    </body>
    
</html>