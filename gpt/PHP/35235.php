<?php\nsession_start();\n\nrequire 'vendor/autoload.php';\n\nuse League\OAuth2\Client\Provider\GenericProvider;\n\n$provider = new GenericProvider([\n    'clientId'                => 'your-client-id',\n    'clientSecret'            => 'your-client-secret',\n    'redirectUri'             => 'http://your-php-app/callback.php',\n    'urlAuthorize'            => 'https://login.microsoftonline.com/{tenant}/oauth2/v2.0/authorize',\n    'urlAccessToken'          => 'https://login.microsoftonline.com/{tenant}/oauth2/v2.0/token',\n    'urlResourceOwnerDetails' => '',\n    'scopes'                  => 'openid profile email'\n]);\n\nif (!isset($_GET['code'])) {\n    // Redirect to the authorization URL\n    $authorizationUrl = $provider->getAuthorizationUrl();\n    $_SESSION['oauth2state'] = $provider->getState();\n    header('Location: ' . $authorizationUrl);\n    exit;\n} elseif (empty($_GET['state']) || ($_GET['state'] !== $_SESSION['oauth2state'])) {\n    // State is invalid, possible CSRF attack\n    unset($_SESSION['oauth2state']);\n    exit('Invalid state');\n} else {\n    // Try to get an access token using the authorization code grant\n    try {\n        $accessToken = $provider->getAccessToken('authorization_code', [\n            'code' => $_GET['code']\n        ]);\n\n        // Use the access token to get user details\n        $resourceOwner = $provider->getResourceOwner($accessToken);\n        $user = $resourceOwner->toArray();\n        \n        // Use $user['email'] or other user details as needed\n        echo 'Hello, ' . htmlspecialchars($user['email']);\n    } catch (Exception $e) {\n        exit('Failed to get access token: ' . $e->getMessage());\n    }\n}\n?>