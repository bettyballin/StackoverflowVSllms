CREATE OR REPLACE PACKAGE edi_parser AS\n  FUNCTION extract_field(\n    p_edi_message CLOB,\n    p_segment_id  VARCHAR2,\n    p_field_pos   NUMBER\n  ) RETURN VARCHAR2;\nEND edi_parser;\n/\n\nCREATE OR REPLACE PACKAGE BODY edi_parser AS\n  FUNCTION extract_field(\n    p_edi_message CLOB,\n    p_segment_id  VARCHAR2,\n    p_field_pos   NUMBER\n  ) RETURN VARCHAR2 IS\n    l_line VARCHAR2(32767);\n    l_pos  PLS_INTEGER;\n    l_field VARCHAR2(32767);\n  BEGIN\n    FOR line IN (SELECT REGEXP_SUBSTR(p_edi_message, '[^\n]+', 1, LEVEL) AS line\n                 FROM dual\n                 CONNECT BY REGEXP_SUBSTR(p_edi_message, '[^\n]+', 1, LEVEL) IS NOT NULL) LOOP\n      -- Check if the line starts with the segment identifier\n      IF SUBSTR(line.line, 1, LENGTH(p_segment_id)) = p_segment_id THEN\n        -- Find the position of the specified field\n        l_line := line.line;\n        l_pos := 1;\n        FOR i IN 1..p_field_pos LOOP\n          l_pos := INSTR(l_line, '*', l_pos + 1);\n          IF l_pos = 0 THEN\n            RETURN NULL; -- Field not found\n          END IF;\n        END LOOP;\n        -- Extract the field value\n        l_field := SUBSTR(l_line, l_pos + 1, INSTR(l_line, '*', l_pos + 1) - l_pos - 1);\n        RETURN l_field;\n      END IF;\n    END LOOP;\n    RETURN NULL; -- Segment not found\n  END extract_field;\nEND edi_parser;\n/