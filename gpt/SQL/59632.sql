-- To add a flag to a user\n   UPDATE users\n   SET flags = jsonb_set(flags, '{new_flag}', 'true')\n   WHERE user_id = ?;