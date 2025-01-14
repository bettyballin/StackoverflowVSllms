Imports NAudio.Wave\n\nPublic Class AudioPlayer\n    Private player As WaveOutEvent\n    Private mp3Reader As Mp3FileReader\n    Private startTime As DateTime\n\n    Public Sub PlayMp3(filePath As String)\n        If player IsNot Nothing Then\n            player.Stop()\n            player.Dispose()\n        End If\n\n        mp3Reader = New Mp3FileReader(filePath)\n        player = New WaveOutEvent()\n        AddHandler player.PlaybackStopped, AddressOf OnPlaybackStopped\n\n        startTime = DateTime.Now\n        player.Init(mp3Reader)\n        player.Play()\n    End Sub\n\n    Public Function GetMillisecondsPlayed() As Double\n        Dim currentTime As TimeSpan = mp3Reader.CurrentTime\n        Return currentTime.TotalMilliseconds\n    End Function\n\n    Private Sub OnPlaybackStopped(sender As Object, e As StoppedEventArgs)\n        mp3Reader.Dispose()\n        player.Dispose()\n        mp3Reader = Nothing\n        player = Nothing\n    End Sub\nEnd Class