UPDATE posts SET user_id = 0 WHERE user_id = {deleted_user_id};\nUPDATE threads SET user_id = 0 WHERE user_id = {deleted_user_id};