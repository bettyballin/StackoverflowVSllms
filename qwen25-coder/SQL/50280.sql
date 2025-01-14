DECLARE\n    v_rows NUMBER;\n  BEGIN\n    -- Implicit cursor used here\n    UPDATE employees SET salary = salary * 1.05 WHERE department_id = 10;\n    \n    -- %ROWCOUNT is an attribute of the implicit cursor\n    v_rows := SQL%ROWCOUNT;\n    DBMS_OUTPUT.PUT_LINE(v_rows || ' rows were updated.');\n  END;