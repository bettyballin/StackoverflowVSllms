Imports System.Data\n\n' Custom DataColumn class with additional property\nPublic Class CarColumn\n    Inherits DataColumn\n\n    Public Property Foo As String\nEnd Class\n\n' Custom DataTable class with additional property\nPublic Class CarTable\n    Inherits DataTable\n\n    Public Property Bar As String\n\n    ' Override the NewRowFromBuilder method to return a custom DataRow\n    Protected Overrides Function NewRowFromBuilder(builder As DataRowBuilder) As DataRow\n        Return New CarRow(builder)\n    End Function\n\n    ' Custom DataRow class to hold CarColumn\n    Public Class CarRow\n        Inherits DataRow\n\n        Friend Sub New(builder As DataRowBuilder)\n            MyBase.New(builder)\n        End Sub\n\n        Default Public Shadows Property Item(column As CarColumn) As Object\n            Get\n                Return MyBase.Item(column)\n            End Get\n            Set(value As Object)\n                MyBase.Item(column) = value\n            End Set\n        End Property\n    End Class\nEnd Class\n\n' Custom DataSet class\nPublic Class CarSet\n    Inherits DataSet\n\n    Public Sub New()\n        MyBase.New()\n        Tables.Add(New CarTable())\n    End Sub\n\n    Public ReadOnly Property CarTable(index As Integer) As CarTable\n        Get\n            Return CType(Tables(index), CarTable)\n        End Get\n    End Property\nEnd Class\n\n' Example usage\nSub Main()\n    Dim carSet As New CarSet()\n    Dim carTable As CarTable = carSet.CarTable(0)\n    carTable.Bar = "Example"\n\n    Dim carColumn As New CarColumn()\n    carColumn.Foo = "Column Foo"\n    carTable.Columns.Add(carColumn)\n\n    Dim newRow As CarTable.CarRow = CType(carTable.NewRow(), CarTable.CarRow)\n    newRow.Item(carColumn) = "Car Data"\n    carTable.Rows.Add(newRow)\n\n    Console.WriteLine(carSet.CarTable(0).Columns(0).ColumnName) ' Outputs the column name\n    Console.WriteLine(carSet.CarTable(0).Bar) ' Outputs "Example"\n    Console.WriteLine(newRow(carColumn)) ' Outputs "Car Data"\nEnd Sub