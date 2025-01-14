<?php\n\nrequire 'vendor/autoload.php';\n\nuse League\OAuth2\Client\Provider\Exception\IdentityProviderException;\nuse League\OAuth2\Client\Provider\Google;\n\n$provider = new Google([\n    'clientId'     => '{your-client-id}',\n    'clientSecret' => '{your-client-secret}',\n    'redirectUri'  => 'https://example.com/callback',\n]);\n\nif (!isset($_GET['code'])) {\n    // If we don't have an authorization code then get one\n    $authUrl = $provider->getAuthorizationUrl();\n    $_SESSION['oauth2state'] = $provider->getState();\n    header('Location: ' . $authUrl);\n    exit;\n// Check given state against previously stored one to mitigate CSRF attack\n} elseif (empty($_GET['state']) || ($_GET['state'] !== $_SESSION['oauth2state'])) {\n    unset($_SESSION['oauth2state']);\n    exit('Invalid state');\n} else {\n    try {\n        // Try to get an access token (using the authorization code grant)\n        $accessToken = $provider->getAccessToken('authorization_code', [\n            'code' => $_GET['code']\n        ]);\n\n        // We have an access token, which we may use in authenticated\n        // requests against the service provider's API.\n        echo "Your access token is: {$accessToken->getToken()}<br>";\n        var_export($provider->getResourceOwner($accessToken));\n\n    } catch (IdentityProviderException $e) {\n        exit($e->getMessage());\n    }\n}