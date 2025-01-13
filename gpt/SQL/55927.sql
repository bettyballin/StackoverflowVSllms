DECLARE\n    v_file UTL_FILE.FILE_TYPE;\n    CURSOR cur IS SELECT * FROM your_table;\n    v_record cur%ROWTYPE;\nBEGIN\n    v_file := UTL_FILE.FOPEN('YOUR_DIRECTORY', 'data_output.txt', 'w');\n    OPEN cur;\n    LOOP\n        FETCH cur INTO v_record;\n        EXIT WHEN cur%NOTFOUND;\n        UTL_FILE.PUT_LINE(v_file, v_record.column1 || ',' || v_record.column2 || ',' || ...);\n    END LOOP;\n    CLOSE cur;\n    UTL_FILE.FCLOSE(v_file);\nEND;\n/