Protected Overrides ReadOnly Property CreateParams() As CreateParams\n    Get\n        Dim cp As CreateParams = MyBase.CreateParams\n        cp.Style = cp.Style And Not WS_VISIBLE\n        Return cp\n    End Get\nEnd Property