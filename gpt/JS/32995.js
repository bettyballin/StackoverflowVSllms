document.addEventListener('DOMContentLoaded', function() {\n  var selects = document.querySelectorAll('select');\n  selects.forEach(function(select) {\n    select.style.height = '30px'; // Desired height\n  });\n});