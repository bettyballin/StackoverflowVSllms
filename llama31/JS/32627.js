var originalOnChange = document.getElementById("selectbox1").onchange;\n\nif (other conditions) {\n  document.getElementById("selectbox1").onchange = function() {\n    originalOnChange(); // call the original function\n    // set global variable to false\n  };\n}