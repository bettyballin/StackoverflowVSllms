Dim rMessage As Redemption.RDOMail = _RDOSession.GetMessageFromID(EntryID, getPublicStoreID())\nDim propertyList As Redemption.PropList = rMessage.GetPropList(Nothing) ' Use rMessage here\n\nFor i As Integer = 1 To propertyList.Count\n    Dim namedProperty As Redemption.NamedProperty = rMessage.GetNamesFromIDs(rMessage.MAPIOBJECT, propertyList(i))\n    Console.WriteLine(propertyList(i).ToString())\n    Console.WriteLine(namedProperty.Name.ToString()) ' This will give you the name of the property\nNext