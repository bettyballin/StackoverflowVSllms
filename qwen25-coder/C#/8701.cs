using System.IO;\nusing System.Web.UI;\nusing System.Web.Services;\n\n[WebMethod]\npublic string Table_Maker()\n{\n    HtmlTable tbl = new HtmlTable();\n    HtmlTableCell cell = new HtmlTableCell();\n    HtmlTableRow row = new HtmlTableRow();\n    cell.InnerText = "WhateverText";\n    row.Cells.Add(cell);\n    tbl.Rows.Add(row);\n\n    // Render the control to a StringWriter\n    var writer = new StringWriter();\n    using (var htmlWriter = new HtmlTextWriter(writer))\n    {\n        tbl.RenderControl(htmlWriter);\n    }\n\n    return writer.ToString();\n}