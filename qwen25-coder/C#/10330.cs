// Example of accessing contacts using OpenNetCF in .NET\nusing OpenNETCF.Desktop.Communication;\n\nContact cr = new Contact();\ncr.OpenRead();\nforeach (ContactProperty c in cr)\n{\n    Console.WriteLine(c.Name);\n}