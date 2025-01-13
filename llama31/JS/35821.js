// Client-side JavaScript\n$(document).ready(function() {\n  $('#tag-input').autocomplete({\n    source: function(request, response) {\n      $.ajax({\n        url: '/tags/autocomplete',\n        data: { q: request.term },\n        dataType: 'json',\n        success: function(data) {\n          response(data);\n        }\n      });\n    },\n    minLength: 2\n  });\n});