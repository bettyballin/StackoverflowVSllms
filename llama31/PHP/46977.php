require_once 'vendor/autoload.php';\n\nuse OpenID\OpenID;\n\n$openid = new OpenID('https://example.com/openid');\n\n// Set the return URL\n$openid->setReturnUrl('https://example.com/return');\n\n// Set the realm (optional)\n$openid->setRealm('https://example.com/realm');\n\n// Perform the authentication request\nif (!$openid->mode) {\n    $openid->authRequest();\n} elseif ($openid->mode == 'cancel') {\n    echo 'User cancelled authentication';\n} elseif ($openid->validate()) {\n    echo 'User authenticated successfully';\n} else {\n    echo 'Authentication failed';\n}