Dim warnings As New List(Of String)()\n\nFor Each item In items\n  If o.ImageContent.ImageId = 0 Then\n    warnings.Add("Section: " & section.<header>.<title>.ToString() & " , Item: " & item.<title>.ToString())\n  End If\nNext\n\nreturnVar.Warnings = warnings.ToArray()