Dim textLine As String\nOpen "\\server\share\file.txt" For Input As #1\nDo Until EOF(1)  ' Loop until the end-of-file is reached.\n    Line Input #1, textLine   ' Read each line of the file into a variable.\n    Debug.Print textLine\nLoop\nClose #1       ' Close file after use.