Dim db As New LINQtoSQLDataContext()\n\nDim oArticle As New article()\noArticle.Body = "Some Text"\noArticle.Title = "Some Title"\noArticle.Author = "Some Author"\n\ndb.articles.InsertOnSubmit(oArticle) ' This line adds the new record\ndb.SubmitChanges() ' This line saves the changes to the database