WITH ComputedTimes AS (\n    SELECT \n        CONVERT_TZ(\n            IF(timestamp_start > last_update, timestamp_start, last_update), \n            'GMT', \n            user.timezone\n        ) AS time_usr_tz,\n        shecdule.*\n    FROM \n        shecdule\n    INNER JOIN \n        user ON shecdule.user_id = user.user_id\n)\nSELECT \n    time_usr_tz\nFROM \n    ComputedTimes\nWHERE \n    time_usr_tz < CURRENT_TIMESTAMP();