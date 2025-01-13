var observer = new MutationObserver(function(mutations) {\n  mutations.forEach(function(mutation) {\n    if (mutation.attributeName === 'class') {\n      var input = mutation.target;\n      // Re-initialize the jQuery Form Validator plugin or apply validation logic here\n    }\n  });\n});\n\n// Observe the input elements\nvar inputs = document.querySelectorAll('input');\ninputs.forEach(function(input) {\n  observer.observe(input, {\n    attributes: true,\n    attributeFilter: ['class']\n  });\n});