$("#category").on('change', function () {\n  var selectedOption = $(this).find('option:selected');\n  var catId = selectedOption.val();\n  var secondValue = selectedOption.data('second-value');\n\n  console.log("Category ID: " + catId);\n  console.log("Second Value: " + secondValue);\n});