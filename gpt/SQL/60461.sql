DECLARE\n  file_handle UTL_FILE.FILE_TYPE;\n  v_line VARCHAR2(1000);\nBEGIN\n  -- Open the file for writing\n  file_handle := UTL_FILE.FOPEN('my_dir', 'output.txt', 'w');\n\n  -- Write a header line to the file (optional)\n  UTL_FILE.PUT_LINE(file_handle, 'Column1,Column2,Column3');\n\n  -- Cursor to fetch the query results\n  FOR rec IN (SELECT column1, column2, column3 FROM your_table) LOOP\n    -- Construct a line of output\n    v_line := rec.column1 || ',' || rec.column2 || ',' || rec.column3;\n    -- Write the line to the file\n    UTL_FILE.PUT_LINE(file_handle, v_line);\n  END LOOP;\n\n  -- Close the file\n  UTL_FILE.FCLOSE(file_handle);\nEXCEPTION\n  WHEN OTHERS THEN\n    -- Ensure the file is closed in case of an error\n    IF UTL_FILE.IS_OPEN(file_handle) THEN\n      UTL_FILE.FCLOSE(file_handle);\n    END IF;\n    RAISE;\nEND;\n/