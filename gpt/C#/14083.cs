var stringReader = new StringReader("This is a test string.");\nvar streamReader = new StreamReader(new MemoryStream(System.Text.Encoding.UTF8.GetBytes("This is a test stream.")));\n\nTextReader reader = stringReader; // or streamReader\n\n// Reset the reader after some operations\nreader = TextReaderExtensions.ResetReader(reader);\n\n// Now reader is reset to the beginning