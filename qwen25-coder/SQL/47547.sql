DECLARE\n    -- Declare a variable of type SYS_REFCURSOR to hold your result set.\n    my_cursor SYS_REFCURSOR;\n    \n    -- Declare variables which match the columns that the cursor will return.\n    col1 datatype;  -- Replace 'datatype' and 'col1' with actual column's data type and name\n    col2 datatype;  -- Do this for all columns your query returns\n\nBEGIN\n    -- Call your function to open the ref cursor.\n    my_cursor := your_package.your_function;\n    \n    -- Output columns that ref cursor will return. Change the output method according to your needs (DBMS_OUTPUT.PUT_LINE or similar).\n    LOOP\n        FETCH my_cursor INTO col1, col2;  -- Fetch a row from the ref cursor into local variables.\n        EXIT WHEN my_cursor%NOTFOUND;     -- Exit the loop when there are no more rows.\n\n        -- Print data in needed format (example using DBMS_OUTPUT.PUT_LINE).\n        DBMS_OUTPUT.PUT_LINE('Col1: ' || TO_CHAR(col1) || ', Col2: ' || TO_CHAR(col2));\n    END LOOP;\n\n    -- Close your ref cursor after use.\n    CLOSE my_cursor;\nEND;\n/