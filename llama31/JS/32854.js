document.addEventListener('click', function(event) {\n  var target = event.target;\n  // your code here\n  event.stopPropagation();\n  event.preventDefault();\n}, true);