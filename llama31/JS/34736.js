document.addEventListener('DOMContentLoaded', function() {\n  var inputs = document.querySelectorAll('input, select, textarea');\n  if (inputs.length > 0) {\n    inputs[0].focus();\n  }\n});