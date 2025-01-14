Module UserExtensions\n    <System.Runtime.CompilerServices.Extension>\n    Public Function GetUser(dc As MyDataContext, UserID As Integer) As User\n        Return (From u In dc.Users Where u.ID = UserID).SingleOrDefault()\n    End Function\nEnd Module\n\n' Usage:\nDim context As New MyDataContext()\nDim user As User = context.GetUser(1)