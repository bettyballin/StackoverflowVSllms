$sessionId = session_id();\n$urlWithSessionId = "http://example.com/page.php?PHPSESSID=" . urlencode($sessionId);