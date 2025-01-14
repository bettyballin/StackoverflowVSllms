DECLARE\n  TYPE EmpRec IS RECORD (\n    empno NUMBER,\n    sal NUMBER(8,2)\n  );\n  \n  TYPE EmpTabType IS TABLE OF EmpRec;\n  \n  l_emps EmpTabType := EmpTabType();\nBEGIN\n  -- Populate the collection with data to update\n  SELECT empno, sal BULK COLLECT INTO l_emps FROM employees WHERE department_id = 50;\n\n  FORALL i IN l_emps.FIRST .. l_emps.LAST\n    UPDATE employees SET salary = l_emps(i).sal * 1.1 WHERE empno = l_emps(i).empno;\nEND;