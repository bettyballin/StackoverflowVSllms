void ModifyValue(ref int value) {\n    value = 10;\n}\n\nint number = 5;\nModifyValue(ref number); // number will now be 10