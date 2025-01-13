public partial class _Default : Page\n{\n    protected void Page_Load(object sender, EventArgs e)\n    {\n        if (!IsPostBack)\n        {\n            List<DataItem> dataList = new List<DataItem>\n            {\n                new DataItem { Value = 1 },\n                new DataItem { Value = 2 },\n                new DataItem { Value = 3 }\n            };\n\n            GridView1.DataSource = dataList;\n            GridView1.DataBind();\n        }\n    }\n\n    public class DataItem\n    {\n        public int Value { get; set; }\n    }\n}