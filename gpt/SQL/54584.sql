-- Assuming you have two hashed values and a plaintext password\nDECLARE @hashedPassword1 VARBINARY(MAX);\nDECLARE @hashedPassword2 VARBINARY(MAX);\nDECLARE @plaintextPassword NVARCHAR(128) = 'abc';\n\n-- Assign the hashed values (replace with actual values)\nSET @hashedPassword1 = (SELECT PWDENCRYPT('abc'));\nSET @hashedPassword2 = (SELECT PWDENCRYPT('abc'));\n\n-- Use PWDCOMPARE to check if the plaintext password matches each hashed value\nDECLARE @result1 BIT = PWDCOMPARE(@plaintextPassword, @hashedPassword1);\nDECLARE @result2 BIT = PWDCOMPARE(@plaintextPassword, @hashedPassword2);\n\n-- Output the results\nSELECT \n    @result1 AS IsPassword1Match,\n    @result2 AS IsPassword2Match;