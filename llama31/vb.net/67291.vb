If ListBox1.SelectedItem IsNot Nothing Then\n    MessageBox.Show("You selected " & ListBox1.SelectedItem.ToString())\nElse\n    MessageBox.Show("Please select an item.")\nEnd If