window.onpopstate = function(event) {\n       if (event.state) {\n           window.location.href = '/safe-page';\n       }\n   };