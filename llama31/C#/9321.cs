DirectoryCatalog directoryCatalog = new DirectoryCatalog("path/to/assemblies");\n\nforeach (Assembly assembly in directoryCatalog.GetAssemblies())\n{\n    if (assembly.GetExportedTypes().Count() > 0)\n    {\n        // Get assembly attributes\n        string copyright = assembly.GetCustomAttribute<AssemblyCopyrightAttribute>().Copyright;\n        string version = assembly.GetName().Version.ToString();\n        string name = assembly.GetName().Name;\n        // ...\n    }\n}