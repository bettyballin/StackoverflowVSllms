Assembly assembly = Assembly.LoadFile("C:\\test.dll");\nType type = assembly.GetType("test.dllTest");\nForm form = (Form)Activator.CreateInstance(type);\nform.Show();