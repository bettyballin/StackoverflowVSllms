using System;\nusing System.Collections.Generic;\nusing System.Linq;\nusing System.Xml.Linq;\nusing System.Web.UI.WebControls;\n\npublic partial class YourPage : System.Web.UI.Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        string xmlData = @"\n<data>\n    <food>\n        <id>1</id>\n        <name>asparagus</name>\n        <catlog>7190</catlog>\n    </food>\n    <food>\n        <id>2</id>\n        <name>almonds</name>\n        <catlog>7190</catlog>\n    </food>\n    <food>\n        <id>3</id>\n        <name>asparagus</name>\n        <catlog>7192</catlog>\n    </food>\n    <food>\n        <id>4</id>\n        <name>asparagus</name>\n        <catlog>7193</catlog>\n    </food>\n</data>";\n\n        XDocument xdoc = XDocument.Parse(xmlData);\n\n        var uniqueCatlogs = xdoc.Descendants("food")\n                                .Select(food => food.Element("catlog").Value)\n                                .Distinct()\n                                .ToList();\n\n        DropDownList1.DataSource = uniqueCatlogs;\n        DropDownList1.DataBind();\n    }\n}