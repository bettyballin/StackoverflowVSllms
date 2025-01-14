Public Shared Sub CreateCustomer(cust As Customer)\n       Try\n           Validation.Customer.ValidateForCreate(cust) ' scoped as Friend\n           Dal.Customer.Create(cust) ' scoped as Friend\n       Catch ex As CustomValidationException\n           MessageBox.Show(ex.Message, "Validation Error", MessageBoxButtons.OK, MessageBoxIcon.Error)\n       End Try\n   End Sub