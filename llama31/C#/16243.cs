using Microsoft.CSharp;\nusing System.CodeDom.Compiler;\n\n// Create a C# script\nstring script = "using System; class Test { public static void Main() { Console.WriteLine(\"Hello\"); } }";\n\n// Compile and execute the script\nCSharpCodeProvider provider = new CSharpCodeProvider();\nCompilerParameters parameters = new CompilerParameters();\nparameters.GenerateInMemory = true;\nparameters.GenerateExecutable = false;\n\nCompilerResults results = provider.CompileAssemblyFromSource(parameters, script);\n\nif (results.Errors.Count == 0)\n{\n    Assembly assembly = results.CompiledAssembly;\n    Type type = assembly.GetType("Test");\n    MethodInfo method = type.GetMethod("Main");\n    method.Invoke(null, null);\n}