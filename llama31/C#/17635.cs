[Guid("EB46E31F-0961-4179-8A56-3895DDF2884E"),\nProgId("ScriptGeneratorExample.ScriptGenerator"),\nClassInterface(ClassInterfaceType.AutoDual),\nComSourceInterfaces(typeof(SOAAPIOLELib.IScriptGeneratorCallback))]\npublic class ScriptGenerator : IScriptGenerator\n{\n    public void GetLastError(out string Error)\n    {\n        throw new NotImplementedException();\n    }\n    public void Init()\n    {\n        // nothing to do\n    }\n}