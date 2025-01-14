Sub ReadRegistryValues()\n    Dim objShell As Object\n    Set objShell = CreateObject("WScript.Shell")\n    \n    Dim regPath As String\n    regPath = "HKEY_CURRENT_USER\YourBaseKey"\n    \n    ' Example array with registry keys\n    Dim Felter() As String\n    Felter = Array("Subkey1", "Subkey2", "NonExistentSubkey") ' Add your specific subkeys\n    \n    Dim iTeller As Integer\n    For iTeller = LBound(Felter) To UBound(Felter)\n        On Error Resume Next ' Enable error handling to skip on error\n        \n        ' Try to read the registry value\n        Dim sVerdi As String\n        sVerdi = objShell.RegRead(regPath & "\" & Felter(iTeller))\n        \n        If Err.Number <> 0 Then\n            ' Handle the error, e.g., log it or inform user\n            Debug.Print "Registry key not found: " & regPath & "\" & Felter(iTeller)\n            Err.Clear ' Clear the error object\n        Else\n            ' Insert sVerdi into your Word document at a predefined bookmark\n            With ActiveDocument.Bookmarks("BookmarkName" & iTeller).Range\n                .Text = sVerdi\n                .Characters(1).Select\n            End With\n        End If\n        \n        On Error GoTo 0 ' Disable error handling after checking\n    Next iTeller\n    \n    Set objShell = Nothing\nEnd Sub