<?php\n\n   require_once __DIR__ . '/vendor/autoload.php';\n\n   if (!isset($_GET['code'])) {\n       header('Location: ' . filter_var('http://' . $_SERVER['HTTP_HOST'] . '/index.php', FILTER_SANITIZE_URL));\n       exit;\n   }\n\n   // Set up the client to use Application Default Credentials\n   $client = new \Google_Client();\n   $client->setApplicationName('Google Contacts API PHP Quickstart');\n   $client->setScopes([\Google_Service_Contacts::CONTACTS]);\n   $client->setAuthConfig(__DIR__ . '/credentials.json');\n   $client->setAccessType('offline');\n\n   // Exchange authorization code for an access token.\n   $accessToken = $client->fetchAccessTokenWithAuthCode($_GET['code']);\n\n   $client->setAccessToken($accessToken);\n\n   // Check to see if there was an error.\n   if (array_key_exists('error', $accessToken)) {\n       throw new Exception(join(', ', $accessToken));\n   }\n\n   $_SESSION['access_token'] = $accessToken;\n\n   // Send the user back to the main page\n   header('Location: ' . filter_var('http://' . $_SERVER['HTTP_HOST'] . '/index.php', FILTER_SANITIZE_URL));\n\n   ?>