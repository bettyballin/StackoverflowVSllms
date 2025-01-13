<?php\nfunction sanitize_log_entry($entry) {\n    return htmlspecialchars($entry, ENT_QUOTES, 'UTF-8');\n}\n\n// Example of reading and displaying log entries\n$log_entries = file('access_log.txt');\nforeach ($log_entries as $entry) {\n    echo '<p>' . sanitize_log_entry($entry) . '</p>';\n}\n?>