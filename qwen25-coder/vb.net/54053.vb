Public Class Foo Implements ISimpleInterface, IExtendedInterface\n\n    ' Private field to store the value of ErrorMsg\n    Private _errorMsg As String\n\n    ' Explicit implementation for the get accessor of ISimpleInterface.ErrorMsg\n    Private ReadOnly Property ISimpleInterface_ErrorMsg As String Implements ISimpleInterface.ErrorMsg\n        Get\n            Return _errorMsg\n        End Get\n    End Property\n\n    ' Explicit implementation for IExtendedInterface.ErrorMsg with both get and set accessors\n    Private Property IExtendedInterface_ErrorMsg As String Implements IExtendedInterface.ErrorMsg\n        Get\n            Return _errorMsg\n        End Get\n        Set(value As String)\n            _errorMsg = value\n        End Set\n    End Property\n\n    ' Implementation of SomeOtherProperty as defined in IExtendedInterface\n    Public Property SomeOtherProperty As String Implements IExtendedInterface.SomeOtherProperty\nEnd Class