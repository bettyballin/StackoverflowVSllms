ComponentArt.Web.UI.Grid grid = (ComponentArt.Web.UI.Grid)Page.FindControl("YourGridName");\ngrid.SearchFilterText = string.Empty;\ngrid.SearchFilterActive = false;\ngrid.DataBind();