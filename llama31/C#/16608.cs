yourDataTable.RowChanged += (sender, args) => dataGridView1.ResetBindings();\nyourDataTable.RowDeleted += (sender, args) => dataGridView1.ResetBindings();\nyourDataTable.TableNewRow += (sender, args) => dataGridView1.ResetBindings();