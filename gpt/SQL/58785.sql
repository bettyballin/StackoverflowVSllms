SELECT *\nFROM reason_for_appointment\nWHERE reason_for_appointment_id IN\n(\n    SELECT reason_for_appointment_id\n    FROM appointment_reason\n    WHERE appointment_id = 11\n)\nORDER BY some_column;  -- Replace 'some_column' with the actual column you want to order by