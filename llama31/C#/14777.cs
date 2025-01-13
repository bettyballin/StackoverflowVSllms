using Microsoft.VisualBasic.FileIO;\n\n// Create a TextFieldParser instance\nusing (TextFieldParser parser = new TextFieldParser(new StringReader("1,\"Your simple algorithm, it fails\",True")))\n{\n    parser.SetDelimiters(",");\n\n    // Read fields\n    string[] fields = parser.ReadFields();\n\n    foreach (string field in fields)\n    {\n        Console.WriteLine(field);\n    }\n}