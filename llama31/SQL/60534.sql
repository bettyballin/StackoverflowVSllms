SELECT AVG(LENGTH(constraint_name) + \n           SUM(SEARCH_CONDITION_LENGTH)) \nFROM USER_CONSTRAINTS \nWHERE TABLE_NAME = 'your_table_name';