$(document).ready(function() {\n    $("#yourFormId").validate({\n        rules: {\n            yourFieldName: {\n                exactText: "yourExactString"\n            }\n        }\n    });\n});