using System;\nusing System.IO;\nusing System.Windows.Forms;\n\npublic class CustomFileDialog : Form {\n    private ListView listView;\n    private Button btnOpen;\n    private FolderBrowserDialog folderDialog;\n    private TextBox txtPath;\n\n    public string SelectedFilePath { get; private set; }\n\n    public CustomFileDialog() {\n        this.Text = "Select a File";\n        this.Size = new System.Drawing.Size(600, 400);\n\n        listView = new ListView();\n        listView.Dock = DockStyle.Fill;\n        listView.View = View.List;\n\n        txtPath = new TextBox();\n        txtPath.Dock = DockStyle.Top;\n\n        btnOpen = new Button();\n        btnOpen.Text = "Open";\n        btnOpen.Dock = DockStyle.Bottom;\n        btnOpen.Click += BtnOpen_Click;\n\n        folderDialog = new FolderBrowserDialog();\n\n        this.Controls.Add(listView);\n        this.Controls.Add(txtPath);\n        this.Controls.Add(btnOpen);\n\n        txtPath.KeyDown += TxtPath_KeyDown;\n    }\n\n    private void TxtPath_KeyDown(object sender, KeyEventArgs e) {\n        if (e.KeyCode == Keys.Enter) {\n            LoadFiles();\n            e.Handled = true;\n        }\n    }\n\n    private void BtnOpen_Click(object sender, EventArgs e) {\n        if (folderDialog.ShowDialog() == DialogResult.OK) {\n            txtPath.Text = folderDialog.SelectedPath;\n            LoadFiles();\n        }\n    }\n\n    private void LoadFiles() {\n        listView.Items.Clear();\n        try {\n            foreach (var file in Directory.GetFiles(txtPath.Text)) {\n                listView.Items.Add(Path.GetFileName(file));\n            }\n        } catch { /* Handle exceptions */ }\n    }\n\n    [STAThread]\n    static void Main() {\n        Application.EnableVisualStyles();\n        var dialog = new CustomFileDialog();\n        if (dialog.ShowDialog() == DialogResult.OK) {\n            MessageBox.Show("Selected file: " + dialog.SelectedFilePath);\n        }\n    }\n\n    private void listView_ItemSelectionChanged(object sender, ListViewItemSelectionChangedEventArgs e) {\n        if (e.IsSelected && listView.SelectedItems.Count > 0) {\n            SelectedFilePath = Path.Combine(txtPath.Text, listView.SelectedItems[0].Text);\n            btnOpen.DialogResult = DialogResult.OK;\n        } else {\n            btnOpen.DialogResult = DialogResult.None;\n        }\n    }\n}