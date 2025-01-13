function ChangeDasPanel(controllerPath, postParams, callback) {\n  $.post(controllerPath, postParams, function(returnValue) {\n    $('#DasSpace').hide("slide", { direction: "right" }, 1000, function() {\n      $('#DasSpace').contents().remove();\n      $('#DasSpace').append(returnValue).css("display", "block");\n      if (typeof callback === 'function') {\n        callback();\n      }\n      $('#DasSpace').show("slide", { direction: "right" }, 1000);\n    });\n  });\n}