CREATE OR REPLACE FUNCTION inttoip(p_ip_address NUMBER) RETURN VARCHAR2 IS\n  v_ip_address VARCHAR2(15);\nBEGIN\n  v_ip_address := TO_CHAR(TRUNC(p_ip_address / 256**3)) || '.' ||\n                  TO_CHAR(TRUNC(MOD(p_ip_address, 256**3) / 256**2)) || '.' ||\n                  TO_CHAR(TRUNC(MOD(p_ip_address, 256**2) / 256)) || '.' ||\n                  TO_CHAR(MOD(p_ip_address, 256));\n  RETURN v_ip_address;\nEND inttoip;\n\nCREATE OR REPLACE FUNCTION iptoint(p_ip_address VARCHAR2) RETURN NUMBER IS\n  v_octets VARCHAR2(15) := p_ip_address;\n  v_ip_address NUMBER;\nBEGIN\n  v_ip_address := TO_NUMBER(SUBSTR(v_octets, 1, INSTR(v_octets, '.') - 1)) * 256**3 +\n                  TO_NUMBER(SUBSTR(v_octets, INSTR(v_octets, '.') + 1, INSTR(v_octets, '.', INSTR(v_octets, '.') + 1) - INSTR(v_octets, '.') - 1)) * 256**2 +\n                  TO_NUMBER(SUBSTR(v_octets, INSTR(v_octets, '.', INSTR(v_octets, '.') + 1) + 1, INSTR(v_octets, '.', INSTR(v_octets, '.', INSTR(v_octets, '.') + 1) + 1) - INSTR(v_octets, '.', INSTR(v_octets, '.') + 1) - 1)) * 256 +\n                  TO_NUMBER(SUBSTR(v_octets, INSTR(v_octets, '.', INSTR(v_octets, '.', INSTR(v_octets, '.') + 1) + 1) + 1));\n  RETURN v_ip_address;\nEND iptoint;