Partial Friend NotInheritable Class MySettings\n       Public WriteOnly Property RunTimeConnectionString() As String\n           Set(ByVal value As String)\n               My.Settings("MyConnectionString") = value\n           End Set\n       End Property\n   End Class