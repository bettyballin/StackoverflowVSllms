<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>\n<script>\n$(document).ready(function() {\n    $.ajax({\n        url: '/Home/GetData',\n        type: 'GET',\n        dataType: 'json',\n        success: function(response) {\n            console.log('Name:', response.Name);\n            console.log('Age:', response.Age);\n        },\n        error: function(xhr, status, error) {\n            console.error('AJAX Error: ' + status + error);\n        }\n    });\n});\n</script>