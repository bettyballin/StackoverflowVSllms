' Ensure AdornedElement is set correctly\nDim adornedElement As UIElement = YourItemsControl\nDim adornerLayer As AdornerLayer = AdornerLayer.GetAdornerLayer(adornedElement)\n\nIf adornerLayer IsNot Nothing Then\n    Dim insertionAdorner As New InsertionAdorner(adornedElement)\n    adornerLayer.Add(insertionAdorner)\n    \n    ' Force layout update if necessary\n    adornedElement.InvalidateArrange()\nElse\n    Debug.Assert(False, "Adorner layer not found")\nEnd If