For Each CurrentTask As Task In _MasterTaskList\n    ' Assume you have a condition to determine if Optional should be displayed\n    Dim displayOptional As Boolean = DetermineDisplayOptional(CurrentTask)\n    clstTasks.Items.Add(New TaskDisplayWrapper(CurrentTask, displayOptional), True)\nNext