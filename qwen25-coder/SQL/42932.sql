-- Define a composite type\nCREATE TYPE opening_hours_record AS (\n    col1 text,\n    col2 text,\n    col3 text\n);\n\n-- Create the function using the composite type\nCREATE OR REPLACE FUNCTION storeopeninghours_tostring(numeric)\nRETURNS SETOF opening_hours_record AS $$\nDECLARE\n    open_id ALIAS FOR $1;\nBEGIN\n    RETURN QUERY\n    SELECT '1', '2', '3' UNION ALL\n    SELECT '3', '4', '5' UNION ALL\n    SELECT '6', '7', '8';  -- Added another row for demonstration\nEND;\n$$ LANGUAGE plpgsql;