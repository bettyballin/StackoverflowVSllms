bool hasPermission = SPUtility.DoesUserHavePermissions(SPContext.Current.Web, \n    "/path/to/your/document.docx", SPBasePermissions.ViewListItems);\n\nif (hasPermission)\n{\n    <a href="/path/to/your/document.docx">Your Document Link</a>\n}