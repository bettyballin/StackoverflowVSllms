<DataContract()> _\nPublic Class Employee\n    <DataMember()> _\n    Public Property EmployeeID As Integer\n\n    <DataMember()> _\n    Public Property LastName As String\n\n    ' Parameterless constructor required by WCF\n    Public Sub New()\n    End Sub\n\n    ' Factory method to initialize the object with parameters\n    Public Shared Function Create(employeeID As Integer) As Employee\n        Dim emp As New Employee()\n        ' Initialize the employee details here (e.g., fetch from database)\n        ' This is just an example, replace with actual data retrieval logic\n        emp.EmployeeID = employeeID\n        emp.LastName = "SampleLastName" ' Replace with actual data retrieval\n        Return emp\n    End Function\nEnd Class