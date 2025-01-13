var il = method.GetILGenerator();\n\n// Load the TextWriter (ldarg.0)\nil.Emit(OpCodes.Ldarg_0);\n\n// Load the MyClass instance (ldarg.1)\nil.Emit(OpCodes.Ldarg_1);\n\n// Load the 'FirstName' field\nil.Emit(OpCodes.Ldfld, typeof(MyClass).GetField("FirstName"));\n\n// Call 'Write' method on TextWriter\nil.Emit(OpCodes.Callvirt, typeof(TextWriter).GetMethod("Write", new Type[] { typeof(string) }));\n\n// Repeat for 'LastName'\nil.Emit(OpCodes.Ldarg_0);\nil.Emit(OpCodes.Ldarg_1);\nil.Emit(OpCodes.Ldfld, typeof(MyClass).GetField("LastName"));\nil.Emit(OpCodes.Callvirt, typeof(TextWriter).GetMethod("Write", new Type[] { typeof(string) }));\n\n// Repeat for 'Age'\nil.Emit(OpCodes.Ldarg_0);\nil.Emit(OpCodes.Ldarg_1);\nil.Emit(OpCodes.Ldfld, typeof(MyClass).GetField("Age"));\nil.Emit(OpCodes.Callvirt, typeof(TextWriter).GetMethod("Write", new Type[] { typeof(int) }));\n\n// Return\nil.Emit(OpCodes.Ret);