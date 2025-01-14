$(document).on('paste', function(e) {\n    var pastedData = e.originalEvent.clipboardData.getData('text');\n    var sanitizedData = DOMPurify.sanitize(pastedData);\n\n    // Do something with the sanitized data, for example:\n    console.log(sanitizedData);\n    \n    // Optionally, you can insert the sanitized data into the intended element\n    // $(this).val(sanitizedData); or any other desired action\n\n    // Prevent the default paste action\n    e.preventDefault();\n});