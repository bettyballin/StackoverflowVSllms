Imports GalaSoft.MvvmLight\nImports GalaSoft.MvvmLight.Command\n\nPublic Class MainViewModel\n    Inherits ViewModelBase\n\n    Private _buttonCommand As ICommand\n    Public Property ButtonCommand() As ICommand\n        Get\n            If _buttonCommand Is Nothing Then\n                _buttonCommand = New RelayCommand(AddressOf ExecuteButtonCommand)\n            End If\n            Return _buttonCommand\n        End Get\n        Set(ByVal value As ICommand)\n            _buttonCommand = value\n        End Set\n    End Property\n\n    Private Sub ExecuteButtonCommand()\n        MessageBox.Show("Button Clicked!")\n    End Sub\nEnd Class