$.ajax({\n    url: 'your-server-endpoint',\n    type: 'POST',\n    data: { key: 'value' },\n    dataType: 'json',\n    success: function(response) {\n        // Assume response is an array of records\n        response.forEach(record => {\n            const html = `<div class="record">\n                            <p>${record.field1}</p>\n                            <p>${record.field2}</p>\n                          </div>`;\n            $('#container').append(html);\n        });\n    },\n    error: function(xhr, status, error) {\n        console.error('AJAX Error:', status, error);\n    }\n});