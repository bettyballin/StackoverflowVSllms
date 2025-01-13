Private _MyEvent As EventHandler\n\nPublic Custom Event MyEvent As EventHandler\n    AddHandler(value As EventHandler)\n        _MyEvent = [Delegate].Combine(_MyEvent, value)\n    End AddHandler\n\n    RemoveHandler(value As EventHandler)\n        _MyEvent = [Delegate].Remove(_MyEvent, value)\n    End RemoveHandler\n\n    RaiseEvent(sender As Object, e As EventArgs)\n        If _MyEvent IsNot Nothing Then\n            _MyEvent.Invoke(sender, e)\n        End If\n    End RaiseEvent\nEnd Event