Public Function GetCache(Of T)(ByVal tag As String) As T\n    Return CType(System.Web.HttpContext.Current.Cache(tag), T)\nEnd Functio