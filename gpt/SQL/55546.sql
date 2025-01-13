SELECT\n    a.owner AS referencing_owner,\n    a.table_name AS referencing_table,\n    a.constraint_name AS referencing_constraint,\n    b.owner AS referenced_owner,\n    b.table_name AS referenced_table,\n    b.constraint_name AS referenced_constraint\nFROM\n    all_constraints a\n    JOIN all_constraints b ON a.r_constraint_name = b.constraint_name\nWHERE\n    b.table_name = 'EMP' -- replace with your table name\n    AND b.owner = 'YOUR_SCHEMA'; -- replace with your schema name