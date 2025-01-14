WITH numbered_rows AS (\n    SELECT id, nextval('number_sequence') AS new_number\n    FROM person\n    WHERE <your_condition>\n)\nUPDATE person p\nSET unique_number = nr.new_number\nFROM numbered_rows nr\nWHERE p.id = nr.id;