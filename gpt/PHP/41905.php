require 'vendor/autoload.php';\n\n$fb = new \Facebook\Facebook([\n  'app_id' => 'your-app-id',\n  'app_secret' => 'your-app-secret',\n  'default_graph_version' => 'v2.10',\n]);\n\n$helper = $fb->getRedirectLoginHelper();\n$permissions = ['email', 'user_friends']; // Optional permissions\n\ntry {\n  if (isset($_SESSION['facebook_access_token'])) {\n    $accessToken = $_SESSION['facebook_access_token'];\n  } else {\n    $accessToken = $helper->getAccessToken();\n  }\n} catch(\Facebook\Exceptions\FacebookResponseException $e) {\n  // Handle error\n} catch(\Facebook\Exceptions\FacebookSDKException $e) {\n  // Handle error\n}\n\nif (isset($accessToken)) {\n  $_SESSION['facebook_access_token'] = (string) $accessToken;\n  $response = $fb->get('/me/friends', $accessToken);\n  $friends = $response->getGraphEdge();\n\n  foreach ($friends as $friend) {\n    // Process friends here\n  }\n}