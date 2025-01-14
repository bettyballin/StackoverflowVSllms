Imports System.Security.Cryptography\nImports System.Linq\n\nModule Module1\n    Sub Main()\n        Dim files As New List(Of IO.FileInfo)()\n        ' Assuming you populate your files list here, for example:\n        ' files.Add(New IO.FileInfo("file1.txt"))\n        ' files.Add(New IO.FileInfo("file2.txt"))\n        ' ...\n\n        Shuffle(files)\n\n        For Each file In files\n            Console.WriteLine(file.Name)\n        Next\n    End Sub\n\n    Private Shared Sub Shuffle(Of T)(items As List(Of T))\n        Dim rng As New RNGCryptoServiceProvider()\n        Dim n As Integer = items.Count\n        While n > 1\n            Dim box(0 To 3) As Byte\n            rng.GetBytes(box)\n            Dim k As Integer = BitConverter.ToInt32(box, 0) And (n - 1)\n            n -= 1\n            Dim value As T = items(n)\n            items(n) = items(k)\n            items(k) = value\n        End While\n    End Sub\nEnd Module