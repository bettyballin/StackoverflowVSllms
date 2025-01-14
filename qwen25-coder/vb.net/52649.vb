Public Sub Compress(ByVal infile As String, ByVal outfile As String)\n    Dim buffer(4096) As Byte ' Buffer size can be adjusted\n\n    Using sourceFile As FileStream = File.OpenRead(infile)\n        Using destFile As FileStream = File.Create(outfile)\n            Using compStream As New GZipStream(destFile, CompressionMode.Compress)\n                Dim bytesRead As Integer\n                While (bytesRead = sourceFile.Read(buffer, 0, buffer.Length)) > 0\n                    compStream.Write(buffer, 0, bytesRead)\n                End While\n            End Using ' Close and flush the GZipStream\n        End Using ' Close the destination file stream\n    End Using ' Close the source file stream\nEnd Sub