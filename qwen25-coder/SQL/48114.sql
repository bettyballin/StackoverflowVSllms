CREATE PROCEDURE MyProcedureWithRecompile @param INT\nWITH RECOMPILE\nAS\nBEGIN\n    SELECT * FROM MyTable WHERE Column = @param;\nEND;