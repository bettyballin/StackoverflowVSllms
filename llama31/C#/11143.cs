// Designer-generated code\nprivate void InitializeComponent()\n{\n    this.dataGridView1 = new System.Windows.Forms.DataGridView();\n    this.dataGridView1.DataSource = this.dataSet1;\n    // ...\n}\n\n// Optimized code\nprivate void InitializeComponent()\n{\n    this.dataGridView1 = new System.Windows.Forms.DataGridView();\n    this.dataGridView1.DataSource = this.dataSet1;\n    this.dataGridView1.AutoGenerateColumns = false;\n    this.dataGridView1.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;\n    // ...\n}