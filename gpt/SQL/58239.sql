SELECT e.name, d.department_name\nFROM employees e\nLEFT JOIN departments d ON e.department_id = d.department_id;