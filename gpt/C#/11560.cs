using System;\nusing System.Linq;\nusing System.Reflection;\n\npublic class GenericInstantiator\n{\n    public static object CreateInstance(string genericTypeName)\n    {\n        // Example input: "MyCustomGenericCollection(of MyCustomObjectClass)"\n        // Step 1: Parse the generic type name\n        var typeParts = genericTypeName.Split(new[] { "of" }, StringSplitOptions.RemoveEmptyEntries);\n        if (typeParts.Length != 2)\n        {\n            throw new ArgumentException("Invalid generic type name format.");\n        }\n\n        var mainTypeName = typeParts[0].Trim();\n        var argumentTypeName = typeParts[1].Trim();\n\n        // Step 2: Find the corresponding types in the loaded assemblies\n        var mainType = FindType(mainTypeName);\n        var argumentType = FindType(argumentTypeName);\n\n        if (mainType == null || argumentType == null)\n        {\n            throw new TypeLoadException("Unable to find the specified types.");\n        }\n\n        // Step 3: Make the generic type and create an instance\n        var genericType = mainType.MakeGenericType(argumentType);\n        return Activator.CreateInstance(genericType);\n    }\n\n    private static Type FindType(string typeName)\n    {\n        var assemblies = AppDomain.CurrentDomain.GetAssemblies();\n        foreach (var assembly in assemblies)\n        {\n            var type = assembly.GetType(typeName);\n            if (type != null)\n            {\n                return type;\n            }\n        }\n        return null;\n    }\n}