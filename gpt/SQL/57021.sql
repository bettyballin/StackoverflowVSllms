// Example ARO table entries\n+----+-------------+--------------------+---------------------+\n| id | parent_id   | model              | foreign_key         |\n+----+-------------+--------------------+---------------------+\n| 1  | NULL        | Group              | 1 (Admin Group)     |\n| 2  | 1           | Group              | 2 (Manager Group)   |\n| 3  | 2           | Group              | 3 (User Group)      |\n| 4  | 3           | User               | 1 (John Doe)        |\n| 5  | 3           | User               | 2 (Jane Doe)        |\n+----+-------------+--------------------+---------------------+