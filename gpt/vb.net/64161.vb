<Table(Name:="Users")> _\nPartial Public Class User\n\n    Private _TotalLogins As System.Nullable(Of Integer)\n\n    <Column(Name:="totalLogins", Storage:="_TotalLogins", DbType:="Int", UpdateCheck:=UpdateCheck.Never)> _\n    Public Property TotalLogins As System.Nullable(Of Integer)\n        Get\n            Return Me._TotalLogins\n        End Get\n        Private Set(value As System.Nullable(Of Integer))\n            Me._TotalLogins = value\n        End Set\n    End Property\n\nEnd Class