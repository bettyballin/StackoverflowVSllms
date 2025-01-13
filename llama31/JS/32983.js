$.ajax({\n  type: 'POST',\n  url: '/register',\n  data: $('#register-form').serialize(),\n  success: function(data) {\n    // Registration successful...\n  },\n  error: function(xhr, status, error) {\n    const errors = xhr.responseJSON.errors;\n    const errorList = $('#error-list');\n    errorList.empty();\n    errors.forEach((error) => {\n      errorList.append(`<li>${error.msg}</li>`);\n    });\n  },\n});