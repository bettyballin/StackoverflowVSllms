ALTER PROCEDURE [usp_debug_fails]\n    @DATA_DT_ID AS int\nWITH RECOMPILE\nAS\nBEGIN\n    /*\n        Usage:\n        EXEC [usp_debug_fails] 20081130 WITH RECOMPILE\n    */\n\n    -- Stuff here that depends on DATA_DT_ID\n\n    -- Example query with OPTION (RECOMPILE)\n    SELECT * FROM YourTable\n    WHERE YourColumn = @DATA_DT_ID\n    OPTION (RECOMPILE);\nEND