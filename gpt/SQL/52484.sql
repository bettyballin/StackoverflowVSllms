-- Create a new type to hold the split parts\nCREATE OR REPLACE TYPE varchar2_table AS TABLE OF VARCHAR2(4000);\n/\n\n-- Function to split CSV string\nCREATE OR REPLACE FUNCTION split_csv(p_list IN VARCHAR2, p_delimiter IN VARCHAR2 := ',')\n  RETURN varchar2_table\nIS\n  l_string VARCHAR2(32767) := p_list;\n  l_pos    PLS_INTEGER;\n  l_data   varchar2_table := varchar2_table();\nBEGIN\n  LOOP\n    l_pos := INSTR(l_string, p_delimiter);\n    EXIT WHEN NVL(l_pos, 0) = 0;\n    l_data.EXTEND;\n    l_data(l_data.COUNT) := TRIM(SUBSTR(l_string, 1, l_pos - 1));\n    l_string := SUBSTR(l_string, l_pos + LENGTH(p_delimiter));\n  END LOOP;\n  IF l_string IS NOT NULL THEN\n    l_data.EXTEND;\n    l_data(l_data.COUNT) := TRIM(l_string);\n  END IF;\n  RETURN l_data;\nEND split_csv;\n/\n\n-- Example usage\nDECLARE\n  l_tab varchar2_table;\nBEGIN\n  l_tab := split_csv('a,b,c,d,e');\n  FOR i IN 1..l_tab.COUNT LOOP\n    DBMS_OUTPUT.PUT_LINE(l_tab(i));\n  END LOOP;\nEND;\n/