SQL> ed\nWrote file afiedt.buf\n\n  1  DECLARE\n  2     dummy  clob;\n  3  BEGIN\n  4       dummy := empty_clob();\n  5        IF dummy = empty_clob() THEN\n  6           dbms_output.put_line( 'Dummy is empty' );\n  7        ELSE\n  8           dbms_output.put_line( 'Dummy is not empty' );\n  9        END IF;\n 10* END;\nSQL> /\nDummy is empty\n\nPL/SQL procedure successfully completed.