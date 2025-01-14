Class Foo\n    Public Property Children As IList(Of FooChildBase)\n\n    Public Sub New()\n        Children = New List(Of FooChildBase)()\n    End Sub\nEnd Class\n\nClass FooChildBase\n    Public Property Info As String\nEnd Class\n\nClass FooChildTwo\n    Inherits FooChildBase\n\n    Public Property ExtraInfo As String\nEnd Class\n\nClass FooSpecial\n    Inherits Foo\n\n    Public Property SpecialInfo As String\n    Public Property SpecialChildren As IList(Of FooChildSpecial)\n\n    Public Sub New()\n        MyBase.New()\n        SpecialChildren = New List(Of FooChildSpecial)()\n    End Sub\n\n    ' Method to add a child and wrap it in FooChildSpecial\n    Public Sub AddSpecialChild(child As FooChildBase, specialInfo As String)\n        Dim specialChild As New FooChildSpecial(child) With {\n            .SpecialChildInfo = specialInfo\n        }\n        SpecialChildren.Add(specialChild)\n    End Sub\nEnd Class\n\nClass FooChildSpecial\n    Inherits FooChildBase\n\n    Public Property SpecialChildInfo As String\n    ' Original child object wrapped\n    Public Property OriginalChild As FooChildBase\n\n    Public Sub New(originalChild As FooChildBase)\n        MyBase.New()\n        Me.OriginalChild = originalChild\n        ' Copy properties from original child if necessary\n        Me.Info = originalChild.Info\n    End Sub\nEnd Class