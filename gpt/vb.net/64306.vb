Public Interface ITypeCode(Of T)\n    Property CodeKey As T\n    Property Description As String\n    \n    Function GetList() As List(Of T)\n    Function GetSpecific(code As T) As T\n    Sub SetProperties(code As T, description As String)\nEnd Interface