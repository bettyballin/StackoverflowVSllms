// Start a new session or resume an existing one\nsession_start();\n\n// Use Secure Cookies\nini_set('session.cookie_secure', 1);\nini_set('session.cookie_httponly', 1);\n\n// Regenerate Session ID to prevent fixation\nsession_regenerate_id(true);\n\n// Store Sessions in a Custom Directory with strict permissions\n$sessionSavePath = '/path/to/custom/dir';\nif (!file_exists($sessionSavePath)) {\n    mkdir($sessionSavePath, 0755);\n}\nini_set('session.save_path', $sessionSavePath);\n\n// Set Session Cookie Path to the root of your application\n$params = session_get_cookie_params();\nsession_set_cookie_params(\n    $params["lifetime"],\n    "/",\n    $params["domain"],\n    $params["secure"],\n    $params["httponly"]\n);