// Select the iframe element\nvar iframe = document.getElementById('yourIframeId'); // Replace 'yourIframeId' with the actual ID of your iframe\n\n// Ensure the iframe has loaded its content before attempting to manipulate it\niframe.onload = function() {\n    // Access the iframe's document\n    var iframeDoc = iframe.contentDocument || iframe.contentWindow.document;\n\n    // Set value in the input field inside the iframe\n    var searchTermInput = iframeDoc.querySelector('input[name="searchTerm"]');\n    searchTermInput.value = "YourSearchValue"; // Replace 'YourSearchValue' with the value you want to set\n\n    // Submit the form\n    var searchForm = iframeDoc.getElementById('searchForm');\n    searchForm.submit();\n};