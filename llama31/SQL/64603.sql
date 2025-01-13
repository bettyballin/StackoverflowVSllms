UPDATE user_cars\nSET num_cars = CASE\n    WHEN user_name = 'Bob' THEN num_cars - 2\n    WHEN user_name = 'John' THEN num_cars + 2\n    ELSE num_cars\nEND\nWHERE user_name IN ('Bob', 'John');