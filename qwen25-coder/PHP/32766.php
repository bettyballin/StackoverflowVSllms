// Start session normally\nsession_start();\n\n$customSessionId = session_id();\n$urlWithCustomToken = "http://example.com/page.php?token=" . urlencode($customSessionId);