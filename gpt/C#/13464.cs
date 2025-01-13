using System;\nusing System.Windows.Forms;\nusing ZedGraph;\n\nnamespace ZedGraphExample\n{\n    public partial class Form1 : Form\n    {\n        public Form1()\n        {\n            InitializeComponent();\n            CreateGraph(zedGraphControl1);\n        }\n\n        private void CreateGraph(ZedGraphControl zgc)\n        {\n            GraphPane myPane = zgc.GraphPane;\n\n            // Set the titles and axis labels\n            myPane.Title.Text = "My Test Graph";\n            myPane.XAxis.Title.Text = "X Axis";\n            myPane.YAxis.Title.Text = "Y Axis";\n\n            // Generate some data points\n            PointPairList list = new PointPairList();\n            for (int i = 0; i < 36; i++)\n            {\n                double x = (double)i + 5;\n                double y = 3.0 * Math.Sin((double)i * Math.PI / 15.0);\n                list.Add(x, y);\n            }\n\n            // Create a curve\n            LineItem myCurve = myPane.AddCurve("My Curve",\n                  list, System.Drawing.Color.Blue, SymbolType.Diamond);\n\n            // Tell ZedGraph to refigure the axes since the data have changed\n            zgc.AxisChange();\n        }\n\n        private void Form1_Load(object sender, EventArgs e)\n        {\n            // Optionally configure ZedGraphControl properties\n            zedGraphControl1.IsShowPointValues = true;\n        }\n    }\n}