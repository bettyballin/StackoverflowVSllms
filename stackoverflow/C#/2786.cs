static bool HasNet35()\n{\n    try\n    {\n        AppDomain.CurrentDomain.Load(\n            "System.Core, Version=3.5.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089");\n        return true;\n    }\n    catch\n    {\n        return false;\n    }\n}