BEGIN\n    UPDATE my_table SET my_column = 'new_value' WHERE my_condition = 'true';\n    DBMS_OUTPUT.PUT_LINE('Rows updated: ' || SQL%ROWCOUNT);\nEND;