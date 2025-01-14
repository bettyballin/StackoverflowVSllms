Imports System.IO\n\nPublic Sub ListZipFiles(folderPath As String)\n    ' Get all .zip files in the directory and subdirectories\n    Dim zipFiles As String() = Directory.GetFiles(folderPath, "*.zip", SearchOption.AllDirectories)\n    \n    ' Loop through each file and print the path\n    For Each zipFile As String In zipFiles\n        Console.WriteLine(zipFile)\n    Next\nEnd Sub\n\n' Usage example:\nPublic Sub Main()\n    ListZipFiles("C:\YourParentFolder")\nEnd Sub