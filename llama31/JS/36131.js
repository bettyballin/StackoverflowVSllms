function validatePage(group) {\n    var validators = Page_Validators;\n    for (var i = 0; i < validators.length; i++) {\n        if (validators[i].validationGroup == group) {\n            ValidatorValidate(validators[i]);\n            if (!validators[i].isvalid) {\n                return false;\n            }\n        }\n    }\n    return true;\n}