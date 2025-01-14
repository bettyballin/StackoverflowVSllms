DECLARE\n    v_column_name VARCHAR2(30);\nBEGIN\n    -- Assume this is safely input by the user or validated within your application logic\n    v_column_name := 'NAME';  -- Could be dynamically set\n    \n    EXECUTE IMMEDIATE 'SELECT * FROM PERSON ORDER BY ' || v_column_name;\nEND;