SELECT \n    Mid(FullPath, InStrRev(Mid(FullPath & "\", 1, Len(FullPath) - (Len(FullPath) - InStrRev(FullPath, "\")) + 1), "\\", -1) + 1) AS FileName\nFROM \n    YourTableName;