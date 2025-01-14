try {\n    $consumer = new Auth_OpenID_Consumer($store);\n    $auth_request = $consumer->begin($identifier);\n\n    if (!$auth_request) {\n        throw new Exception("Error beginning OpenID auth for identifier: " . htmlspecialchars($identifier));\n    }\n\n    // Continue with the normal flow...\n\n} catch (Exception $e) {\n    error_log('OpenID authentication failed: ' . $e->getMessage());\n    echo '<p>Error during OpenID authentication: ' . htmlspecialchars($e->getMessage()) . '</p>';\n}