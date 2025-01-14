<?php\nsession_start();\n\nfunction is_under_attack($ip) {\n    $file = 'attack_logs/' . $ip;\n    // Check if the file exists and has more than X attempts within Y time frame\n    if (file_exists($file)) {\n        $attempts = explode(',', file_get_contents($file));\n        $filtered_attempts = array_filter($attempts, function($time) {\n            return time() - intval($time) < 300; // 5 min window\n        });\n        \n        return count($filtered_attempts) > 5; // More than 5 attempts in last 5 minutes\n    }\n    return false;\n}\n\nfunction log_failed_attempt($ip) {\n    $file = 'attack_logs/' . $ip;\n    $time = time();\n    \n    if (file_exists($file)) {\n        file_put_contents($file, file_get_contents($file) . ",$time");\n    } else {\n        file_put_contents($file, $time);\n    }\n}\n\nif ($_SERVER['REQUEST_METHOD'] == "POST") {\n    $username = $_POST['username'];\n    $password = $_POST['password'];\n    \n    // Simple authentication logic (replace with your own)\n    if (!authenticate_user($username, $password)) {\n        log_failed_attempt($_SERVER['REMOTE_ADDR']); // Log failed attempt by IP\n        \n        // Check session for failed attempts\n        if (!isset($_SESSION['failed_attempts'])) {\n            $_SESSION['failed_attempts'] = 0;\n        }\n        \n        $_SESSION['failed_attempts']++;\n        \n        if ($_SESSION['failed_attempts'] >= 5 || is_under_attack($_SERVER['REMOTE_ADDR'])) {\n            // Show CAPTCHA\n            require 'captcha.php'; // Handle your captcha logic here\n        } else {\n            echo "Login failed. Please try again.";\n        }\n    } else {\n        $_SESSION['failed_attempts'] = 0; // Reset on successful login\n        echo "Welcome!";\n    }\n}\n?>