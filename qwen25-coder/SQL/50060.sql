SELECT COMPANY_ID,\n       STRING_AGG(EMPLOYEE, ', ') AS EMPLOYEES\nFROM your_table_name\nGROUP BY COMPANY_ID;