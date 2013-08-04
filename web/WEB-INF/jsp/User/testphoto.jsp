<%-- 
    Document   : testphoto
    Created on : Jul 10, 2013, 8:52:39 PM
    Author     : SACHIN PATEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 
     </head>
          <body>
       <form id="form1" runat="server">
           <input type="file" id="imgInp" onchange="readImageURL(this)"/>
           <img id="userPhoto" src="#" alt="your image" height="150" width="170" style="border: #990000;border-color: red"/>
        
    </form>
       </body>
         <script>
       function readImageURL(input) {
        if (input.files && input.files[0]) {
            
            var reader = new FileReader();
            
            reader.onload = function (e) {
                document.getElementById("userPhoto").src=e.target.result;
            }
            
            reader.readAsDataURL(input.files[0]);
            
        }
    }
       
 </script>
</html>
