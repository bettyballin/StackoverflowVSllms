CREATE OR REPLACE PACKAGE A AS\n  PROCEDURE CALL_B;\nEND A;\n\nCREATE OR REPLACE PACKAGE BODY A AS\n  PROCEDURE CALL_B IS\n  BEGIN\n    B.MY_PROCEDURE;\n  END CALL_B;\nEND A;\n\nCREATE OR REPLACE PACKAGE B AS\n  PROCEDURE MY_PROCEDURE;\nEND B;\n\nCREATE OR REPLACE PACKAGE BODY B AS\n  PROCEDURE MY_PROCEDURE IS\n    l_call_stack VARCHAR2(4000);\n  BEGIN\n    l_call_stack := DBMS_UTILITY.FORMAT_CALL_STACK;\n    DBMS_OUTPUT.PUT_LINE(l_call_stack);\n  END MY_PROCEDURE;\nEND B;