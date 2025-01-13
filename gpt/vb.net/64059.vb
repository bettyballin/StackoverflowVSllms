Namespace YourNamespace\n    Partial Public Class DataContext\n        Inherits System.Data.Linq.DataContext\n\n        <Table(Name:="dbo.Concessions")>  _\n        Partial Public Class Concession\n            <Column(Storage:="_Country", DbType:="Char(2)")>  _\n            Public Property Country() As String\n                Get\n                    Return _Country\n                End Get\n                Set(ByVal value As String)\n                    _Country = value\n                End Set\n            End Property\n\n            ' Other properties and methods...\n        End Class\n\n        ' Other members of DataContext...\n    End Class\nEnd Namespace