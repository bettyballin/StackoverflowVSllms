FUNCTION find_customer(\n  name VARCHAR2 DEFAULT CHR(0),\n  number VARCHAR2 DEFAULT CHR(0)\n) RETURN NUMBER IS\nBEGIN\n  IF name = CHR(0) AND number = CHR(0) THEN\n    -- neither name nor number was specified\n  ELSIF name = CHR(0) THEN\n    -- only number was specified\n  ELSIF number = CHR(0) THEN\n    -- only name was specified\n  ELSE\n    -- both name and number were specified\n  END IF;\n  -- Query the "customer" table using only those parameters provided\nEND;