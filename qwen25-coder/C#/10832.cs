using System.Web.UI.HtmlControls;\nusing System.Text;\n\nprotected void Page_Load(object sender, EventArgs e)\n{\n    // Assuming you have a collection of data\n    var items = new List<string> { "Item 1", "Item 2", "Item 3" };\n\n    // Create a StringBuilder to efficiently build your HTML string\n    StringBuilder htmlBuilder = new StringBuilder();\n\n    // Begin the table\n    htmlBuilder.Append("<table border=\"1\">");\n    htmlBuilder.Append("<tr><th>Items</th></tr>");\n\n    // Iterate over the collection and add each item as a row in the table\n    foreach (var item in items)\n    {\n        htmlBuilder.AppendFormat("<tr><td>{0}</td></tr>", System.Web.HttpUtility.HtmlEncode(item));\n    }\n\n    // End the table\n    htmlBuilder.Append("</table>");\n\n    // Assuming you have an HTML control on your page with id="MyHtmlPlaceHolder"\n    MyHtmlPlaceHolder.InnerHtml = htmlBuilder.ToString();\n}