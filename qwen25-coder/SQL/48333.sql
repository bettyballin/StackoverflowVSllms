SELECT JSON_ARRAYAGG(\n    JSON_OBJECT('id', id, 'name', name, 'position', position)\n) AS employees_json FROM employee;