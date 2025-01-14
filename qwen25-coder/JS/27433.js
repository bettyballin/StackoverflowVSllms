function validateEmail(input) {\n    var re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;\n    return re.test(String(input).toLowerCase());\n}\n\n$('#your_form_id').on('submit', function(event){\n    var email = $('#email_field_id').val();\n    if (!validateEmail(email)) {\n        alert("Invalid Email Address");\n        event.preventDefault(); // prevent form submission\n    }\n});