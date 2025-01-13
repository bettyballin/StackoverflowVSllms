' In the designer, you can bind the Checked property like this:\n' Select the RadioButton -> Properties -> (ApplicationSettings) -> PropertyBinding -> Checked\n\n' Or you can do it programmatically:\nRadioButton1.DataBindings.Add(New Binding("Checked", My.Settings, "RadioButton1Checked", True, DataSourceUpdateMode.OnPropertyChanged))\nRadioButton2.DataBindings.Add(New Binding("Checked", My.Settings, "RadioButton2Checked", True, DataSourceUpdateMode.OnPropertyChanged))\nRadioButton3.DataBindings.Add(New Binding("Checked", My.Settings, "RadioButton3Checked", True, DataSourceUpdateMode.OnPropertyChanged))