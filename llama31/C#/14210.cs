using System.Configuration;\n\n// In Library1\nvar setting1 = ConfigurationManager.AppSettings["setting1"];\nvar setting2 = ConfigurationManager.AppSettings["setting2"];\n\n// In Library2\nvar setting3 = ConfigurationManager.AppSettings["setting3"];\nvar setting4 = ConfigurationManager.AppSettings["setting4"];