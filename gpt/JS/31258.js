$.ajax({\n    url: 'your-server-endpoint',\n    type: 'POST',\n    data: { key: 'value' },\n    dataType: 'html',\n    success: function(response) {\n        $('#container').html(response);\n    },\n    error: function(xhr, status, error) {\n        console.error('AJAX Error:', status, error);\n    }\n});