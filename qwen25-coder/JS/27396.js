$('#YourModelFieldName').autocomplete({\n    source: '/yourController/yourAction',\n    minLength: 2,\n    select: function(event, ui) {\n        console.log('Selected item:', ui.item.value);\n        // Additional logic after selection\n    },\n    success: function() {\n        console.log('Request completed successfully');\n    }\n});