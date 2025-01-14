Class Foo\n    Public Children As IList(Of FooChildBase)\nEnd Class\n\nClass FooChildBase\n    Public Info As String\nEnd Class\n\nClass FooChildTwo\n    Inherits FooChildBase\n\n    Public ExtraInfo As String\nEnd Class\n\nClass FooSpecial\n    Inherits Foo\n\n    Public SpecialInfo As String\n\n    ' Use a new collection in FooSpecial to manage wrapped children\n    Private _specialChildren As IList(Of FooChildSpecial)\n\n    Public Sub New()\n        MyBase.New()\n        Me.Children = New List(Of FooChildBase)()\n        Me._specialChildren = New List(Of FooChildSpecial)()\n    End Sub\n\n    ' Method to add a child that wraps the actual child object\n    Public Sub AddSpecialChild(child As FooChildBase)\n        Dim specialChild As New FooChildSpecial With {\n            .WrappedChild = child,\n            .SpecialChildInfo = "Default Special Info" ' or some logic based on child type\n        }\n        Me._specialChildren.Add(specialChild)\n        Me.Children.Add(child)\n    End Sub\n\n    Public ReadOnly Property SpecialChildren() As IList(Of FooChildSpecial)\n        Get\n            Return _specialChildren\n        End Get\n    End Property\nEnd Class\n\n' The FooChildSpecial class now wraps a FooChildBase object\nClass FooChildSpecial\n    Inherits FooChildBase\n\n    ' A property to hold the actual child object being wrapped\n    Public Property WrappedChild As FooChildBase\n\n    ' Extra information specific to FooChildSpecial\n    Public SpecialChildInfo As String\n\n    ' Override any properties or methods as necessary, using WrappedChild values\nEnd Class