Imports EnvDTE\nImports EnvDTE80\n\nPublic Module CodeGenerator\n    Sub GenerateCodeForActiveLanguage()\n        Dim dte As DTE2 = CType(DTE, DTE2)\n        Dim doc As Document = dte.ActiveDocument\n        Dim window As Window = doc.ActiveWindow\n        Dim control As Object = window.Object\n\n        If TypeOf control Is WindowFrames Then\n            Dim windowFrames As WindowFrames = CType(control, WindowFrames)\n            For Each frame As WindowFrame In windowFrames\n                If TypeOf frame.ContentObject Is CodeWindow Then\n                    Dim codeWindow As CodeWindow = CType(frame.ContentObject, CodeWindow)\n                    Dim projectItemFileKind As String = codeWindow.ProjectItem.FileCodeModel.Language\n\n                    Select Case projectItemFileKind.ToLower()\n                        Case "vb"\n                            ' Generate VB code\n                            Debug.WriteLine("Generating VB code")\n                            ' Add your VB code generation logic here\n\n                        Case "csharp"\n                            ' Generate C# code\n                            Debug.WriteLine("Generating C# code")\n                            ' Add your C# code generation logic here\n\n                        Case Else\n                            Debug.WriteLine("Unsupported language")\n                    End Select\n                End If\n            Next\n        End If\n    End Sub\nEnd Module