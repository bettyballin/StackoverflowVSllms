// assume 'table' is the ID of your table and 'column' is the class of the column you want to extract values from\nvar values = [];\n$('#table tr').each(function() {\n    var value = $(this).find('td.column').text();\n    if (values.indexOf(value) === -1) {\n        values.push(value);\n    }\n});\n\n// now you can populate your select box with the unique values\n$.each(values, function(key, value) {\n    $('#select-box').append('<option value="' + value + '">' + value + '</option>');\n});