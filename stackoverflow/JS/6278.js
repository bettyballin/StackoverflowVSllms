$('img').click(function(){\n   var id = $(this ~ tr).attr("id");\n   $.ajax(type: "POST",\n          url: "some.php",\n          data: "id="+id,\n          success: function(msg){\n             $(id).remove();\n   });\n});