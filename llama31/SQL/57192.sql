SELECT t.due_date\nFROM thread t\nLEFT JOIN product p ON t.prod_id = p.id\nWHERE t.user_id = '5' OR p.user_id = '5';