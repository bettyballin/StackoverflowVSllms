const string query = "SELECT * FROM Win32_PatchFile";\nvar search = new ManagementObjectSearcher(query);\nvar collection = search.Get();\n\nforeach (ManagementObject patch in collection)\n{\n    Console.WriteLine(patch["PatchID"].ToString());\n}