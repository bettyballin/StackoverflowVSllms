BEGIN\n     -- Your SQL statement here\n   EXCEPTION\n     WHEN OTHERS THEN\n       DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);\n       -- Log the SQL statement being executed\n   END;