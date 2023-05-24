<?php
namespace Phppot;

use Phppot\DataSource;

class Member
{

    private $dbConn;

    private $ds;

    function __construct()
    {
        require_once __DIR__ . "/DataSource.php";
        $this->ds = new DataSource();
    }

    function getMemberById($memberId)
    {
        $query = "SELECT * FROM registered_users WHERE id = ?";
        $paramType = "i";
        $paramArray = array(
            $memberId
        );
        $memberResult = $this->ds->select($query, $paramType, $paramArray);

        return $memberResult;
    }

    function processLogin($username)
    {
        $query = "SELECT * FROM registered_users WHERE user_name = ?";
        $paramType = "s";
        $paramArray = array(
            $username
        );
        $memberResult = $this->ds->select($query, $paramType, $paramArray);
        return $memberResult;
    }

    function loginMember()
    {
        $memberResult = $this->processLogin($_POST["user_name"]);
        $loginPassword = 0;
        if (! empty($memberResult)) {
            $password = $_POST["password"];
            $hashedPassword = $memberResult[0]["password"];
            if (password_verify($password, $hashedPassword)) {
                $loginPassword = 1;
            }
            if ($loginPassword == 1) {
                $_SESSION["userId"] = $memberResult[0]["id"];
                return $memberResult;
            }
        }
    }
}