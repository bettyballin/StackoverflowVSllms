public override SiteMapNodeCollection GetNodes()\n{\n    // Create nodes programmatically\n    SiteMapNodeCollection nodes = new SiteMapNodeCollection();\n    foreach (var article in GetArticles())\n    {\n        SiteMapNode node = new SiteMapNode(this.Provider, article.Url);\n        node.Title = article.Title;\n        nodes.Add(node);\n    }\n    return nodes;\n}