// In your search control, set the PostBackUrl property to a new page\n// that handles the search request\nPostBackUrl = "~/SearchResults.aspx";\n\n// In the SearchResults.aspx page, add the following code to handle the postback\nprotected void Page_Load(object sender, EventArgs e)\n{\n    if (Request.Form["SearchQuery"] != null)\n    {\n        // Process the search query here\n    }\n}