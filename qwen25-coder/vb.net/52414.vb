' Assuming you have a Repeater control named Repeater1 on the parent page\n\n   Private Sub Page_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load\n       If Not IsPostBack Then\n           Dim products As New List(Of productItem)()\n           products.Add(New productItem("DVD Player", "It plays DVDs!", "some_thumb.jpg", 30))\n           ' Add more products as needed\n\n           Repeater1.DataSource = products\n           Repeater1.DataBind()\n       End If\n   End Sub\n\n   Public Class productItem\n       Public Property Title() As String\n       Public Property Description() As String\n       Public Property Thumbnail() As String\n       Public Property Id() As Integer\n\n       Public Sub New(ByVal title As String, ByVal description As String, ByVal thumbnail As String, ByVal id As Integer)\n           Me.Title = title\n           Me.Description = description\n           Me.Thumbnail = thumbnail\n           Me.Id = id\n       End Sub\n   End Class