UPDATE your_table_name\nSET user_timezone = CASE\n    WHEN user_timezone = '10+' THEN 'Pacific/Honolulu'\n    WHEN user_timezone = '1-' THEN 'Europe/London'\n    -- Add more mappings as needed\n    ELSE user_timezone -- To handle cases where no change is needed\nEND;