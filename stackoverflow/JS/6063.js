<script>\n$(document).ready(function() {\n   getState();\n});\n\nfunction getState() {\n    $('#country').change( function() {         \n        var val = $(this).val();\n        if (val == 223 || val == 224) {\n         $('#othstate').val('').hide();\n         $.ajax({\n            url: 'findState.php',\n            dataType: 'html',\n            data: { country : val },\n            success: function(data) {\n                $('#state').html(data);\n            }\n         });\n     }else {\n        $('#state').val('').hide();\n        $('#othstate').show();\n     }\n   });\n }\n</script>