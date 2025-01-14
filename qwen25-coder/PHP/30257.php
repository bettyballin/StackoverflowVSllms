require_once 'vendor/autoload.php'; // Ensure the Google API client library is included\n\n$client = new Google_Client();\n$client->setClientId('YOUR_CLIENT_ID'); // Your Google Client ID\n$client->setClientSecret('YOUR_CLIENT_SECRET'); // Your Google Client Secret\n$client->redirectUri('YOUR_REDIRECT_URI'); // Your redirect URI\n$client->addScope("email");\n$client->addScope("profile");\n\nif (!isset($_GET['code'])) {\n    $auth_url = $client->createAuthUrl();\n    header('Location: ' . filter_var($auth_url, FILTER_SANITIZE_URL));\n} else {\n    $client->authenticate($_GET['code']);\n    $_SESSION['access_token'] = $client->getAccessToken();\n    header('Location: ' . filter_var('http://' . $_SERVER['HTTP_HOST'] . $_SERVER['PHP_SELF'], FILTER_SANITIZE_URL));\n}\n\nif (isset($_SESSION['access_token']) && $_SESSION['access_token']) {\n    $client->setAccessToken($_SESSION['access_token']);\n} else {\n    echo "No access token. Please log in.";\n    exit();\n}\n\n$service = new Google_Service_Oauth2($client);\n\n// Get user profile info\n$userInfo = $service->userinfo_v2_me->get();\n\n$email = filter_var($userInfo->getEmail(), FILTER_SANITIZE_EMAIL);\n$name = filter_var($userInfo->getName(), FILTER_SANITIZE_STRING);\n\necho "Email: $email";\necho "Name: $name";