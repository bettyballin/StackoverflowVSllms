-- Create a block to display the files\nCREATE BLOCK files\n(\n    file_name VARCHAR2(255),\n    file_size NUMBER,\n    file_date DATE\n);\n\n-- Use the HOST command to list the files\nHOST('cmd /c dir C:\path\to\folder\*.pdf > file_list.txt');\n\n-- Read the file list into the block\nDECLARE\n    file_list VARCHAR2(255);\nBEGIN\n    file_list := HOST('cmd /c type file_list.txt');\n    FOR i IN 1..REGEXP_COUNT(file_list, '\n') LOOP\n        file_name := REGEXP_SUBSTR(file_list, '([^\n]+)', 1, i);\n        file_size := DBMS_LOB.GETLENGTH(file_name);\n        file_date := DBMS_LOB.LAST_MODIFIED(file_name);\n        INSERT INTO files (file_name, file_size, file_date) VALUES (file_name, file_size, file_date);\n    END LOOP;\nEND;