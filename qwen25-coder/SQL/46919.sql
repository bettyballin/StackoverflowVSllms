DECLARE\n  src_clob  CLOB;\n  dest_file UTL_FILE.FILE_TYPE;\nBEGIN\n  SELECT your_clob_column INTO src_clob FROM your_table WHERE your_condition;\n\n  dest_file := UTL_FILE.FOPEN('YOUR_DIRECTORY', 'output.txt', 'w');\n\n  IF LENGTH(src_clob) > 0 THEN\n    FOR i IN 1 .. CEIL(LENGTH(src_clob)/32767) LOOP\n      UTL_FILE.PUT_LINE(dest_file, DBMS_LOB.SUBSTR(src_clob, 32767, ((i - 1) * 32767) + 1));\n    END LOOP;\n  ELSE\n    UTL_FILE.PUT_LINE(dest_file, 'Empty LOB');\n  END IF;\n\n  UTL_FILE.FCLOSE(dest_file);\nEXCEPTION\n  WHEN OTHERS THEN\n    BEGIN\n      IF UTL_FILE.IS_OPEN(dest_file) THEN\n        UTL_FILE.FCLOSE(dest_file);\n      END IF;\n    END;\n    RAISE;\nEND;\n/