Type type = COMImporter.GetTypeFromFile("MyFile.dll", "MYCOMDLL.ClassName");\nobject boxed = Activator.CreateInstance(type);