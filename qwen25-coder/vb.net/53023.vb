Imports System.IO\nImports System.Threading\nImports System.Threading.Tasks\n\nPublic Class ResourceFileBuilder\n    Private Shared _outputFileStream As FileStream\n    Private Shared _lockObject As New Object()\n\n    Public Shared Sub BuildResourceFile(imageFiles As List(Of String), outputFile As String)\n        Using _outputFileStream = New FileStream(outputFile, FileMode.Create, FileAccess.Write, FileShare.None)\n            Dim tasks(0 To imageFiles.Count - 1) As Task\n            For i As Integer = 0 To imageFiles.Count - 1\n                Dim fileIndex = i\n                tasks(i) = Task.Run(Sub() ProcessImage(imageFiles(fileIndex)))\n            Next\n\n            ' Wait for all threads to finish.\n            Task.WaitAll(tasks)\n        End Using\n    End Sub\n\n    Private Shared Sub ProcessImage(imagePath As String)\n        Using inputStream As FileStream = New FileStream(imagePath, FileMode.Open, FileAccess.Read, FileShare.None)\n            Dim buffer(inputStream.Length - 1) As Byte\n            inputStream.Read(buffer, 0, CInt(inputStream.Length))\n\n            ' Imagine CompressData is a method that compresses the image data.\n            Dim compressedBuffer = CompressData(buffer)\n\n            ' Write to output file with thread-safe locking.\n            SyncLock _lockObject\n                _outputFileStream.Write(compressedBuffer, 0, compressedBuffer.Length)\n            End SyncLock\n        End Using\n    End Sub\n\n    Private Shared Function CompressData(data As Byte()) As Byte()\n        ' Replace this placeholder with actual compression logic.\n        Return data\n    End Function\nEnd Class