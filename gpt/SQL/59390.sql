SELECT \n    TO_CHAR(\n        INTERVAL '1 second' * seconds, \n        'DD:HH24:MI:SS'\n    ) AS human_readable_time\nFROM \n    your_table;