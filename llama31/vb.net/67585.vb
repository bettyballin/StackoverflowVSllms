Dim tenItem = From t As AccessorialFee In _InvalidFeeList _\n               From i In ItemCount _\n               Where t.FeeCode <> i.FeeCode _\n               Order By t.Description _\n               Ascending Take (10)\n\nDim feeList As List(Of AccessorialFee) = tenItem.ToList()