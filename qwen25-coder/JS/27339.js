<script type="text/javascript">\n$(document).ready(function() {\n    var dataString = { 'key': 'value' }; // Define your data string here\n\n    $.ajax({\n        type: "POST",\n        url: "process.php",\n        data: dataString,\n        dataType: "json",\n        success: function (data) {\n            if (data.response == 'captcha') {\n                alert('captcha');\n            } else if (data.response == 'error') {\n                alert('sorry there was an error');\n            } else if (data.response == 'success') {\n                alert('success'); // Corrected spelling of 'sucess'\n            }\n        },\n        error: function(xhr, status, error) {\n            console.error("AJAX Error: " + status + error);\n        }\n    });\n});\n</script>