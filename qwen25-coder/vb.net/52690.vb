<TestFixtue()>\nPublic Class TestClass\n    <Test()>\n    Public Sub EventTest()\n        Dim eventClass As New EventClass\n        Dim eventRaised As Boolean = False\n        AddHandler eventClass.AnEvent, Sub() (eventRaised = True)\n        eventClass.RaiseIt()\n        Assert.IsTrue(eventRaised)\n    End Sub    \nEnd Class\n\nPublic Class EventClass\n    Public Event AnEvent As EventHandler\n    Public Sub RaiseIt()\n        RaiseEvent AnEvent()\n    End Sub\nEnd Class