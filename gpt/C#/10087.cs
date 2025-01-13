protected void Page_Load(object sender, EventArgs e)\n{\n    string currentUrl = HttpContext.Current.Request.Url.AbsolutePath;\n    SiteMapNode currentNode = SiteMap.Provider.FindSiteMapNode(currentUrl);\n\n    if (currentNode != null)\n    {\n        // Set the current node\n        SiteMap.CurrentNode = currentNode;\n    }\n}