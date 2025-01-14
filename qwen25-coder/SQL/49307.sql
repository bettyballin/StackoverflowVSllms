UPDATE lessonstatus ls\nINNER JOIN user u ON ls.user_id = u.user_id\nCROSS JOIN (\n    SELECT user_id \n    FROM user \n    WHERE username = 'too_many_accounts'\n) AS target_user\nLEFT JOIN lessonstatus ls2 ON ls.lesson_id = ls2.lesson_id AND ls2.user_id = 1\nSET ls.user_id = target_user.user_id\nWHERE u.last_name = 'stupid' \nAND u.first_name = 'user'\nAND u.username != 'too_many_accounts'\nAND ls2.lesson_id IS NULL;