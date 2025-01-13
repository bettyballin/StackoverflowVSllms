SELECT\n     E.*     -- Don't actually use *, list out all of your columns\nFROM\n     Employees E\nINNER JOIN\n     (\n          SELECT\n               department,\n               MIN(salary) AS min_salary\n          FROM\n               Employees\n          GROUP BY\n               department\n     ) AS SQ ON\n     SQ.department = E.department AND\n     SQ.min_salary = E.salary