try\n{\n    // ...\n}\nfinally\n{\n    Marshal.ReleaseCOMObject(oCamera);\n    Marshal.ReleaseCOMObject(oGE);\n}