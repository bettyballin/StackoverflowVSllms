BEGIN\n     DBMS_SQLDIAG.DUMP_ERROR_TEXT (\n       p_error_text => 'ORA-00942: Table or view does not exist',\n       p_filename   => 'missing_object_error.txt'\n     );\n   END;