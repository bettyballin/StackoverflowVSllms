function DoAction( id, name )\n{\n    $.ajax({\n         type: "POST",\n         url: "someurl.php",\n         data: "id=" + id + "&name=" + name,\n         success: function(msg){\n                     alert( "Data Saved: " + msg );\n                  }\n    });\n}