Imports System.Media\n\nWhile blnAlert = True\n    Using player As New SoundPlayer("C:\cat_1.wav")\n        AddHandler player.LoadCompleted, Sub(sender, args) \n                                            If blnAlert Then player.PlaySync()\n                                        End Sub\n        player.LoadAsync()\n    End Using\n    ' Optionally add a small delay to prevent it from overwhelming the system\n    System.Threading.Thread.Sleep(50)\nEnd While