require_once 'vendor/autoload.php';\n\nsession_start();\n\n$fb = new \Facebook\Facebook([\n  'app_id' => 'your-app-id',\n  'app_secret' => 'your-app-secret',\n  'default_graph_version' => 'v2.10',\n]);\n\n$helper = $fb->getRedirectLoginHelper();\n$permissions = ['email']; // Optional permissions\n\nif (!isset($_GET['state'])) {\n    $loginUrl = $helper->getLoginUrl('http://your-site.com/fb-callback.php', $permissions);\n    echo '<a href="' . htmlspecialchars($loginUrl) . '">Log in with Facebook!</a>';\n} else {\n    try {\n        $accessToken = $helper->getAccessToken();\n    } catch(Facebook\Exceptions\FacebookResponseException $e) {\n        // Handle error\n    } catch(Facebook\Exceptions\FacebookSDKException $e) {\n        // Handle error\n    }\n\n    if (isset($accessToken)) {\n        // Logged in!\n        $_SESSION['facebook_access_token'] = (string) $accessToken;\n        // Fetch user data\n    }\n}