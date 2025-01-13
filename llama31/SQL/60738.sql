DECLARE\n  v_smtp_conn utl_smtp.connection;\n  v_email_body VARCHAR2(4000);\n  v_file_handle UTL_FILE.FILE_TYPE;\n  v_file_name VARCHAR2(50);\nBEGIN\n  -- Create a file handle\n  v_file_name := 'email_' || TO_CHAR(SYSTIMESTAMP, 'YYYYMMDDHH24MISS') || '.txt';\n  v_file_handle := UTL_FILE.FOPEN('EMAIL_DIR', v_file_name, 'W');\n\n  -- Build the email body\n  v_email_body := 'Subject: Test Email' || CHR(13) || 'Dear Manager,' || CHR(13) || 'This is a test email.';\n\n  -- Write the email body to the file\n  UTL_FILE.PUT_LINE(v_file_handle, v_email_body);\n\n  -- Close the file handle\n  UTL_FILE.FCLOSE(v_file_handle);\n\n  -- Optional: Send the email using utl_smtp (commented out)\n  -- v_smtp_conn := utl_smtp.open_connection('smtp_server_ip');\n  -- utl_smtp.helo(v_smtp_conn, 'smtp_server_ip');\n  -- utl_smtp.mail(v_smtp_conn, 'from_email@example.com');\n  -- utl_smtp.rcpt(v_smtp_conn, 'to_email@example.com');\n  -- utl_smtp.data(v_smtp_conn, v_email_body);\n  -- utl_smtp.quit(v_smtp_conn);\nEND;