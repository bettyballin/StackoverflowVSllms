$("form").validate({\n  ignore: ":contains('enter text here...')",\n  rules: {\n    yourInputField: {\n      required: true\n    }\n  }\n});