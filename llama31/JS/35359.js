$("form").validate({\n  errorPlacement: function(error, element) {\n    error.insertAfter(element);\n  }\n});