Using db As New YourDataContext()\n    Dim newTags = {"tag1", "tag2", "tag3"} 'your new tags to insert\n    \n    Dim existingTags = db.Tags.Select(Function(t) t.Tag)\n    \n    Dim tagsToInsert = newTags.Except(existingTags)\n    \n    Dim insertedTags = tagsToInsert.Select(Function(t) New Tag With {.Tag = t})\n    \n    db.Tags.InsertAllOnSubmit(insertedTags)\n    db.SubmitChanges()\n    \n    Dim allTags = db.Tags.Select(Function(t) New With {.TagID = t.TagID, .Tag = t.Tag})\n    \n    ' you can now use allTags to get the TagID for each tag\nEnd Using