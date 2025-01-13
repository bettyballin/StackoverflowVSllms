Private Sub AddToList(ByVal targetDirectory As String, ByVal boolFiles As Boolean, Optional ByVal recur As Boolean = False, Optional ByVal parentNode As TreeNode = Nothing)\n\n    Dim directoryNode As New TreeNode(targetDirectory)\n\n    If parentNode Is Nothing Then\n        TreeView1.Nodes.Add(directoryNode)\n    Else\n        parentNode.Nodes.Add(directoryNode)\n    End If\n\n    ' Add subdirectories\n    If Directory.GetDirectories(targetDirectory).Length > 0 Then\n        Dim subdirectoryEntries As String() = Directory.GetDirectories(targetDirectory)\n        \n        For Each subdirectory In subdirectoryEntries\n            AddToList(subdirectory, boolFiles, recur, directoryNode)\n        Next\n    End If\n\n    ' Add files if boolFiles is True\n    If boolFiles Then\n        Dim fileEntries As String() = Directory.GetFiles(targetDirectory)\n        \n        For Each file In fileEntries\n            Dim fileNode As New TreeNode(Path.GetFileName(file))\n            directoryNode.Nodes.Add(fileNode)\n        Next\n    End If\n\nEnd Sub