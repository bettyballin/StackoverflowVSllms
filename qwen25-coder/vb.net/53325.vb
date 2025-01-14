Public Sub FeaturedBook(ThemeID As Integer)\n    Dim Books As New BookCollection(True)\n    Books.ListByThemeFeatured(ThemeID, 1) ' Fills the collection\n\n    If Books.Count > 0 Then\n        Dim firstBook As BookEntity = Books(0)\n        Me.Title = firstBook.Title\n        Me.Author = firstBook.Author\n        Me.ISBN = firstBook.ISBN\n        ' Copy other properties as necessary\n    End If\nEnd Sub