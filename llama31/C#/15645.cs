string textBefore = "Τι κάνεις;";\nbyte[] bytesBefore = Encoding.Unicode.GetBytes(textBefore);\nConsole.WriteLine("Before: " + BitConverter.ToString(bytesBefore));\n\n// Insert into database...\n\nstring textAfter = GetFromDatabase();\nbyte[] bytesAfter = Encoding.Unicode.GetBytes(textAfter);\nConsole.WriteLine("After: " + BitConverter.ToString(bytesAfter));