using Microsoft.SharePoint;\n\npublic bool IsCalendarList(SPWeb web, string listName)\n{\n    SPList list = web.Lists.TryGetList(listName);\n    return list != null && list.BaseType == SPBaseType.Events;\n}