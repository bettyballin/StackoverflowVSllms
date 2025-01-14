<?php\nsession_start();\n\n// Function to generate unique session token on first access\nfunction generateSessionToken() {\n    if (!isset($_SESSION['token'])) {\n        $_SESSION['token'] = bin2hex(random_bytes(32));\n    }\n    return $_SESSION['token'];\n}\n\n// Check if IP is allowed and not already voted\nfunction canVote($ip) {\n    $votesFile = 'votes.txt';\n    $votedIPs = file_exists($votesFile) ? array_map('trim', file($votesFile, FILE_IGNORE_NEW_LINES)) : [];\n    \n    // Simple rate limit check (1 request per minute)\n    if (isset($_SESSION['last_request']) && time() - $_SESSION['last_request'] < 60) {\n        return false;\n    }\n    \n    $_SESSION['last_request'] = time();\n    return !in_array($ip, $votedIPs);\n}\n\n$token = generateSessionToken();\n$userIp = $_SERVER['REMOTE_ADDR'];\n\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    // Verify POST request token matches session\n    if (isset($_POST['token']) && $_POST['token'] === $token && canVote($userIp)) {\n        // Assume there's a CAPTCHA or other validation before reaching this point\n        file_put_contents('votes.txt', "$userIp\n", FILE_APPEND);\n        echo "Thank you for voting!";\n    } else {\n        echo "You have already voted or your request is invalid.";\n    }\n} else {\n    ?>\n    <form method="post" action="">\n        <input type="hidden" name="token" value="<?php echo htmlspecialchars($token); ?>">\n        <!-- Include CAPTCHA here -->\n        <button type="submit">Vote</button>\n    </form>\n<?php\n}\n?>