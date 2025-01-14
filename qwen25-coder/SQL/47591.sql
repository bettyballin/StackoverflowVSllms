DECLARE\n    v_out_file utl_file.file_type;\n    v_buffer   RAW(32767); -- 32K Buffer Size\n    v_amount   BINARY_INTEGER := 32767; -- Amount of data to be read/written in one read/write operation\n    v_offset   BINARY_INTEGER := 1; -- Offset for reading data from the BLOB\nBEGIN\n    v_out_file := utl_file.fopen(location => pi_directory, filename => pi_filename, open_mode => 'wb');\n\n    LOOP\n        BEGIN\n            dbms_lob.read(pi_blob, amount => v_amount, offset => v_offset, buffer => v_buffer);\n\n            -- Write the data to file in binary mode\n            utl_file.put_raw(file => v_out_file, buffer => v_buffer, autoflush => FALSE);\n            \n            -- Prepare for next read operation\n            v_offset := v_offset + DBMS_LOB.GETLENGTH(v_buffer); \n        EXCEPTION\n            WHEN NO_DATA_FOUND THEN -- End-of-blob reached; exit loop\n                EXIT;\n            WHEN OTHERS THEN\n                utl_file.fclose(file => v_out_file);\n                dbms_output.put_line('Error: ' || SQLERRM);\n                END;\n    END LOOP;\n\n    utl_file.fflush(v_out_file);  -- Flush the buffer to ensure all data is written\n    utl_file.fclose(v_out_file);\n\nEXCEPTION\n    WHEN OTHERS THEN\n        IF utl_file.is_open(v_out_file) THEN\n            utl_file.fclose(v_out_file);\n        END IF;\n        RAISE; -- Re-raise exception for further debugging\nEND;