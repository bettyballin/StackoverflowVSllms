Protected Sub ProductRepeater_ItemDataBound(ByVal sender As Object, ByVal e As System.Web.UI.WebControls.RepeaterItemEventArgs) Handles ProductRepeater.ItemDataBound\n    If e.Item.ItemType = ListItemType.Item Or e.Item.ItemType = ListItemType.AlternatingItem Then\n        Dim product As productItem = CType(e.Item.DataItem, productItem)\n        Dim productRender As ProductRender = CType(e.Item.FindControl("ProductRender1"), ProductRender)\n        productRender.BindProduct(product)\n    End If\nEnd Sub