// WmiArchDetector.js\nvar wmi = new ActiveXObject("winmgmts:\\\\.\\root\\cimv2");\n\nfunction getSystemArchitecture()\n{\n    var query = "SELECT AddressWidth FROM Win32_Processor";\n    var results = wmi.ExecQuery(query);\n    var arch = "";\n    for (var i = 0; i < results.Count; i++)\n    {\n        var processor = results.ItemIndex(i);\n        if (processor.AddressWidth == 64)\n        {\n            arch = "x64";\n        }\n        else if (processor.AddressWidth == 32)\n        {\n            arch = "x86";\n        }\n    }\n    return arch;\n}