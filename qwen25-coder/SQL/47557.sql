DECLARE\n    v_sql VARCHAR2(32767);\n    v_nameVARCHAR2(100);\n    -- Assuming there are more parameters like v_age, v_location etc.\n    \n    search_cursor SYS_REFCURSOR;\nBEGIN\n    -- Base query without conditions\n    v_sql := 'SELECT * FROM your_table WHERE 1 = 1';\n    \n    -- Retrieve parameter values from a collection or direct assignment\n    v_name := ... -- retrieve "name" parameter\n    \n    -- Dynamically add conditions with bind variables\n    IF v_name IS NOT NULL THEN\n        v_sql := v_sql || ' AND Name = :b_name';\n    END IF;\n    \n    -- Open cursor for the dynamic SQL and pass the parameters\n    OPEN search_cursor FOR v_sql USING v_name;\n    \n    -- Fetch and process results from search_cursor as needed...\nEND;