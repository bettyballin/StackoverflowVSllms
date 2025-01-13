<%@ Page Language="C#" %>\n<html xmlns="http://www.w3.org/1999/xhtml">\n<head runat="server">\n    <title>Check .NET 3.5 SP1</title>\n</head>\n<body>\n    <form id="form1" runat="server">\n        <div>\n            <% \n                // Check if Entity Framework classes are available\n                try {\n                    var assembly = System.Reflection.Assembly.Load("System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089");\n                    Response.Write("<p>.NET 3.5 SP1 with Entity Framework is installed.</p>");\n                } catch (Exception) {\n                    Response.Write("<p>.NET 3.5 SP1 or Entity Framework is not installed correctly.</p>");\n                }\n            %>\n        </div>\n    </form>\n</body>\n</html>