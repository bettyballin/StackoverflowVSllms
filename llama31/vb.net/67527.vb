Public Sub EventHandler()\n    If Me.InvokeRequired Then\n        Me.Invoke(New MethodInvoker(AddressOf EventHandler))\n    Else\n        ' Do your event handling code '\n    End If\nEnd Sub