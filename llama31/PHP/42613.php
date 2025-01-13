$helper = $fb->getRedirectLoginHelper();\n\ntry {\n  $accessToken = $helper->getAccessToken();\n} catch (Facebook\Exceptions\FacebookResponseException $e) {\n  // When Graph returns an error\n  echo 'Graph returned an error: ' . $e->getMessage();\n  exit;\n} catch (Facebook\Exceptions\FacebookSDKException $e) {\n  // When validation fails or other local issues\n  echo 'Facebook SDK returned an error: ' . $e->getMessage();\n  exit;\n}\n\nif (isset($accessToken)) {\n  // User is logged in, retrieve profile information\n  $response = $fb->get('/me?fields=id,name,picture', $accessToken);\n  $user = $response->getGraphUser();\n  echo 'User ID: ' . $user['id'];\n  echo 'Name: ' . $user['name'];\n  echo 'Profile Picture: ' . $user['picture']['url'];\n}