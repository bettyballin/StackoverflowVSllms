INSERT INTO my_prefs (user_id, pref_key, pref_value)\nVALUES (1234, 'show_help', 'true')\nON DUPLICATE KEY UPDATE pref_value = VALUES(pref_value);