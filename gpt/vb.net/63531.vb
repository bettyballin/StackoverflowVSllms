Imports System.IO\nImports System.IO.Compression\n\nPublic Sub ZipFolder(sourceFolder As String, destinationZipFile As String)\n    Try\n        If File.Exists(destinationZipFile) Then\n            File.Delete(destinationZipFile)\n        End If\n        ZipFile.CreateFromDirectory(sourceFolder, destinationZipFile, CompressionLevel.Fastest, False)\n    Catch ex As Exception\n        ' Log the exception\n        Throw\n    End Try\nEnd Sub