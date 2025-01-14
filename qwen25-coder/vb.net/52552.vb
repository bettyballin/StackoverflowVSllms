Imports System.IO\n\nModule Module1\n    Sub Main()\n        Dim filePath As String = txtloanlistinput.Text ' Ensure this path is correct\n        Dim lines As List(Of String) = File.ReadAllLines(filePath).ToList()\n\n        For Each line In lines.Skip(1) ' Skip the header line\n            Dim parts As String() = line.Split(vbTab)\n            If parts(1).Trim() = "5 years" Then\n                lines.Add($"{parts(0)}{vbTab}1 month{vbTab}{parts(2)}")\n            End If\n        Next\n\n        File.WriteAllLines(filePath, lines) ' Write the modified list back to the file\n    End Sub\nEnd Module