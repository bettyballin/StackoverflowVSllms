CREATE OR REPLACE PROCEDURE some_procedure IS\n    v_procedure_name VARCHAR2(32);\n    v_object_id NUMBER;\nBEGIN\n    SELECT name, object_id\n    INTO v_procedure_name, v_object_id\n    FROM user_objects\n    WHERE object_id = (\n        SELECT object_id\n        FROM user_source\n        WHERE name = SUBSTR(DBMS_UTILITY.FORMAT_CALL_STACK, INSTR(DBMS_UTILITY.FORMAT_CALL_STACK, ' ', -1) + 1)\n        AND ROWNUM = 1\n    );\n\n    DBMS_OUTPUT.PUT_LINE('Procedure Name: ' || v_procedure_name);\n    DBMS_OUTPUT.PUT_LINE('Object ID: ' || v_object_id);\nEND;\n/