<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML>
<html>
<head>
<title>ImageSearch Result</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="./css/style1.css" type="text/css" media="all" />
<script src="./js/jquery-1.10.1.min.js"></script>
<script src="./js/modernizr.custom.js"></script>
<script src="./js/script.js"></script>
<link href='http://fonts.googleapis.com/css?family=Damion' rel='stylesheet' type='text/css'>
</head>
<body>
   <div class="container">	
			<header class="clearfix">
				<div class="header">
				<div class="wrap">
					 <div class="logo">
	    		 	<h1>ImgSearch</h1>
					</div>
		           <div class="header_top">
					 <div class="social-icons">						
		                <ul>
		                    <li><a class="facebook" href="#" target="_blank"> </a></li>
		                    <li><a class="twitter" href="#" target="_blank"></a></li>
		                    <li><a class="googleplus" href="#" target="_blank"></a></li>
		                    <li><a class="pinterest" href="#" target="_blank"></a></li>
		                    <li><a class="dribbble" href="#" target="_blank"></a></li>
		                    <li><a class="vimeo" href="#" target="_blank"></a></li>
		                    <div class="clear"></div>
		                </ul>
		 		     </div>	
		 		          <div class="search_box">
							    <form>
									<input type="text" class="text-box" placeholder="http://"><input type="submit" value="">
							    </form>
						   </div>
	    	</div>				
			<div class="clear"></div>
	    </div>
			</div>
			</header>
			<div class="main">
				<ul id="og-grid" class="og-grid">
						<li>
							<a href="#" data-largesrc="${requestScope.rootPicture }" data-title="原始文件" data-description="这是您的待检索的原始文件">
								<img src="${requestScope.rootPicture }" alt="带检索文件"/>
							</a>
						</li>
					<c:forEach items="${requestScope.imageInfos }" var="imgs">
						<li>
							<a href="#" data-largesrc="${imgs.url }" data-title="${imgs.score }" data-description="${imgs.title }" data-url="${imgs.homeUrl }">
								<img src="${imgs.url }" alt="${imgs.homeUrl }"/>
							</a>
							
						</li>
					</c:forEach>

				</ul>
			</div>
		</div><!-- /container -->		
		<script src="./js/grid.js"></script>
		<script>
			$(function() {
				Grid.init();
			});
		</script>
	              <div class="copy_right">
						<p>All Rights Reseverd | Design by  <a href="http://w3layouts.com">W3Layouts</a></p>
		   		</div>
          </body>
</html>
    