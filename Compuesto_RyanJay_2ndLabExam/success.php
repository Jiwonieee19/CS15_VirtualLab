<?php
session_start();

if (!isset($_SESSION['username'])) {
    header('Location: login.php');
    exit();
}

$username = htmlspecialchars($_SESSION['username']);
$isRegistered = isset($_SESSION['registered']) ? true : false;

if ($isRegistered) {
    unset($_SESSION['registered']);
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Successful - MyApp</title>
    <link rel="stylesheet" href="success.css">
</head>
<body>
    <div class="container success-container">
        <div class="success-icon">
            <svg viewBox="0 0 24 24">
                <polyline points="20 6 9 17 4 12"></polyline>
            </svg>
        </div>
        
        <h1>Login Successful!</h1>
        
        <p class="message">
            Welcome, <span class="username"><?php echo $username; ?></span>!<br>
            You have successfully <?php echo $isRegistered ? 'registered and ' : ''; ?>logged in to your account.
        </p>
        
        <a href="login.php" class="btn">Back to Login</a>
    </div>
</body>
</html>