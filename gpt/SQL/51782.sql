DECLARE @myInt INT = 1;\nDECLARE @zeroPaddedString VARCHAR(10);\n\nSET @zeroPaddedString = FORMAT(@myInt, '00000000');\n\nSELECT @zeroPaddedString;