DECLARE\n    my_string VARCHAR2(100) := 'Hello, World!';\n    search_char VARCHAR2(1) := ',';\n    position NUMBER;\nBEGIN\n    position := INSTR(my_string, search_char);\n    IF position > 0 THEN\n        DBMS_OUTPUT.PUT_LINE('The character "' || search_char || '" is found at position: ' || position);\n    ELSE\n        DBMS_OUTPUT.PUT_LINE('The character "' || search_char || '" is not found in the string.');\n    END IF;\nEND;\n/