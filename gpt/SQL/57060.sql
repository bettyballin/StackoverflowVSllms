CREATE OR REPLACE FUNCTION inttoip(ip IN NUMBER) RETURN VARCHAR2 IS\n    octet1 NUMBER;\n    octet2 NUMBER;\n    octet3 NUMBER;\n    octet4 NUMBER;\nBEGIN\n    octet1 := FLOOR(ip / 16777216);\n    octet2 := FLOOR(MOD(ip, 16777216) / 65536);\n    octet3 := FLOOR(MOD(ip, 65536) / 256);\n    octet4 := MOD(ip, 256);\n    RETURN octet1 || '.' || octet2 || '.' || octet3 || '.' || octet4;\nEND;\n/\n\nCREATE OR REPLACE FUNCTION iptoint(ip IN VARCHAR2) RETURN NUMBER IS\n    octet1 NUMBER;\n    octet2 NUMBER;\n    octet3 NUMBER;\n    octet4 NUMBER;\n    dot1 NUMBER;\n    dot2 NUMBER;\n    dot3 NUMBER;\nBEGIN\n    dot1 := INSTR(ip, '.', 1, 1);\n    dot2 := INSTR(ip, '.', 1, 2);\n    dot3 := INSTR(ip, '.', 1, 3);\n    \n    octet1 := TO_NUMBER(SUBSTR(ip, 1, dot1 - 1));\n    octet2 := TO_NUMBER(SUBSTR(ip, dot1 + 1, dot2 - dot1 - 1));\n    octet3 := TO_NUMBER(SUBSTR(ip, dot2 + 1, dot3 - dot2 - 1));\n    octet4 := TO_NUMBER(SUBSTR(ip, dot3 + 1));\n    \n    RETURN (octet1 * 16777216) + (octet2 * 65536) + (octet3 * 256) + octet4;\nEND;\n/