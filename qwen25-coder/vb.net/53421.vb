Sub PermanentlyDeleteMailItem()\n    Dim objNamespace As Outlook.NameSpace\n    Dim objInbox As MAPIFolder\n    Dim objItem As MailItem\n    Dim objDeletedItems As MAPIFolder\n    \n    ' Get the MAPI namespace and Inbox folder reference\n    Set objNamespace = Application.GetNamespace("MAPI")\n    Set objInbox = objNamespace.GetDefaultFolder(olFolderInbox)\n    \n    ' Set the Deleted Items folder\n    Set objDeletedItems = objNamespace.GetDefaultFolder(olFolderDeletedItems)\n    \n    ' Loop through each item in the Inbox\n    For i& = objInbox.Items.Count To 1 Step -1\n        ' Check if it's a MailItem\n        If TypeOf objInbox.Items(i&) Is MailItem Then\n            Set objItem = objInbox.Items(i&)\n            \n            ' Delete the item without moving to Deleted Items\n            objItem.Delete\n            \n            ' Immediately empty the Deleted Items folder to permanantly delete the item\n            objDeletedItems.EmptyFolder olDelete, False\n        End If\n    Next i&\n    \n    ' Clean up\n    Set objInbox = Nothing\n    Set objNamespace = Nothing\nEnd Sub