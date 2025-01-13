require_once 'vendor/autoload.php';\n\n$client = new Google_Client();\n$client->setAuthConfig('path/to/client_credentials.json');\n$client->addScope(Google_Service_PeopleService::CONTACTS_READONLY);\n\nif (!isset($_GET['code'])) {\n    $auth_url = $client->createAuthUrl();\n    header('Location: ' . filter_var($auth_url, FILTER_SANITIZE_URL));\n} else {\n    $client->authenticate($_GET['code']);\n    $_SESSION['access_token'] = $client->getAccessToken();\n    $service = new Google_Service_PeopleService($client);\n    $results = $service->people_connections->listPeopleConnections('people/me', array('personFields' => 'names,emailAddresses'));\n\n    foreach ($results->getConnections() as $person) {\n        // Process contacts here\n    }\n}