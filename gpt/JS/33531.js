xmlRequest = $.post("/url/file/", { 'id': object.id }, successFunction, 'json')\n  .fail(function(jqXHR, textStatus, errorThrown) {\n    console.error("Request failed: " + textStatus);\n    console.error("Error thrown: " + errorThrown);\n    console.error("Response text: " + jqXHR.responseText);\n  })\n  .always(function() {\n    console.log("Request completed");\n  });