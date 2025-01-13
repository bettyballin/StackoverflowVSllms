DECLARE\n      e_custom_exception EXCEPTION;\n      PRAGMA EXCEPTION_INIT(e_custom_exception, -20001);\n   BEGIN\n      -- Some code that raises error -20001\n      RAISE e_custom_exception;\n   EXCEPTION\n      WHEN e_custom_exception THEN\n         DBMS_OUTPUT.PUT_LINE('Custom exception caught.');\n   END;