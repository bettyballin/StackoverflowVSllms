protected void btnFilter_Click(object sender, EventArgs e)\n{\n    string keyword = txtKeyword.Text.Replace("'", "''").Trim(); // Prevent basic XPath injection\n\n    if (!string.IsNullOrEmpty(keyword))\n    {\n        RSSFeedDataSource.XPath = $"/rss/channel/item[contains(title,\"{keyword}\")]";\n        RSSFeedDataSource.DataBind();\n    }\n}