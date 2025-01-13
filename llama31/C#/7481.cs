using System.IO.IsolatedStorage;\n\n// Get the isolated storage for the current assembly\nIsolatedStorageFile isoStore = IsolatedStorageFile.GetUserStoreForAssembly();\n\n// Create a new file in the isolated storage\nIsolatedStorageFileStream fileStream = isoStore.CreateFile("myFile.txt");\n\n// Write to the file\nusing (StreamWriter writer = new StreamWriter(fileStream))\n{\n    writer.WriteLine("Hello, World!");\n}\n\n// Close the file stream\nfileStream.Close();