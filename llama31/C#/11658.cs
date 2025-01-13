using Microsoft.SharePoint;\n\n// Get the list and the field\nSPList list = web.Lists["Your List Name"];\nSPField field = list.Fields["Authors"];\n\n// Set the display format of the field to a custom format\nfield.DisplayFormat = "{0:LastName, {1:LastName}, ...}";\n\n// Save the changes\nfield.Update();