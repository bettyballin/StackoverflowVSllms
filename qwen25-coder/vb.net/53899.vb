Dim tenItem = (From t In _InvalidFeeList\n               Join i In ItemCount On t.FeeCode Equals i.FeeCode Into joinedItems\n               From subItem In joinedItems.DefaultIfEmpty()\n               Where subItem Is Nothing\n               Order By t.Description Ascending\n               Select t).Take(10)\n\nDim feeList As List(Of AccessorialFee) = tenItem.ToList()