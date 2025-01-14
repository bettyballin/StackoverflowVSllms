function updateUI () {\n   $.ajax({ \n      url: "timer.aspx",\n      contentType: "application/json; charset=utf-8",\n      dataType: "json",\n      timeout: 5000,\n      type: "POST",\n      data: "{}"\n   }).done(function(data) {\n      if (data && typeof data === 'object') {\n         $("h1").text(data.mike);\n      } else {\n         $("h1").text("Invalid response");\n      }\n      setTimeout(updateUI, 0);\n   }).fail(function(jqXHR, textStatus, errorThrown) {\n      $("h1").text(textStatus + ": " + errorThrown);\n      setTimeout(updateUI, 0);\n   });\n}