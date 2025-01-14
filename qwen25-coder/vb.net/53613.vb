Private Sub ActionList_AfterLabelEdit(ByVal sender As Object, ByVal e As NodeLabelEditEventArgs) Handles ActionList.AfterLabelEdit\n       If e.Label IsNot Nothing Then\n           e.Node.EndEdit(False)\n           CType(e.Node.Tag, ImportActionCategory).DisplayName = e.Label\n           \n           ' Use a timer to defer tree rebuild\n           Dim rebuildTimer As New System.Timers.Timer(50) ' Delay of 50ms\n           AddHandler rebuildTimer.Elapsed, AddressOf RebuildTreeAfterEditing\n           rebuildTimer.AutoReset = False\n           rebuildTimer.Enabled = True\n       Else\n           e.Node.EndEdit(True)\n       End If\n       \n       ActionList.LabelEdit = False\n   End Sub\n\n   Private Sub RebuildTreeAfterEditing(ByVal source As Object, ByVal e As ElapsedEventArgs)\n       ' Perform the tree rebuilding logic here\n   End Sub