$('#search-input').on('input', function() {\n       const query = $(this).val();\n       $.ajax({\n           url: '/search',\n           method: 'GET',\n           data: { q: query },\n           success: function(data) {\n               // Display the results\n               $('#results').empty();\n               data.forEach(result => {\n                   $('#results').append(`<div>${result.name}</div>`);\n               });\n           }\n       });\n   });