SELECT \n    Mid(FullPath, InStr(1, FullPath, "\\", -1) + 1) AS FileName\nFROM \n    YourTableName;