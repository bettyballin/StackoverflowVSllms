DECLARE\n    -- Define a custom exception\n    e_abort EXCEPTION;\nBEGIN\n    -- Check the condition\n    IF [condition] THEN\n        -- Raise the custom exception\n        RAISE e_abort;\n    END IF;\n    \n    -- The rest of the program\n    [the rest of the program]\n\nEXCEPTION\n    -- Handle the custom exception\n    WHEN e_abort THEN\n        DBMS_OUTPUT.PUT_LINE('Program aborted due to condition.');\n        -- Additional cleanup code can go here if necessary\nEND;