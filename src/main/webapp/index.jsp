
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="stylesheetlogin.css">
         <script
            src="https://code.jquery.com/jquery-3.1.1.js"
            integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
        crossorigin="anonymous"></script>
    </head>
    <body>
        
        
        <div class="container">
            
            
            
            <div class="row">
                <div class="cols-sm-12">
                    
                    <center>
                
                    <h1> CUPCAKE </h1>
                    </center>    
                
               </div>
            </div>
            <div class="row top-buffer">
                
                <div id="login" class="col-sm-4 col-sm-offset-4">
                <form action="Control" method="POST">
                    <div class="input-group">
                      <span class = "input-group-addon">Username</span>
                     <input class="form-control" type="text" name="username" /><br>
                    </div>
                    <div class="input-group top-buffer">
                      <span class = "input-group-addon">Password</span>
                      <input class="form-control" type="password" name="password" /><br>
                    </div> 
                    <center>
                    <div id="k" class="input-group">
                        <input id="submitbutton" type="submit" value="login" name="origin">
                    </div>
                    </center>
                </form>
                
                

                
            </div>
            <div class="row div-top-buffer">
            <div  class="col-sm-8 col-sm-offset-2">
                <form action="Control" method="POST">
                    
                    <div class="input-group">
                      <span class = "input-group-addon">Username</span>
                      <input class="form-control" type="text" name="username" />
                    </div> 
                    <div class="input-group top-buffer">
                      <span class = "input-group-addon">Password</span>
                      <input class="form-control" type="password" name="password" />
                    </div>
                    <div class="input-group top-buffer">
                      <span class = "input-group-addon">Monitos</span>
                      <input class="form-control" type="number" name="monitos" />
                    </div>
                    <center>
                    <div id="k" class=input-group>
                      <input type="submit" value="register" name="origin">
                    </div>
                    </center>
                </form>
                </div>
            </div>
        </div> 
    </body>
</html>