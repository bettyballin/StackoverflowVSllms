using Mono.Cecil;\nusing Mono.Cecil.Cil;\n\npublic class Instrumentation\n{\n    public static void InstrumentAssembly(string assemblyPath)\n    {\n        var assembly = AssemblyDefinition.ReadAssembly(assemblyPath);\n        foreach (var module in assembly.Modules)\n        {\n            foreach (var type in module.Types)\n            {\n                foreach (var method in type.Methods)\n                {\n                    if (method.HasBody)\n                    {\n                        var ilProcessor = method.Body.GetILProcessor();\n                        var writeLineMethod = typeof(Console).GetMethod("WriteLine", new[] { typeof(string) });\n                        var writeLineReference = module.ImportReference(writeLineMethod);\n\n                        ilProcessor.InsertBefore(method.Body.Instructions[0], ilProcessor.Create(OpCodes.Ldstr, $"Entering {method.FullName}"));\n                        ilProcessor.InsertAfter(method.Body.Instructions[0], ilProcessor.Create(OpCodes.Call, writeLineReference));\n                    }\n                }\n            }\n        }\n\n        assembly.Write("InstrumentedAssembly.dll");\n    }\n}