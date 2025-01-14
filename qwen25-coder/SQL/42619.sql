SELECT id.primary_key_id, id.serial_number, id.counter, id.selected_color\nFROM incoming_data id\nJOIN (\n    SELECT serial_number, MAX(counter) AS max_counter\n    FROM incoming_data\n    WHERE DATE(incoming_data.timestamp) = CURDATE() -- Ensure you filter by today's date\n    GROUP BY serial_number\n) max_values ON id.serial_number = max_values.serial_number AND id.counter = max_values.max_counter;