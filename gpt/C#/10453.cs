int count = Marshal.ReleaseComObject(comObject);\nConsole.WriteLine("Remaining COM references: " + count);