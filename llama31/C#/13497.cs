using System.Reflection;\n\n// For Office 2003\nstring assemblyName2003 = "Microsoft.Office.Interop.Excel, Version=11.0.0.0, Culture=neutral, PublicKeyToken=71e9bce111e9429c";\n// For Office 2007\nstring assemblyName2007 = "Microsoft.Office.Interop.Excel, Version=12.0.0.0, Culture=neutral, PublicKeyToken=71e9bce111e9429c";\n\n// Load the assembly\nAssembly officeAssembly = null;\ntry\n{\n    officeAssembly = Assembly.Load(assemblyName2007);\n}\ncatch (FileNotFoundException)\n{\n    officeAssembly = Assembly.Load(assemblyName2003);\n}\n\nif (officeAssembly != null)\n{\n    // Create an instance of the Excel application object\n    Type excelAppType = officeAssembly.GetType("Microsoft.Office.Interop.Excel.Application");\n    object excelApp = Activator.CreateInstance(excelAppType);\n\n    // Use the Excel application object as needed\n    // ...\n}\nelse\n{\n    // Handle the case where neither assembly can be loaded\n    // ...\n}