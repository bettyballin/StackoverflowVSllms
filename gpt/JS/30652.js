function sub() {\n    var checkboxes = document.getElementsByName("user");\n    var toChange = [];\n\n    // Collect checkboxes to be renamed\n    for (var i = 0; i < checkboxes.length; i++) {\n        if (checkboxes[i].checked) {\n            toChange.push(checkboxes[i]);\n        }\n    }\n\n    // Rename checkboxes outside of the collection loop\n    for (var j = 0; j < toChange.length; j++) {\n        toChange[j].name = "id";\n    }\n\n    document.checks.submit();\n}