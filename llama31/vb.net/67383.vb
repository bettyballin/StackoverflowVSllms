Imports Skype4COMLib\n\nModule SkypeCallModule\n    Sub Main()\n        ' Create a new Skype instance\n        Dim skype As New Skype()\n\n        ' Attach to the Skype process\n        skype.Attach()\n\n        ' Make a call to a Skype user\n        skype.PlaceCall("SkypeUsername")\n\n        ' Clean up\n        skype.Detach()\n        skype = Nothing\n    End Sub\nEnd Module