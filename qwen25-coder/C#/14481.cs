using System;\nusing System.Data;\nusing System.Linq;\nusing HtmlAgilityPack;\n\nclass Program\n{\n    static void Main()\n    {\n        string htmlContent = @"<table border='0' width='100%'>\n            <tr class='headerbg'>\n                <th width='5%'>No</th>\n                <th width='30%'>Name</th>\n                <th width='20%'>Department or Division</th>\n                <th width='25%'>Email</th>\n                <th width='20%'>Staff/Student</th>\n            </tr>\n            <tr class='bg2'>\n                <td>1</td>\n                <td><strong><a class='searchLink2' href='tel_search.php?fore=Dave&sur=Rumber'>Dave Rumber</a></strong></td>\n                <td>Medical School</td>\n                <td><a class='searchLink2' href='mailto:Dave.Rumber@Home.com'>Dave.Rumber@Home.com</a></td>\n                <td>Student&nbsp;</td>\n            </tr>\n        </table>";\n\n        HtmlDocument htmlDoc = new HtmlDocument();\n        htmlDoc.LoadHtml(htmlContent);\n\n        var tableNodes = htmlDoc.DocumentNode.SelectSingleNode("//table");\n\n        // Create a DataTable to hold the results\n        DataTable dataTable = new DataTable();\n        dataTable.Columns.Add("Name");\n        dataTable.Columns.Add("Email");\n\n        foreach (var row in tableNodes.SelectNodes(".//tr"))\n        {\n            if (!row.HasChildNodes)\n                continue;\n\n            var nameNode = row.SelectSingleNode("td[2]/a");\n            if (nameNode != null)\n            {\n                string name = nameNode.InnerText.Trim();\n                string emailNodeHref = row.SelectSingleNode("td[4]/a/@href").Value;\n                string email = emailNodeHref.Replace("mailto:", "").Trim();\n\n                dataTable.Rows.Add(name, email);\n            }\n        }\n\n        // Display the DataTable\n        foreach (DataRow dataRow in dataTable.Rows)\n        {\n            Console.WriteLine($"Name: {dataRow["Name"]}, Email: {dataRow["Email"]}");\n        }\n    }\n}