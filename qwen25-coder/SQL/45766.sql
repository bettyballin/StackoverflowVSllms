SELECT \n    Mid(FullPath, InStrRev(Mid(FullPath & "\", 1, Len(FullPath) - (Len(FullPath) - InStrRev(FullPath, "\")) + 1), "\\", -1) + 1) AS FileName\nFROM \n    YourTableName;\n\nSELECT \n    Mid(\n        FullPath,\n        IIf(\n            InStrRev(FullPath, "\\") > InStrRev(FullPath, "/"),\n            InStrRev(FullPath, "\\") + 1,\n            InStrRev(FullPath, "/") + 1\n        )\n    ) AS FileName\nFROM \n    YourTableName;