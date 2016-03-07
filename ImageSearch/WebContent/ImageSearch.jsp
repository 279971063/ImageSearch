<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ImageSearch</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>
<body>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
	function check(file,url){
			document.myform.submit();
			
		}

	 function checkUser(){
		   var result = document.getElementById("url").value;

		   if(result == "http://"  ){
		       alert("链接不能为空");
				return false;
		   }
		  $("#myform").submit();
			   
		   
		}



	
	
</script>

<div class="buttons">
	<center>
		   <form class="search" action="SearchService_upload" method="post" name="myform" enctype="multipart/form-data" id="myform">
		   	   <input type="file" name="file" onchange="check(this,'SearchService_upload')" >
	    	   <input type="text" id="url" name="url" value="http://"  onblur="if (this.value=='') this.value = 'http://'" onfocus="if (this.value=='http://') this.value = ''">
	    	   <input type="submit" value="GO" id="mysubmit" onclick="return checkUser()">
	    	   <div class="clear"></div>
   		   </form>	
	</center>


</div>	

<!-- end-buttons -->
<div class="footer">
	<p>copyright by <a href="#">anla</a></p>
</div>
</body>
</html>