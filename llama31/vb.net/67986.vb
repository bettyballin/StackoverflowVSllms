' Function to convert CheckBox value to Boolean\nFunction CheckBoxToBoolean(chk As CheckBox) As Boolean\n    CheckBoxToBoolean = (chk.Value = vbChecked)\nEnd Function\n\n' Function to convert Boolean to CheckBox value\nSub BooleanToCheckBox(bValue As Boolean, chk As CheckBox)\n    If bValue Then\n        chk.Value = vbChecked\n    Else\n        chk.Value = vbUnchecked\n    End If\nEnd Sub