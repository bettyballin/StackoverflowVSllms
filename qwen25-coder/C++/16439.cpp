void AddFiles(const AnsiString& baseDir, const AnsiString& currentPath)\n{\n    TSearchRec sr;\n    int f;\n\n    // Construct the path to search\n    AnsiString fullPath = currentPath + "\\*.*";\n    \n    f = FindFirst(fullPath, faAnyFile, sr);\n    while (f == 0) {\n        if (sr.Attr & faDirectory) {\n            if ((sr.Name != ".") && (sr.Name != "..")) {\n                // Recurse into the directory\n                AddFiles(baseDir, currentPath + "\\" + sr.Name);\n            }\n        }\n        else {\n            // Add full path to ListBox or dataset\n            Form1->ListBox1->Items->Add(currentPath + "\\" + sr.Name);\n        }\n        f = FindNext(sr);\n    }\n    FindClose(sr);\n}\n\n// To call the function with the initial directory\nvoid StartSearch(const AnsiString& dir)\n{\n    AddFiles(dir, dir);\n}