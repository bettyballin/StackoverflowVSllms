Dim db As New linqclassesDataContext\nDim categories = From c In db.faq_cats\n                 Select New With {\n                     .Category = c.category.Replace("&amp;", "&"),\n                     .CategoryID = c.category_id\n                 }\n\nNewFaqDropDownCategory.DataSource = categories\nNewFaqDropDownCategory.DataTextField = "Category"\nNewFaqDropDownCategory.DataValueField = "CategoryID"\n\nIf Not Page.IsPostBack Then\n    NewFaqDropDownCategory.DataBind()\nEnd If\n\n' It's assumed that Unset is a custom method to dispose of resources,\n' which is not standard in VB.NET, consider using Dispose instead.\n' Unset(categories) \n' Unset(db)\ndb.Dispose()