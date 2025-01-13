using System;\nusing System.Data;\nusing System.Windows.Forms;\n\npublic class MainForm : Form\n{\n    private DataGridView dataGridView;\n    private DataTable dataTable;\n\n    public MainForm()\n    {\n        InitializeComponent();\n        InitializeDataGridView();\n        InitializeDataTable();\n        BindData();\n    }\n\n    private void InitializeComponent()\n    {\n        this.dataGridView = new DataGridView();\n        this.SuspendLayout();\n        // \n        // dataGridView\n        // \n        this.dataGridView.Dock = DockStyle.Fill;\n        this.dataGridView.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;\n        this.Controls.Add(this.dataGridView);\n        // \n        // MainForm\n        // \n        this.ClientSize = new System.Drawing.Size(800, 450);\n        this.Name = "MainForm";\n        this.ResumeLayout(false);\n    }\n\n    private void InitializeDataGridView()\n    {\n        this.dataGridView = new DataGridView();\n        this.dataGridView.Dock = DockStyle.Fill;\n    }\n\n    private void InitializeDataTable()\n    {\n        this.dataTable = new DataTable();\n        this.dataTable.Columns.Add("ID", typeof(int));\n        this.dataTable.Columns.Add("Name", typeof(string));\n\n        // Adding some initial data\n        this.dataTable.Rows.Add(1, "Alice");\n        this.dataTable.Rows.Add(2, "Bob");\n    }\n\n    private void BindData()\n    {\n        BindingSource bindingSource = new BindingSource();\n        bindingSource.DataSource = this.dataTable;\n        this.dataGridView.DataSource = bindingSource;\n\n        // Subscribe to the DataTable's RowChanged event\n        this.dataTable.RowChanged += (s, e) => bindingSource.ResetBindings(false);\n        this.dataTable.RowDeleted += (s, e) => bindingSource.ResetBindings(false);\n    }\n\n    [STAThread]\n    public static void Main()\n    {\n        Application.EnableVisualStyles();\n        Application.SetCompatibleTextRenderingDefault(false);\n        Application.Run(new MainForm());\n    }\n}