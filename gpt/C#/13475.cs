// Load data into DataGridView\nprivate void Form1_Load(object sender, EventArgs e)\n{\n    // Assuming you have a DataSet named dataSet1 and a TableAdapter named tableAdapter1\n    this.tableAdapter1.Fill(this.dataSet1.YourTableName);\n    bindingSource1.DataSource = dataSet1.YourTableName;\n    dataGridView1.DataSource = bindingSource1;\n}\n\n// Save changes made in DataGridView to the database\nprivate void SaveButton_Click(object sender, EventArgs e)\n{\n    try\n    {\n        // End edit to commit changes to the DataTable\n        bindingSource1.EndEdit();\n        \n        // Update the database\n        tableAdapter1.Update(dataSet1.YourTableName);\n        \n        MessageBox.Show("Changes saved successfully.");\n    }\n    catch (Exception ex)\n    {\n        MessageBox.Show("An error occurred: " + ex.Message);\n    }\n}