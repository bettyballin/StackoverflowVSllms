Partial Public Class Customers\n    Implements ICustomersData\n\n    Private Function GetCustomerObject() As CustomerObject Implements ICustomersData.GetCustomerObject\n        ' Implementation here\n    End Function\n\n    Private Function GetCustomerFieldx() As String Implements ICustomersData.GetCustomerFieldx\n        ' Implementation here\n    End Function\nEnd Class