ALTER PROCEDURE [usp_debug_fails]\n    @DATA_DT_ID AS int\nWITH RECOMPILE\nAS\nBEGIN\n    -- Stuff here that depends on @DATA_DT_ID\n    OPTION (RECOMPILE)\nEND