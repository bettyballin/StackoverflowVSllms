SELECT t1.*\nFROM table1 t1\nINNER JOIN table2 t2\nON t1.agent_name = t2.agent_name\nWHERE t2.department = 'desired_department';