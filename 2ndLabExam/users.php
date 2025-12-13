<?php
if (!isset($_SESSION)) {
    session_start();
}

if (!isset($_SESSION['registered_users'])) {
    $_SESSION['registered_users'] = [];
}

function registerUser($fullname, $email, $username, $password) {
    foreach ($_SESSION['registered_users'] as $user) {
        if ($user['username'] === $username) {
            return false;
        }
    }

    $_SESSION['registered_users'][] = [
        'fullname' => $fullname,
        'email' => $email,
        'username' => $username,
        'password' => password_hash($password, PASSWORD_DEFAULT)
    ];

    return true;
}

function authenticateUser($username, $password) {
    foreach ($_SESSION['registered_users'] as $user) {
        if ($user['username'] === $username) {
            return password_verify($password, $user['password']);
        }
    }
    return false;
}

function userExists($username) {
    foreach ($_SESSION['registered_users'] as $user) {
        if ($user['username'] === $username) {
            return true;
        }
    }
    return false;
}
?>
