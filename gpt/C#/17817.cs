string rawHtml = "<p>This is a paragraph</p>";\n    SPListItem item = list.Items.Add();\n    item["HtmlField"] = rawHtml; // HTML is stripped here\n    item.Update();