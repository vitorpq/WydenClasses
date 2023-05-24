<?php
namespace Phppot;

use Phppot\Member;
if (! empty($_SESSION["userId"])) {
    require_once __DIR__ . '/../class/Member.php';
    $member = new Member();
    $memberResult = $member->getMemberById($_SESSION["userId"]);
    if (! empty($memberResult[0]["display_name"])) {
        $displayName = ucwords($memberResult[0]["display_name"]);
    } else {
        $displayName = $memberResult[0]["user_name"];
    }
}
?>
<html>
<head>
<title>User Login</title>
<link href="./view/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="phppot-container text-center">
			Welcome <b><?php echo $displayName; ?></b>, You have successfully
			logged in!<br> Click to <a href="./logout.php">Logout.</a>
	</div>
</body>
</html>