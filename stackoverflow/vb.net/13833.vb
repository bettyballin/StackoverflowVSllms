Public Function getSecureCookie(ByVal Request As HttpRequest) As String\n    Dim secureCookie As HttpCookie = Request.Cookies("Test")\n    If (Not (secureCookie) Is Nothing) Then\n        Return secureCookie.ToString\n    Else\n        Return ""\n    End If\nEnd Functio