$(document).ready(function() {\n  $("#myForm").validate({\n    rules: {\n      phone: {\n        required: true,\n        phoneUS: true\n      },\n      zip: {\n        required: true,\n        zipUS: true\n      },\n      email: {\n        required: true,\n        email: true,\n        equalTo: "#emailConfirm"\n      },\n      password: {\n        required: true,\n        minlength: 6,\n        equalTo: "#passwordConfirm"\n      }\n    }\n  });\n\n  $("#myForm").ajaxForm({\n    beforeSubmit: function(formData, jqForm, options) {\n      if (!$("#myForm").valid()) {\n        return false;\n      }\n      // Add masking and forcing letters and numbers only options\n      // ...\n    },\n    success: function(returndata) {\n      // Go to step 2\n      // ...\n    }\n  });\n});