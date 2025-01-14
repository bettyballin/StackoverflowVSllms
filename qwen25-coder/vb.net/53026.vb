Imports System.Reflection\n\nPublic Class SoundPlayerForm\n    Private Sub Timer_Tick(sender As Object, e As EventArgs) Handles Timer1.Tick\n        Dim resourceNames = GetResourceNames()\n        If resourceNames.Length > 0 Then\n            Dim randomNumber As Random = New Random()\n            Dim randomIndex As Integer = randomNumber.Next(0, resourceNames.Length)\n            PlayEmbeddedSound(resourceNames(randomIndex))\n        End If\n    End Sub\n\n    Private Function GetResourceNames() As String()\n        Dim assembly As Assembly = Assembly.GetExecutingAssembly()\n        Return assembly.GetManifestResourceNames()\n    End Function\n\n    Private Sub PlayEmbeddedSound(resourceName As String)\n        Dim assembly As Assembly = Assembly.GetExecutingAssembly()\n        Using stream As Stream = assembly.GetManifestResourceStream(resourceName)\n            If stream IsNot Nothing Then\n                ' Assuming you're playing WAV files or another supported audio format by SoundPlayer\n                Dim player As New System.Media.SoundPlayer(stream)\n                player.PlaySync() ' Play the sound synchronously\n            End If\n        End Using\n    End Sub\nEnd Class