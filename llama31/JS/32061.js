$(document).ready(function() {\n  $("#SuperTextbox1_Results").children('li').each(function() {\n    var liText = $(this).text();\n    var checkbox = $('<input type="checkbox" name="checkbox_' + liText + '" value="' + liText + '">');\n    $(this).prepend(checkbox);\n    \n    // Handle checkbox change event\n    checkbox.change(function() {\n      if ($(this).is(':checked')) {\n        console.log('Checked:', $(this).attr('name'), $(this).val());\n      } else {\n        console.log('Unchecked:', $(this).attr('name'), $(this).val());\n      }\n    });\n  });\n});