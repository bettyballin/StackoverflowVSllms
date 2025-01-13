document.getElementById('myForm').addEventListener('submit', function(event) {\n  event.preventDefault();\n  // Get the submit button that triggered the submission\n  var submitButton = event.submitter;\n  // Get the form action from the submit button\n  var formAction = submitButton.getAttribute('formaction');\n  // Handle the form submission based on the form action\n  if (formAction === '/submit-form-1') {\n    console.log('Form 1 submitted');\n  } else if (formAction === '/submit-form-2') {\n    console.log('Form 2 submitted');\n  }\n});