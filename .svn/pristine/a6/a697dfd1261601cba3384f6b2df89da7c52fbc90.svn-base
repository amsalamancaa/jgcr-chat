<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <title>Login</title>
   <script src="https://apis.google.com/js/platform.js" async defer></script>
   <meta name="google-signin-client_id" content="568263429481-d4k9d8t60iv5jemgv8k5b1hp5a66gjui.apps.googleusercontent.com">
</head>
<body>
   <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
      <img id="myImg"><br>
      <p id="name"></p>
      <div id="status">
   </div>
   <script type="text/javascript">
	   function removeAccents(strAccents) {
			var strAccents = strAccents.split('');
			var strAccentsOut = new Array();
			var strAccentsLen = strAccents.length;
			var accents = 'ÀÁÂÃÄÅàáâãäåÒÓÔÕÕÖØòóôõöøÈÉÊËèéêëðÇçÐÌÍÎÏìíîïÙÚÛÜùúûüÑñŠšŸÿýŽž';
			var accentsOut = "AAAAAAaaaaaaOOOOOOOooooooEEEEeeeeeCcDIIIIiiiiUUUUuuuuNnSsYyyZz";
			for (var y = 0; y < strAccentsLen; y++) {
				if (accents.indexOf(strAccents[y]) != -1) {
					strAccentsOut[y] = accentsOut.substr(accents.indexOf(strAccents[y]), 1);
				} else
					strAccentsOut[y] = strAccents[y];
			}
			strAccentsOut = strAccentsOut.join('');
			return strAccentsOut;
		}
   
   
      function onSignIn(googleUser) {
      // window.location.href='success.jsp';
      var profile = googleUser.getBasicProfile();
      var imagurl=profile.getImageUrl();
      var name=profile.getName();
      name = removeAccents(name);
      var email=profile.getEmail();
      document.getElementById("myImg").src = imagurl;
      document.getElementById("name").innerHTML = name;
      document.getElementById("myP").style.visibility = "hidden";
      var url = 'home.xhtml?email='+email+'&image='+imagurl+'&nombre='+name;
      document.getElementById("status").innerHTML = 'Welcome '+name+'!<a href='+url+'>Continue with Google login</a></p>'
      window.location= url;
   }
   </script>
</body>
</html>