string str = "Example <TAG1> text";\nchar asciiChar = (char)0x01; // ASCII character with value 0x01\nstr = str.Replace("<TAG1>", asciiChar.ToString());\n\nConsole.WriteLine(str); // Outputs: Example  text