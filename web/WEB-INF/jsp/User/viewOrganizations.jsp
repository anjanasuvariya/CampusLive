
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Work Experience</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
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
      <script src="http://twitter.github.io/bootstrap/assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="http://twitter.github.io/bootstrap/assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="http://twitter.github.io/bootstrap/assets/ico/favicon.png">
                                   

    <script>
function myFunction(name,job)
{

                var num     = $('.clonedInput').length; // how many "duplicatable" input fields we currently have
                var newNum  = new Number(num + 1);      // the numeric ID of the new input field being added
 
                // create the new element via clone(), and manipulate it's ID using newNum value
                var newElem = $('#input' + num).clone().attr('id', 'input' + newNum);
 
                // manipulate the name/id values of the input inside the new element
                newElem.children(':first').attr('id', 'name' + newNum).attr('name', 'name' + newNum);
 
                // insert the new element after the last "duplicatable" input field
                $('#input' + num).after(newElem);
 
                // enable the "remove" button
                $('#btnDel').attr('disabled','');
 
                // business rule: you can only add 5 names
                if (newNum == 5)
                    $('#btnAdd').attr('disabled','disabled');
    
alert("Welcome " + name + ", the " + job);
}
</script>

</script>

  </head>

  <body>
      

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">CampusLive</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Welcome, <a href="#" class="navbar-link">Jyot Patel</a>
            </p>
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">Resume</a></li>
                <li><a href="#contact">GD</a></li>
                <li><a href="#contact">Activity Center</a></li>
                <li><a href="#contact">Announcements</a></li>
                <li><a href="#contact">Placements</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
            
          <div class="well sidebar-nav">
              <center><h2>Work Experience</h2>
            <img class="img-rounded" src="resources/img/Me/workex.png"/>
          
          <p>Add your Work Experience including Organization and the projects you have worked upon. Don't forget to include the role you performed in a team</p>
          <p><a class="btn" href="#">Edit</a></p> </center>
            <ul class="nav nav-list">
              <li class="nav-header">WorkEx Includes</li>
              <li><a href="#">Organization Name</a></li>
              <li><a href="#">City</a></li>
              <li><a href="#">Joining Date</a></li>
              <li><a href="#">Ending Date</a></li>
              <li><a href="#">Team Members</a></li>
              <li><a href="#">Description</a></li>
              <li><a href="#" style="color: lightcoral">Need More Help ? Click Here</a></li>
              <li><a href="#" style="color: crimson">Have an idea ? Submit Here</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          <div class="well sidebar-nav">
             
              <h4 class="offset1" style="color: #999">Good judgment comes from experience, and experience comes from bad judgment.</h4>  
              
            <ul class="nav nav-tabs offset1 span9">
                
  <li><a href="#home" data-toggle="tab">Organization</a></li>
  <li><a href="#profile" data-toggle="tab" class="offset2">Projects</a></li>
  <li><a href="#messages" data-toggle="tab" class="offset2">Recommendations</a></li>
                
</ul>
              
              
              
              <!-- Table -->
              
               <div class="row-fluid">

                <div class="span10 offset1">
                    <section class="utopia-widget">
                        <div class="utopia-widget-title">
                            <img src="resources/img/Me/paragraph_justify.png" class="utopia-widget-icon">
                            <span>Organizations</span>
                        </div>
                        <div class="control-group" ></div>
                        <div class="control-group" ></div>
                        <div class="utopia-widget-content">

                            <table class="table table-bordered">

                                <colgroup>
                                    <col class="utopia-col-0">
                                    <col class="utopia-col-1">
                                    <col class="utopia-col-0">
                                    <col class="utopia-col-1">
                                    <col class="utopia-col-0">
                                    <col class="utopia-col-1">
                                </colgroup>


                                <thead>
                                <tr>
                                    <th><input class="utopia-check-all" type="checkbox"></th>
                                    <th>Name</th>
                                    <th>Title</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                    <th>Location</th>
                                    <th>Action</th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr>
                                    <td><input class="chkbox" type="checkbox" name="checkbox[]"></td>
                                    <td>Tata Consultancy Services</td>
                                    <td>ASE</td>
                                    <td>15/07/2010</td>
                                    <td>23/06/2012</td>
                                    <td>Gandhinagar</td>
                                    <td>
                                        <a href="javascript:void(0)" class="edit"><img src="resources/img/Me/pencil.png" alt="Edit"></a>
                                        <a href="javascript:void(0)" class="delete"><img src="resources/img/Me/trash_can.png" alt="Delete"></a>
                                    </td>
                                </tr>

                                <tr>
                                    <td><input class="chkbox" type="checkbox" name="checkbox[]"></td>
                                    <td>Nirma Ltd</td>
                                    <td>Manager</td>
                                    <td>24/06/2012</td>
                                    <td>24/06/2014</td>
                                    <td>Ahmedabad</td>
                                    <td>
                                        <a href="javascript:void(0)" class="edit"><img src="resources/img/Me/pencil.png" alt="Edit"></a>
                                        <a href="javascript:void(0)" class="delete"><img src="resources/img/Me/trash_can.png" alt="Delete"></a>
                                    </td>
                                </tr>
              
              
                                </tbody>

                                <tfoot>
                                <tr>
                                    <th><input class="utopia-check-all" type="checkbox"></th>
                                    <th>Name</th>
                                    <th>Title</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                    <th>Location</th>
                                    <th>Action</th>
                                </tr>
                                </tfoot>
                            </table>
                              <div class="row-fluid">
                                <div class="span6">
                                    <div class="utopia-table-action">
                                        <div class="btn-group">
                                            <a href="#" class="btn"><i class="icon-cog"></i> Actions</a>
                                            <a href="#" data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></a>
                                            <ul class="dropdown-menu">
                                                <li><a href="#"><i class="icon-eye-open"></i> View</a></li>
                                                <li><a href="#"><i class="icon-pencil"></i> Edit</a></li>
                                                <li><a href="#"><i class="icon-trash"></i> Delete</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <div class="span6">
                                    <div class="pagination pagination-right">
                                        <ul>
                                            <li class="prev disabled"><a href="#"><</a></li>
                                            <li><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li class="active"><a href="#">3</a></li>
                                            <li><a href="#">4</a></li>
                                            <li><a href="#">5</a></li>
                                            <li class="next"><a href="#">></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </section>
                </div>
            </div>
                            
            
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              <!-- Table Ends -->
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              
              

              
              
              
    </div><!--/.fluid-container-->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="resources/js/jquery.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-transition.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-alert.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-modal.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-dropdown.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-scrollspy.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-tab.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-tooltip.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-popover.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-button.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-collapse.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-carousel.js"></script>
    <script src="http://twitter.github.io/bootstrap/assets/js/bootstrap-typeahead.js"></script>
    <script src="resources/js/u/header.js"></script>
    <script src="resources/js/u/jquery.cookie.js"></script>
    <script src="resources/js/u/jquery.datatable.js"></script>
    <script src="resources/js/u/sidebar.js"></script>
    <script src="resources/js/u/tables.js"></script>
    <script src="resources/js/u/utopia.js"></script>
    
    
  </body>
</html>
