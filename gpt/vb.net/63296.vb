Public Interface IWizardControl\n    Property AllowNavigateNext As Boolean\n    Property AllowNavigatePrevious As Boolean\n    ' Add other properties and methods as needed\nEnd Interface\n\nPublic Class UserControlWizardBase\n    Inherits UserControl\n    Implements IWizardControl\n\n    Public Property AllowNavigateNext As Boolean Implements IWizardControl.AllowNavigateNext\n    Public Property AllowNavigatePrevious As Boolean Implements IWizardControl.AllowNavigatePrevious\n\n    ' Constructor\n    Public Sub New(ByVal showNavigateCancel As Boolean, ByVal showNavigateFinish As Boolean, ByVal showNavigateNext As Boolean, ByVal showNavigatePrevious As Boolean)\n        ' Initialize your properties here\n        Me.AllowNavigateNext = showNavigateNext\n        Me.AllowNavigatePrevious = showNavigatePrevious\n        ' Other initialization code\n    End Sub\nEnd Class