DECLARE @MyBoolean bit;\nSET @MyBoolean = 0;\nSET @MyBoolean = @MyBoolean ^ 1;\nSELECT @MyBoolean;