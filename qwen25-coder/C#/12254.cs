Type myType = Type.GetType("System.Text.StringBuilder");\nobject instance = Activator.CreateInstance(myType);\nMethodInfo methodInfo = myType.GetMethod("AppendLine", new[] { typeof(string) });\nmethodInfo.Invoke(instance, new object[] { "Hello World" });\nConsole.WriteLine(((StringBuilder)instance).ToString());