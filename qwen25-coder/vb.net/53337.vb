Public Class Singleton\n    ' Static variable that holds the single instance.\n    Private Shared _instance As Singleton\n\n    ' Object used for locking to handle thread-safe operations.\n    Private Shared ReadOnly _lock As New Object()\n\n    ' Private constructor. This prevents an external instantiation of this class.\n    Private Sub New()\n        ' Initialization code here\n    End Sub\n\n    ' Public method that provides access to the single instance of Singleton.\n    Public Shared Function GetInstance() As Singleton\n        If _instance Is Nothing Then\n            SyncLock _lock\n                If _instance Is Nothing Then\n                    _instance = New Singleton()\n                End If\n            End SyncLock\n        End If\n        Return _instance\n    End Function\n\n    ' Other methods and properties of the singleton class go here.\nEnd Class