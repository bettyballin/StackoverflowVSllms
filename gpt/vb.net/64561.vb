Function HasMethod(dllName, methodName)\n    On Error Resume Next\n    Dim typeLib\n    Set typeLib = CreateObject("TLI.TypeLibInfo")\n    typeLib.ContainingFile = dllName\n    \n    Dim i\n    Dim found\n    found = False\n    \n    For i = 1 To typeLib.TypeInfos.Count\n        Dim typeInfo\n        Set typeInfo = typeLib.TypeInfos(i)\n        If Not IsEmpty(typeInfo) Then\n            Dim j\n            For j = 1 To typeInfo.Members.Count\n                If typeInfo.Members(j).Name = methodName Then\n                    found = True\n                    Exit For\n                End If\n            Next\n        End If\n        If found Then Exit For\n    Next\n    \n    HasMethod = found\n    On Error GoTo 0\nEnd Function\n\n' Example usage:\nIf HasMethod("StdLib.DLL", "ReadFileE") Then\n    MsgBox "Method exists!"\nElse\n    MsgBox "Method does not exist."\nEnd If