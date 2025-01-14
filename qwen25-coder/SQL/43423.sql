-- Step 1: Define the stored procedure with your complex query\nDELIMITER //\n\nCREATE PROCEDURE nested_sp()\nBEGIN\n    SELECT column1, column2 -- specify your columns here\n    FROM your_table        -- specify your source table here\n    WHERE some_condition;  -- add any conditions as needed\nEND//\n\nDELIMITER ;\n\n-- Step 2: Create a stored procedure to populate the temporary table\nDELIMITER //\n\nCREATE PROCEDURE fill_temp_table()\nBEGIN\n    -- Create a temporary table with appropriate structure\n    CREATE TEMPORARY TABLE IF NOT EXISTS tmp (\n        column1 datatype,   -- replace 'datatype' with actual data type of column1\n        column2 datatype    -- replace 'datatype' with actual data type of column2\n    );\n\n    -- Insert the result from nested_sp into the temporary table\n    INSERT INTO tmp\n    CALL nested_sp();\nEND//\n\nDELIMITER ;\n\n-- Call the procedure to fill the temp table\nCALL fill_temp_table();\n\n-- Query the temp table if needed\nSELECT * FROM tmp;\n\n-- Clean up - drop the temporary table when done\nDROP TEMPORARY TABLE IF EXISTS tmp;