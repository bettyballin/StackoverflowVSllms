ew Ajax.Autocompleter(\n  'search_box',\n  'autocomplete_choices',\n  '/your_search_url_here', {\n    paramName: "query",\n    minChars: 1,\n    delay: 0.5,\n    afterUpdateElement: function(input, selectedLi) {\n      if (selectedLi && selectedLi.id) {\n        // Redirect or handle editing for the selected item\n        window.location.href = '/edit_item/' + selectedLi.id;\n      }\n    },\n    onComplete: function(request, response) {\n      var choicesList = $(request.transport.responseText);\n      if (choicesList.down('li') == null) {\n        // Handle no results found\n        alert("No items found. Redirecting to create new item...");\n        window.location.href = '/create_new_item';\n      }\n    }\n  }\n);