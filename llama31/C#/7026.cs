using System.Web.Mvc;\n\npublic string GetCheckboxHtml()\n{\n    var checkbox = new TagBuilder("input");\n    checkbox.MergeAttribute("type", "checkbox");\n    checkbox.MergeAttribute("name", "somename");\n    return checkbox.ToString();\n}