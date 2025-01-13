public void InitializeGridEvents()\n     {\n         virtualGrid.CellValueChanged += OnGridViewCellUpdated;\n     }\n\n     private void OnGridViewCellUpdated(object sender, VirtualDataGridViewEventArgs e)\n     {\n         presenter.OnUserCellUpdate(e.Cell.Row, e.Cell.Column, e.Cell.Value);\n     }