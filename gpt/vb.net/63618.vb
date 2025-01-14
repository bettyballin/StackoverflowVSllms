Imports System.DirectoryServices\n\nPublic Interface ILdapService\n    Function AuthenticateUser(id As String, password As String) As Boolean\n    Function GetUserPath(id As String) As String\nEnd Interface\n\nPublic Class LdapService\n    Implements ILdapService\n\n    Private ReadOnly _ldapPath As String\n\n    Public Sub New(ldapPath As String)\n        _ldapPath = ldapPath\n    End Sub\n\n    Public Function AuthenticateUser(id As String, password As String) As Boolean Implements ILdapService.AuthenticateUser\n        Dim path As String = GetUserPath(id)\n        If path IsNot Nothing Then\n            Dim username As String = path.Split("/"c)(3)\n            Dim userRoot As New DirectoryEntry(path, username, password, AuthenticationTypes.None)\n            Try\n                userRoot.RefreshCache()\n                Return True\n            Catch ex As Exception\n                ' Log exception\n                Return False\n            End Try\n        Else\n            Return False\n        End If\n    End Function\n\n    Public Function GetUserPath(id As String) As String Implements ILdapService.GetUserPath\n        Dim root As New DirectoryEntry(_ldapPath, String.Empty, String.Empty, AuthenticationTypes.None)\n        Dim searcher As New DirectorySearcher(root)\n        searcher.Filter = $"(sAMAccountName={id})"\n        searcher.SearchScope = SearchScope.Subtree\n\n        Try\n            Dim result As SearchResult = searcher.FindOne()\n            If result IsNot Nothing Then\n                Return result.Path\n            End If\n        Catch ex As Exception\n            ' Log exception\n        End Try\n\n        Return Nothing\n    End Function\nEnd Class