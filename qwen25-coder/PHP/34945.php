<?php\n\n   require 'vendor/autoload.php';\n\n   use Facebook\Facebook;\n   use Facebook\Exceptions\FacebookResponseException;\n   use Facebook\Exceptions\FacebookSDKException;\n\n   // Initialize the Facebook class with your app details\n   $fb = new Facebook([\n       'app_id' => '{app-id}',\n       'app_secret' => '{app-secret}',\n       'default_graph_version' => 'v15.0',\n       ]);\n\n   $accessToken = '{access-token}';\n\n   try {\n     // Upload video to Facebook\n     $response = $fb->post('/{user-id}/videos', [\n         'source' => $fb->fileToUpload(__DIR__ . '/path/to/your/video.mp4'),\n         'title' => 'Video Title',\n         'description' => 'This is a video description.'\n       ], $accessToken);\n\n     // Output the result\n     echo 'Video uploaded to Facebook: <a href="https://www.facebook.com/'.$response->getGraphNode()['id'].'" target="_blank">Link</a>';\n   } catch(FacebookResponseException $e) {\n     echo 'Graph returned an error: ' . $e->getMessage();\n     exit;\n   } catch(FacebookSDKException $e) {\n     echo 'Facebook SDK returned an error: ' . $e->getMessage();\n     exit;\n   }