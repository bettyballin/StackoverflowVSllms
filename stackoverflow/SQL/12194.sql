\nDECLARE\n  TYPE Str_Array IS VARRAY(4) OF VARCHAR2(50);\n  v_array  Str_Array;\n\n  PROCEDURE PROCESS_ARRAY(v_str_array  Str_Array)\n  AS\n  BEGIN\n    FOR i IN v_str_array.first .. v_str_array.last LOOP\n      DBMS_OUTPUT.PUT_LINE('Hello '||v_str_array(i));\n    END LOOP;\n  END;\n\nBEGIN\n\n  v_array := Str_Array('John','Paul','Ringo','George');\n\n  PROCESS_ARRAY(v_array);\n\n  -- can also pass unbound Str_Array\n  PROCESS_ARRAY(Str_Array('John','Paul','Ringo','George'));\n\nEND;