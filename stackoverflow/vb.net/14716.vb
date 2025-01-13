Public Class AccessControl\n\n    Public Shared Function AuthenticateUser(ByVal id As String, ByVal password As String) As Boolean\n        Dim path As String\n        Dim username As String\n        Dim userRoot As DirectoryEntry\n\n        path = GetUserPath(id)\n\n        If path.Length = 0 Then\n            Return False\n        End If\n\n        username = path.Split("/")(3)\n        userRoot = New DirectoryEntry(path, username, password, AuthenticationTypes.None)\n\n        Try\n            userRoot.RefreshCache()\n            Return True\n        Catch ex As Exception\n            ' Catching Exception might be accepted way of determining user is not authenticated for this case\n            ' TODO: Would be better to test for specific exception type to ensure this is the reason\n            Return False\n        End Try\n    End Function\n\n    Private Shared Function GetUserPath(ByVal id As String) As String\n        Dim results As SearchResultCollection\n        Dim propertiesToLoad As String()\n\n        propertiesToLoad = New String() {"cn"}\n        results = GetSearchResultsForCommonName(id, propertiesToLoad)\n\n        If results.Count = 0 Then\n            Return String.Empty\n        Else\n            Debug.Assert(results.Count = 1)\n            Return results(0).Path\n        End If\n    End Function\n\n    Public Shared Function GetUserInfo(ByVal id As String) As UserInfo\n        Dim results As SearchResultCollection\n        Dim propertiesToLoad As String()\n\n        propertiesToLoad = New String() {"id", "sn", "mail", "givenname", "container", "cn"}\n        results = GetSearchResultsForCommonName(id, propertiesToLoad)\n\n        If results.Count = 0 Then\n            Return New UserInfo\n        End If\n\n        Debug.Assert(results.Count = 1)\n        Return CreateUser(results(0).GetDirectoryEntry().Properties)\n    End Function\n\n    Public Shared Function IsMemberOfGroup(ByVal id As String, ByVal group As String) As Boolean\n        Dim allMembersOfGroup As List(Of String)\n        allMembersOfGroup = GetMembersOfGroup(group)\n        Return allMembersOfGroup.Contains(id.ToLowerInvariant)\n    End Function\n\n    Public Shared Function GetMembersOfGroup(ByVal group As String) As List(Of String)\n        Dim results As SearchResultCollection\n        Dim propertiesToLoad As String()\n\n        propertiesToLoad = New String() {"cn", "member"}\n        results = GetSearchResultsForCommonName(group, propertiesToLoad)\n\n        Return ConvertMemberPropertiesToList(results)\n    End Function\n\n    Private Shared Function GetStringValueForPropertyName(ByVal properties As PropertyCollection, ByVal propertyName As String) As String\n        Return properties(propertyName).Item(0).ToString\n    End Function\n\n    Private Shared Function CreateUser(ByVal userProperties As PropertyCollection) As UserInfo\n        Dim user As New UserInfo(userProperties("id").Value)\n        With user\n            .EmailAddress = GetStringValueForPropertyName(userProperties, "mail")\n            .FirstName = GetStringValueForPropertyName(userProperties, "givenname")\n            .LastName = GetStringValueForPropertyName(userProperties, "sn")\n            .OfficeLocation = GetStringValueForPropertyName(userProperties, "container")\n        End With\n        Return user\n    End Function\n\n    Private Shared Function GetValueFromMemberProperty(ByVal member As String) As String\n        Return member.Substring(3, member.IndexOf(",") - 3).ToLowerInvariant\n    End Function\n\n    Private Shared Function ConvertMemberPropertiesToList(ByVal results As SearchResultCollection) As List(Of String)\n        Dim result As SearchResult\n        Dim memberProperties As PropertyValueCollection\n        Dim groupMembers As List(Of String)\n\n        groupMembers = New List(Of String)\n        For Each result In results\n            memberProperties = result.GetDirectoryEntry().Properties("member")\n            For i As Integer = 0 To memberProperties.Count - 1\n                groupMembers.Add(GetValueFromMemberProperty(memberProperties.Item(i).ToString))\n            Next\n        Next\n        Return groupMembers\n    End Function\n\n    Private Shared Function GetSearchResultsForCommonName(ByVal commonName As String, ByVal propertiesToLoad() As String) As SearchResultCollection\n        Dim results As SearchResultCollection\n        Dim searcher As New DirectorySearcher\n        With searcher\n            .SearchRoot = GetDefaultSearchRoot()\n            .PropertiesToLoad.AddRange(propertiesToLoad)\n            .Filter = String.Format("cn={0}", commonName)\n            results = .FindAll()\n        End With\n        Return results\n    End Function\n\n    Private Shared Function GetDefaultSearchRoot() As DirectoryEntry\n        Return New DirectoryEntry("LDAP://XXXXX/O=YYYY", String.Empty, String.Empty, AuthenticationTypes.None)\n    End Function\n\nEnd Class