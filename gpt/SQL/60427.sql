DECLARE\n       v_file BFILE;\n       v_blob BLOB;\n       v_dest_offset INTEGER := 1;\n       v_src_offset INTEGER := 1;\n       v_file_length INTEGER;\n   BEGIN\n       SELECT file_location INTO v_file FROM file_metadata WHERE id = 1;\n       DBMS_LOB.OPEN(v_file, DBMS_LOB.LOB_READONLY);\n       v_file_length := DBMS_LOB.GETLENGTH(v_file);\n       DBMS_LOB.CREATETEMPORARY(v_blob, TRUE);\n       DBMS_LOB.LOADFROMFILE(v_blob, v_file, v_file_length);\n       DBMS_LOB.CLOSE(v_file);\n       \n       -- Now v_blob contains the file data and can be processed as needed\n   END;