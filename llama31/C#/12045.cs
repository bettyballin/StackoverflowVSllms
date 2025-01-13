using System.Windows.Input;\n\npublic System.Windows.Input.Key? ResolveKey(char charToResolve)\n{\n    KeyConverter kc = new KeyConverter();\n    try\n    {\n        Key key = (Key)kc.ConvertFrom(charToResolve.ToString());\n        return Enum.IsDefined(typeof(Key), key) ? key : (Key?)null;\n    }\n    catch\n    {\n        return null;\n    }\n}