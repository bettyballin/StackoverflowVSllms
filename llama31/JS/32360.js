// script.js\nvar template = Handlebars.compile($('#template').html());\nvar data = { links: [...] };\n$('body').append(template(data));