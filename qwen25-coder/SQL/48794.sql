EXEC DBMS_STATS.GATHER_TABLE_STATS('your_schema', 'cust_bo_users');\n   EXEC DBMS_STATS.GATHER_TABLE_STATS('your_schema', 'cust_bo_roles');\n   EXEC DBMS_STATS.GATHER_TABLE_STATS('your_schema', 'cust_dept_roll_up_tbl');