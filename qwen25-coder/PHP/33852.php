// Start a session (if not already started)\nsession_start();\n\n// Save user selected language in session\n$_SESSION['language'] = $userSelectedLanguage;\n\n// Retrieve the language preference from session\n$userPreferredLanguage = isset($_SESSION['language']) ? $_SESSION['language'] : 'default_language';