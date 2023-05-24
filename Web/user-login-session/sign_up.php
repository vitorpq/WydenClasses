<html>
<head>
<title>User Login</title>
<meta name="viewport" content="width=device-width , initial-scale=1">
<link rel="stylesheet" type="text/css" href="./view/css/form.css" />
<link rel="stylesheet" type="text/css" href="./view/css/style.css" />
</head>
<body>
	<div class="phppot-container tile-container text-center">
     <?php
    if (isset($_SESSION["errorMessage"])) {
        ?>
                <div class="validation-message"><?php  echo $_SESSION["errorMessage"]; ?></div>
                <?php
        unset($_SESSION["errorMessage"]);
    }
    ?>
        <form action="create_user.php" method="post" id="frmLogin"
			onSubmit="return validate();">
			<h2>Enter Login Details</h2>
			<div class="row">
				<label class="text-left" for="username">Username 
					<span id="user_info" class="validation-message"></span></label> 
					<input name="user_name" id="user_name" type="text" class="full-width">
			</div>
			<div class="row">
				<label class="text-left" for="email">Email <span
					id="email_info" class="validation-message"></span></label> <input
					name="email" id="email" type="email" class="full-width">
			</div>
			<div class="row">
				<label class="text-left" for="password1">Password 1 <span
					id="password1_info" class="validation-message"></span></label> <input
					name="password1" id="password1" type="password" class="full-width">
			</div>
			<div class="row">
				<label class="text-left" for="password2">Password 2 <span
					id="password2_info" class="validation-message"></span></label> <input
					name="password2" id="password2" type="password" class="full-width">
			</div>
			<div class="row">
				<input type="submit" name="login" value="Login" class="full-width"></span>
			</div>
		</form>
	</div>
	<script>
    function validate() {
        var $valid = true;
        document.getElementById("user_info").innerHTML = "";
        document.getElementById("password1_info").innerHTML = "";
        document.getElementById("email_info").innerHTML = "";
        document.getElementById("password2_info").innerHTML = "";
        
        var userName = document.getElementById("user_name").value;
        var email = document.getElementById("email").value;
        var password1 = document.getElementById("password1").value;
        var password2 = document.getElementById("password2").value;
        if(userName == "") 
        {
            document.getElementById("user_info").innerHTML = "required";
        	$valid = false;
        }
        if(email == "") 
        {
            document.getElementById("email_info").innerHTML = "required";
        	$valid = false;
        }
        if(password1 == "") 
        {
        	document.getElementById("password1_info").innerHTML = "required";
            $valid = false;
        }
        if(password2 == "") 
        {
        	document.getElementById("password2_info").innerHTML = "required";
            $valid = false;
        }
        return $valid;
    }
    </script>
</body>
</html>
