SELECT user\nFROM (\n    SELECT user, action, success, MAX(date) as last_action_date\n    FROM access_log\n    WHERE date >= Date() AND success = 1\n    GROUP BY user, action, success\n) as last_actions\nWHERE action = 'login';