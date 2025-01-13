$(function() {\n    $('#DoTask').click(function(event) {\n        event.preventDefault(); // Prevent default form submission\n        var timestamp = new Date().getTime(); // Generate a unique timestamp\n        $.getJSON('/TareasBackGround/DoTaskInteractivo', { "_": timestamp },\n            function(response) {\n                $('#ResultadoEjecutarTarea').html("<br />Resultado: " + response.result);\n                $('#ResultadoEjecutarTarea').css("style", "");\n            }\n        );\n    });\n});