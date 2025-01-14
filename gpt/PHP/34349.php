<?php\n// Start the session\nsession_start();\n\n// Check if cookies are disabled\nif (ini_get("session.use_cookies") == 0) {\n    // Use URL-based session management\n    if (!empty(session_id())) {\n        // Append session ID to URLs manually if needed\n        $session_id = session_id();\n        echo '<a href="page.php?' . session_name() . '=' . $session_id . '">Next Page</a>';\n    }\n}\n?>