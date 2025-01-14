DECLARE\n  v_test VARCHAR2(50) := 'Sample [string] with (special) *chars+|.';\n  v_escaped VARCHAR2(100);\nBEGIN\n  v_escaped := escape_regex_special_chars(v_test);\n  DBMS_OUTPUT.PUT_LINE('Original: ' || v_test);\n  DBMS_OUTPUT.PUT_LINE('Escaped: ' || v_escaped);\nEND;\n/