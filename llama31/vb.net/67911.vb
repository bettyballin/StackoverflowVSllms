Dim rMessage as Redemption.RDOMail = _RDOSession.GetMessageFromID(EntryID, getPublicStoreID())\nDim propertyList As Redemption.PropList = rMessage.GetPropList(Nothing)\nFor i As Integer = 1 To propertyList.Count\n    Console.WriteLine(propertyList(i).ToString())\n    Console.WriteLine(rMessage.GetNamesFromIDs(rMessage, propertyList(i)))\nNext