SELECT * FROM Table1 \n      INNER JOIN Table2 \n      ON Table1.agent_name = Table2.agent_name \n      WHERE Table2.department = 'somespecific value';