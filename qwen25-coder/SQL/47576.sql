BEGIN\n    IF [condition] THEN\n        -- You can use a RETURN statement if this is inside a procedure or function\n        DBMS_OUTPUT.PUT_LINE('Exiting due to condition.');\n        RETURN;  -- This will terminate the current subprogram\n    END IF;\n\n    -- The rest of your program goes here\n    [the rest of the program]\nEXCEPTION\n    WHEN OTHERS THEN\n        -- Handle exceptions if any occur\n        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);\nEND;