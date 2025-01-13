using System.Management;\n\n// Create a new ManagementScope object\nManagementScope scope = new ManagementScope("\\\\example.com\\root\\cimv2");\n\n// Create a new ManagementClass object\nManagementClass userClass = new ManagementClass(scope, new ManagementPath("Win32_UserAccount"), null);\n\n// Create a new user\nManagementObject user = userClass.CreateInstance();\n\n// Set user properties\nuser["Name"] = "John Doe";\nuser["Domain"] = "example.com";\nuser["LocalAccount"] = false;\nuser["PasswordExpires"] = true;\n\n// Save the new user\nuser.Put();