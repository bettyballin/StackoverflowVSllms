using System.IO;\n\nstring driveLetter = "C"; // Replace with the desired drive letter\nstring recycleBinPath = Path.Combine(driveLetter + ":", "$Recycle.Bin");\n\nif (Directory.Exists(recycleBinPath))\n{\n    Console.WriteLine("Recycle Bin directory found: " + recycleBinPath);\n}\nelse\n{\n    Console.WriteLine("Recycle Bin directory not found.");\n}