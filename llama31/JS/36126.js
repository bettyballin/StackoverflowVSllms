$("form").validate({\n  // ... other options ...\n  errorPlacement: function(error, element) {\n    if (element.is(":checkbox")) {\n      error.insertAfter(element.closest("div")); // or ".checkbox-group" or whatever container you use\n    } else {\n      error.insertAfter(element);\n    }\n  }\n});