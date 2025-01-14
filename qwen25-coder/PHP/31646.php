<?php\nfunction runScheduledTasks() {\n    $db = new PDO('mysql:host=localhost;dbname=test', 'user', 'password');\n    $stmt = $db->query("SELECT script_path FROM scheduled_tasks WHERE HOUR(run_time) = HOUR(NOW()) AND MINUTE(run_time) = MINUTE(NOW())");\n\n    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n        include_once($row['script_path']);\n    }\n}\n\n// This should be called in a frequently running cron job\ncron_schedule('0 * * * *', 'runScheduledTasks');\n\nfunction cron_schedule($schedule, $callback) {\n    if (is_array($schedule)) { \n        foreach ($schedule as $s) {\n            if (match_cron_time($s)) call_user_func($callback);\n        }\n    } else {\n        if (match_cron_time($schedule)) call_user_func($callback);\n    }\n}\n\nfunction match_cron_time($time) {\n    // Simple implementation for minute resolution\n    list($minute, $hour) = explode(' ', $time); \n    return date('i') == $minute && ($hour == '*' || date('G') == (int)$hour);\n}