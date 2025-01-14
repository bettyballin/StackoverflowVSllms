$(document).ready(function() {\n       $('#ajaxForm').on('submit', function(event) {\n           event.preventDefault();\n           var $form = $(this);\n           $.ajax({\n               type: $form.attr('method'),\n               url: $form.attr('action'),\n               data: $form.serialize(),\n               success: function(data) {\n                   // Update your DOM with the returned data\n                   $('#targetDiv').html(data);\n               }\n           });\n       });\n   });