$('.toggle').on('click', function(event) {\n  event.preventDefault();\n  $(this).next('ul').toggle();\n});