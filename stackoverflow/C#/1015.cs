var filenameFormat = "FooBar{0}.xml";\nvar filename = string.Format(filenameFormat, "");\nint i = 1;\nwhile(File.Exists(filename))\n    filename = string.Format(filenameFormat, "(" + (i++) + ")");\n\nreturn filename;