using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        Console.WriteLine("Your text here");\n\n        // Specify the encoding as UTF-16 with a BOM\n        using (StreamWriter writer = new StreamWriter("textfile.txt", false, new System.Text.UnicodeEncoding(true)))\n        {\n            writer.Write("Your text here");\n        }\n    }\n}