int columns = 3;\nint index = 0;\n\nforeach (var item in myItemCollection)\n{\n    if (index % columns == 0)\n    {\n        Response.Write("<ul>");\n    }\n\n    Response.Write("<li>" + HttpUtility.HtmlEncode(item.someProperty) + "</li>");\n\n    index++;\n\n    if (index % columns == 0 || index == myItemCollection.Count)\n    {\n        Response.Write("</ul>");\n    }\n}