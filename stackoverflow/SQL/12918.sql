SQL> CREATE TABLE EMP_50\n2 ORGANIZATION EXTERNAL\n3 ( TYPE oracle_datapump\n4 DEFAULT DIRECTORY dmp_dir\n5 LOCATION (‘emp_50.dmp'))\n6 )\n7 AS SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 50\n8 ;