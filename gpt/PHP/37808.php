session_start();\n\n// Regenerate session ID upon login\nif ($user_logged_in) {\n    session_regenerate_id(true);\n}\n\n// Set cache control headers\nheader("Cache-Control: no-store, no-cache, must-revalidate, max-age=0");\nheader("Cache-Control: post-check=0, pre-check=0", false);\nheader("Pragma: no-cache");\n\n// Store user information in session\n$_SESSION['user_id'] = $user_id;\n$_SESSION['user_name'] = $user_name;\n\n// Debugging session ID\nerror_log("Session ID: " . session_id());