<?php\n// Start the session at the beginning of your script\nini_set('session.gc_maxlifetime', 3600); // Session lasts for 1 hour (3600 seconds)\nsession_start();\n\n// Optionally, set the cookie lifetime to match the gc_maxlifetime\nsetcookie(session_name(), session_id(), time() + ini_get("session.gc_maxlifetime"), "/");\n?>