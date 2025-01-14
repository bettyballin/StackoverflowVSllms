SELECT \n    Player,\n    Team,\n    CASE Sport\n        WHEN 1 THEN 'Basketball'\n        WHEN 2 THEN 'Hockey'\n        WHEN 3 THEN 'Soccer'\n        WHEN 4 THEN 'Kickball'\n    END AS Sport\nFROM \n    your_table_name;