Private Function LoadSaved() \n    Dim ZomgSavedClips As New StringCollection()\n    If Not IsDBNull(My.Settings.SavedClips) Then \n        ZomgSavedClips = My.Settings.SavedClips\n        ' ... rest of your code ...\n    End If\nEnd Functio