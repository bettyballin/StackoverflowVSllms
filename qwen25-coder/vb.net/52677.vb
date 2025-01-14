Protected Overrides Sub CreateChildControls()\n    FooControl = FooControlProvider.CreateFooControl(blah)\n\n    ' Set properties before adding the control to ensure ViewState and other settings work correctly.\n    Validator = New MyValidator()\n    Validator.ID = "MyValidatorID"\n    Validator.ControlToValidate = FooControl.ID\n    Validator.IsRequired = True ' Custom property\n    Validator.ErrorMessage = "Please select an answer"\n\n    Me.Controls.Add(FooControl.RetrieveControl())\n    Me.Controls.Add(Validator)\n\n    If Not DataSource Is Nothing Then\n        FooControlProvider.AssignDataSource(DataSource, FooControl)\n    End If\nEnd Sub