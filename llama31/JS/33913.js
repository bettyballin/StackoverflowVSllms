// Store form data in localStorage when form is submitted\ndocument.getElementById('myForm').addEventListener('submit', function() {\n  var formData = new FormData(this);\n  localStorage.setItem('formData', JSON.stringify(formData));\n});\n\n// Retrieve stored form data when user navigates back\nwindow.addEventListener('pageshow', function(event) {\n  if (event.persisted) {\n    var storedFormData = localStorage.getItem('formData');\n    if (storedFormData) {\n      var formData = JSON.parse(storedFormData);\n      // Populate form fields with stored data\n      for (var key in formData) {\n        document.getElementById(key).value = formData[key];\n      }\n    }\n  }\n});