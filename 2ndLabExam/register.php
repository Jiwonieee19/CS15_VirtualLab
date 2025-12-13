<?php
session_start();
require_once 'users.php';
$errors = [];

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $fullname = trim($_POST['fullname'] ?? '');
    $email = trim($_POST['email'] ?? '');
    $username = trim($_POST['username'] ?? '');
    $password = trim($_POST['password'] ?? '');
    
    // Validation
    if (empty($fullname)) {
        $errors[] = 'Full Name is required';
    }
    
    if (empty($email)) {
        $errors[] = 'Email is required';
    } elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $errors[] = 'Invalid email format';
    }
    
    if (empty($username)) {
        $errors[] = 'Username is required';
    } elseif (strlen($username) < 3) {
        $errors[] = 'Username must be at least 3 characters';
    }
    
    if (empty($password)) {
        $errors[] = 'Password is required';
    } elseif (strlen($password) < 6) {
        $errors[] = 'Password must be at least 6 characters';
    }
    
    // If no errors, try to register
    if (empty($errors)) {
        if (registerUser($fullname, $email, $username, $password)) {
            $_SESSION['username'] = $username;
            $_SESSION['registered'] = true;
            header('Location: success.php');
            exit();
        } else {
            $errors[] = 'Username already exists. Please choose a different username.';
        }
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - MyApp</title>
    <link rel="stylesheet" href="register.css">
</head>
<body>
    <div class="container">
        <div class="logo">
            <img src="icon/logo.png" alt="MyApp Logo" class="app-logo">
            <p>Create your account to get started.</p>
        </div>
        
        <?php if (!empty($errors)): ?>
            <div class="alert alert-error">
                <ul>
                    <?php foreach ($errors as $error): ?>
                        <li><?php echo htmlspecialchars($error); ?></li>
                    <?php endforeach; ?>
                </ul>
            </div>
        <?php endif; ?>
        
        <form method="POST" action="">
            <div class="form-group">
                <label for="fullname" class="label-with-icon">
                    <img src="icon/user.png" alt="Full Name" class="label-icon"> Full Name
                </label>
                <input 
                    type="text" 
                    id="fullname" 
                    name="fullname" 
                    placeholder="Enter your full name"
                    value="<?php echo htmlspecialchars($_POST['fullname'] ?? ''); ?>"
                >
            </div>
            
            <div class="form-group">
                <label for="email" class="label-with-icon">
                    <img src="icon/at-sign.png" alt="Email" class="label-icon"> Email
                </label>
                <input 
                    type="email" 
                    id="email" 
                    name="email" 
                    placeholder="Enter your email"
                    value="<?php echo htmlspecialchars($_POST['email'] ?? ''); ?>"
                >
            </div>
            
            <div class="form-group">
                <label for="username" class="label-with-icon">
                    <img src="icon/user.png" alt="Username" class="label-icon"> Username
                </label>
                <input 
                    type="text" 
                    id="username" 
                    name="username" 
                    placeholder="Choose a username"
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
                    placeholder="Create a password"
                >
            </div>
            
            <button type="submit" class="btn">Register</button>
        </form>
        
        <div class="divider">
            <span>OR</span>
        </div>
        
        <div class="link-text">
            Already have an account? <a href="login.php">Login here</a>
        </div>
    </div>
</body>
</html>