Public Class Animal \n    Public Sub Eat() \n        Console.WriteLine("Eating") \n    End Sub \nEnd Class \n\nPublic Interface ISpeak \n    Sub Speak() \nEnd Interface \n\nPublic Interface IWalk \n    Sub Walk() \nEnd Interface \n\nPublic Class Dog \n    Inherits Animal \n    Implements ISpeak, IWalk \n\n    Public Sub Speak() Implements ISpeak.Speak \n        Console.WriteLine("Barking") \n    End Sub \n\n    Public Sub Walk() Implements IWalk.Walk \n        Console.WriteLine("Walking") \n    End Sub \nEnd Class