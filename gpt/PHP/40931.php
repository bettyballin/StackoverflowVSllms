<?php\n// Start the session with the passed session ID\nif (isset($_GET['session_id'])) {\n    session_id($_GET['session_id']);\n}\nsession_start();\n\n// Simulate Twitter authentication and storing information\n$twitterInfo = (object) [\n    'screen_name' => 'example_user',\n    'profile_image_url' => 'http://example.com/profile.jpg'\n];\n\n$_SESSION['screen_name'] = $twitterInfo->screen_name;\n$_SESSION['profile_image_url'] = $twitterInfo->profile_image_url;\n\n// You may close the window or redirect back to the parent window\necho "<script>window.close();</script>";\n?>