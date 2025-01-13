Dim olApp As New Outlook.Application\nDim olNamespace As Outlook.Namespace\nDim olMAPIFolder As Outlook.MAPIFolder\nDim olAddressLists As Outlook.AddressLists\nDim olAddressList As Outlook.AddressList\n\nSet olNamespace = olApp.GetNamespace("MAPI")\nSet olMAPIFolder = olNamespace.GetDefaultFolder(olFolderContacts)\nSet olAddressLists = olMAPIFolder.AddressLists\n\n' Get the "X" address list\nSet olAddressList = olAddressLists.Item("X")\n\n' Get the GAL address list\nSet olGAL = olAddressLists.Item("Global Address List")\n\n' Get the Contacts address list\nSet olContacts = olAddressLists.Item("Contacts")\n\n' Reorder the address lists\nolAddressLists.Remove olContacts\nolAddressLists.Add olAddressList, 1\nolAddressLists.Add olContacts, 2\nolAddressLists.Add olGAL, 3\n\n' Save the changes\nolMAPIFolder.Save