While dbRead.Read\n  dim sUserId as String= dbread('user_id')\n  For Each sFile As String In IO.Directory.GetFiles("C:\")\n    if sFile.StartsWith (sUserId) Then\n        'Do something.\n    End If\n  Next\nLoop