// Use Google API PHP client\n  require 'vendor/autoload.php';\n  \n  $client = new Google_Client();\n  $client->setScopes(Google_Service_PeopleService::CONTACTS_READONLY);\n  $client->setAuthConfig('path/to/client_secret.json');\n  $client->setAccessType('offline');\n  \n  // Load previously authorized token from a file, if it exists.\n  $tokenPath = 'path/to/token.json';\n  if (file_exists($tokenPath)) {\n      $accessToken = json_decode(file_get_contents($tokenPath), true);\n      $client->setAccessToken($accessToken);\n  }\n  \n  $service = new Google_Service_PeopleService($client);\n  \n  // Request contact list\n  $optParams = [\n      'pageSize' => 10,\n      'personFields' => 'names,emailAddresses',\n  ];\n  $results = $service->people_connections->listPeopleConnections('people/me', $optParams);\n  \n  if (count($results->getConnections()) == 0) {\n      print "No contacts found.\n";\n  } else {\n      foreach ($results->getConnections() as $person) {\n          if (!empty($person->getNames())) {\n              $name = $person->getNames()[0]->getDisplay_name();\n              printf("Name: %s\n", $name);\n          }\n          if (!empty($person->getEmailAddresses())) {\n              $email = $person->getEmailAddresses()[0]->getValue();\n              printf("Email: %s\n", $email);\n          }\n      }\n  }