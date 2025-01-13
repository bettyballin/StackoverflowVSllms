WITH RECURSIVE table_dependency (table_name, referenced_table) AS (\n    -- Anchor member: start with the root table\n    SELECT \n        c1.table_name, \n        c2.table_name AS referenced_table\n    FROM \n        all_constraints c1\n    JOIN \n        all_constraints c2 \n    ON \n        c1.r_constraint_name = c2.constraint_name\n    WHERE \n        c1.constraint_type = 'R'\n        AND c1.table_name = :tablename\n    \n    UNION ALL\n    \n    -- Recursive member: find tables that reference the current table\n    SELECT \n        c1.table_name, \n        c2.table_name AS referenced_table\n    FROM \n        all_constraints c1\n    JOIN \n        table_dependency td \n    ON \n        c1.r_constraint_name = td.table_name\n    JOIN \n        all_constraints c2 \n    ON \n        c1.r_constraint_name = c2.constraint_name\n    WHERE \n        c1.constraint_type = 'R'\n)\nSELECT \n    table_name, \n    referenced_table\nFROM \n    table_dependency;