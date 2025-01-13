Public Interface ICode(Of TCode)\n    ReadOnly Property CodeKey As String\n    ReadOnly Property Description As String\n\n    Function GetList() As List(Of TCode)\n    Function GetSpecific(code As TCode) As TCode\n    Sub SetProperties(code As TCode)\nEnd Interface