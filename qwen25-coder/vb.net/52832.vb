' Assuming YourDataGrid is already populated with data.\n\n' Re-ordering columns by setting their DisplayIndex property.\n' For example, if you want InboundDate as the first column:\nYourDataGrid.Columns("InboundDate").DisplayIndex = 0\n\n' Setting Zip as the second column:\nYourDataGrid.Columns("Zip").DisplayIndex = 1\n\n' Setting manifestID as the third column:\nYourDataGrid.Columns("manifestID").DisplayIndex = 2\n\n' And so on for other columns...