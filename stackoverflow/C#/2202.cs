const int numColumns = 3;\nconst int numColumns = 3;\nvar columnLength = (int)Math.Ceiling((double)myItemCollection.Count / 3);\n\nfor (int i = 0; i < myItemCollection.Count; i++)\n{\n    if (i % columnLength == 0)\n    {\n        if (i > 0)\n            Response.Write("</ul>");\n        Response.Write("<ul>");\n    }\n    Response.Write(myItemCollection[i].SomeProperty);\n}\n\nif (i % columnLength == 0)\n    Response.Write("</ul>");