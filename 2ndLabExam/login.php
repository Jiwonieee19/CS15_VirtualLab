<?php
session_start();
require_once 'users.php';
$error = '';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $username = trim($_POST['username'] ?? '');
    $password = trim($_POST['password'] ?? '');
    
    // Basic validation
    if (empty($username)) {
        $error = 'Username is required';
    } elseif (empty($password)) {
        $error = 'Password is required';
    } else {
        // Authenticate user
        if (authenticateUser($username, $password)) {
            // User is registered and password is correct
            $_SESSION['username'] = $username;
            header('Location: success.php');
            exit();
        } else {
            $error = 'Invalid username or password. Please register first if you don\'t have an account.';
        }
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - MyApp</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
    <div class="container">
        <div class="logo">
            <img src="icon/logo.png" alt="MyApp Logo" class="app-logo">
            <p>Welcome back! Please login to your account.</p>
        </div>
        
        <?php if ($error): ?>
            <div class="alert alert-error">
                <?php echo htmlspecialchars($error); ?>
            </div>
        <?php endif; ?>
        
        <form method="POST" action="">
            <div class="form-group">
                <label for="username" class="label-with-icon">
                    <img src="icon/user.png" alt="User" class="label-icon"> Username
                </label>
                <input 
                    type="text" 
                    id="username" 
                    name="username" 
                    placeholder="Enter your username"
                    value="<?php echo htmlspecialchars($_POST['username'] ?? ''); ?>"
                >
            </div>
            
            <div class="form-group">
                <label for="password" class="label-with-icon">
                    <img src="icon/lock.png" alt="Password" class="label-icon"> Password
                </label>
                <input 
                    type="password" 
                    id="password" 
                    name="password" 
                    placeholder="Enter your password"
                >
            </div>
            
            <button type="submit" class="btn">Login</button>
        </form>
        
        <div class="divider">
            <span>OR</span>
        </div>
        
        <div class="link-text">
            Don't have an account? <a href="register.php">Register here</a>
        </div>
    </div>
</body>
</html>