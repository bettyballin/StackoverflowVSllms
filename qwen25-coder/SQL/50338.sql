CREATE VIEW my_view AS \nSELECT \n    t1.id AS table1_id,\n    t2.id AS table2_id,\n    -- other necessary columns with similar aliasing\nFROM \n    table1 t1 \nJOIN \n    table2 t2 ON t1.id = t2.id;