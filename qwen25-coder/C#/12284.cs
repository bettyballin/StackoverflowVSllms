using System;\nusing System.Runtime.InteropServices;\n\n[Guid("EB46E31F-0961-4179-8A56-3895DDF2884E"), \nProgId("ScriptGeneratorExample.ScriptGenerator"),\nClassInterface(ClassInterfaceType.None),\nComVisible(true)]\npublic class ScriptGenerator : IScriptGenerator\n{\n    public void GetLastError(out string Error)\n    {\n        throw new NotImplementedException();\n    }\n    \n    public void Init()\n    {\n        // nothing to do\n    }\n}\n\n// Interface definition in C#\n[TypeLibType(4288)]\n[Guid("B60C546F-EE91-48A2-A352-CFC36E613CB7"), ComVisible(true)]\npublic interface IScriptGenerator\n{\n    [DispId(1610743813)]\n    void GetLastError(out string Error);\n    \n    [DispId(1610743808)]\n    void Init();\n}\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string progId = "ScriptGeneratorExample.ScriptGenerator";\n        try\n        {\n            Type comType = Type.GetTypeFromProgID(progId);\n            if (comType != null)\n            {\n                object comObj = Activator.CreateInstance(comType);\n                IScriptGenerator generator = comObj as IScriptGenerator;\n                if (generator != null)\n                {\n                    Console.WriteLine("Successfully cast to IScriptGenerator.");\n                }\n                else\n                {\n                    throw new InvalidCastException($"The script generator with the ProgID {progId} doesn't support the required interface - IScriptGenerator");\n                }\n            }\n            else\n            {\n                throw new ArgumentException($"The ProgID does not match a registered COM object", nameof(progId));\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("An error occurred: " + ex.Message);\n        }\n    }\n}