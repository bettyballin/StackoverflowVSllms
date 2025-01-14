Public Function FindParentControlByType(ByRef childControl As WebControl, ByVal parentControlType As Type, Optional ByVal levelsUp As Integer = Nothing) As WebControl\n    Dim parentControl As Control = childControl.Parent\n    Dim levelCount As Integer = 1\n\n    Do While parentControl IsNot Nothing AndAlso Not parentControl.GetType.Equals(parentControlType)\n        If levelsUp IsNot Nothing AndAlso levelCount >= levelsUp Then\n            Return Nothing\n        End If\n        levelCount += 1\n        parentControl = parentControl.Parent\n    Loop\n\n    Return TryCast(parentControl, WebControl)\nEnd Functio