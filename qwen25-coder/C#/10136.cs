string filename = @"C:\MyDirectory\MyFile.bat";\nstring directory = System.IO.Path.GetDirectoryName(filename);\nConsole.WriteLine(directory); // Output: C:\MyDirectory