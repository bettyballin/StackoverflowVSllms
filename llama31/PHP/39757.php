$shell = new COM('WScript.Shell');\n$shortcut = $shell->CreateShortcut('C:\\path\\to\\shortcut.lnk');\n$shortcut->TargetPath = 'C:\\path\\to\\target\\file.txt';\n$shortcut->Save();