Dim bindingSource As New BindingSource\nbindingSource.DataSource = myObject\nbindingSource.DataMember = "BoundDate"\nmyUserControl.DataBindings.Add("BoundDate", bindingSource, "BoundDate")\n\n' ...\n\nbindingSource.ResetBindings(False)