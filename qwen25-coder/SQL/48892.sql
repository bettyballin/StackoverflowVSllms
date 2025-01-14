-- Updated Oracle MD5 Function to return Hex String\nCREATE OR REPLACE FUNCTION PORTAL.md5hash (v_input_string IN VARCHAR2) RETURN VARCHAR2 IS\n   v_checksum RAW(16); -- Change the type to RAW with appropriate length for MD5\nBEGIN\n    v_checksum := DBMS_OBFUSCATION_TOOLKIT.MD5(input_string => v_input_string);\n    RETURN RAWTOHEX(v_checksum); -- Convert RAW to hexadecimal string\nEND;\n/\n\n-- Updated Query to fetch Hexadecimal representation of MD5 hash\n$md5query = "SELECT md5hash('testingthemd5function') FROM dual";