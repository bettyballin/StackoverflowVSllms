Private Sub handleRejectedDescription(ByVal sender As System.Object, ByVal e As System.EventArgs)\n    'sender is a button in this case.\n    'get the button\n    dim b as new button\n    b = ctype(sender,button)\n    'now get the button's parent form\n    dim f as new form\n    f = ctype(b.parent, form)\n    'now close the form\n    f.close()\nEnd Sub