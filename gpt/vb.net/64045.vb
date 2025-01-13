Imports System.Windows.Forms\n\nPublic Class Form1\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' Create a new DataGridView control\n        Dim dataGridView As New DataGridView()\n        dataGridView.Dock = DockStyle.Fill\n        Me.Controls.Add(dataGridView)\n\n        ' Create columns for the DataGridView\n        Dim nameColumn As New DataGridViewTextBoxColumn()\n        nameColumn.HeaderText = "Name"\n        nameColumn.ReadOnly = True\n\n        Dim inputColumn As New DataGridViewTextBoxColumn()\n        inputColumn.HeaderText = "Input (1-4)"\n\n        dataGridView.Columns.Add(nameColumn)\n        dataGridView.Columns.Add(inputColumn)\n\n        ' Add rows with names\n        For i As Integer = 1 To 100\n            dataGridView.Rows.Add("Name " & i.ToString(), "")\n        Next\n\n        ' Set up event handler to validate input\n        AddHandler dataGridView.CellValidating, AddressOf DataGridView_CellValidating\n    End Sub\n\n    Private Sub DataGridView_CellValidating(sender As Object, e As DataGridViewCellValidatingEventArgs)\n        Dim dataGridView As DataGridView = CType(sender, DataGridView)\n\n        ' Only validate input column\n        If e.ColumnIndex = 1 Then\n            Dim input As String = e.FormattedValue.ToString()\n            Dim number As Integer\n\n            If Not Integer.TryParse(input, number) OrElse number < 1 OrElse number > 4 Then\n                e.Cancel = True\n                MessageBox.Show("Please enter a number between 1 and 4.")\n            End If\n        End If\n    End Sub\nEnd Class