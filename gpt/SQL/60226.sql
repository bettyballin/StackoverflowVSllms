-- Non-Unicode, up to 255 characters\nCREATE TABLE ExampleVarchar (\n    TextColumn varchar(255)\n);\n\n-- Unicode, up to 255 characters\nCREATE TABLE ExampleNvarchar (\n    TextColumn nvarchar(255)\n);\n\n-- Unicode, up to maximum storage\nCREATE TABLE ExampleNvarcharMax (\n    TextColumn nvarchar(max)\n);