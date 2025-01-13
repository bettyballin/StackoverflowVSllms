-- Sample table creation\nCREATE TABLE PhoneNumbers (\n    ID INT IDENTITY PRIMARY KEY,\n    RawPhoneNumber VARCHAR(50)\n);\n\n-- Sample data insertion\nINSERT INTO PhoneNumbers (RawPhoneNumber)\nVALUES \n(' 0123 456 789'),\n('0123-2349823'),\n('0123/2349823'),\n(' 0123 234 9823 ');\n\n-- Query to clean and format phone numbers\nUPDATE PhoneNumbers\nSET RawPhoneNumber = \n    REPLACE(REPLACE(REPLACE(REPLACE(RAWPHONENUMBER, ' ', ''), '-', ''), '/', ''), CHAR(9), '') -- Remove spaces, dashes, slashes, and tabs\n    WHERE RawPhoneNumber IS NOT NULL;\n\n-- Select to check the results\nSELECT * FROM PhoneNumbers;