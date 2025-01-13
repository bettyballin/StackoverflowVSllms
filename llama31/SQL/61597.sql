CREATE OR REPLACE TYPE array_type IS TABLE OF VARCHAR2(255);\n\nCREATE OR REPLACE PROCEDURE my_procedure(p_array IN array_type)\nAS\nBEGIN\n  FOR i IN 1..p_array.COUNT LOOP\n    DBMS_OUTPUT.PUT_LINE(p_array(i));\n  END LOOP;\nEND;\n/