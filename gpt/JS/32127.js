$(document).ready(function() {\n  $("#table-2").tableDnD({\n    onDrop: function(table, row) {\n      var rows = table.tBodies[0].rows;\n      for (var i = 0; i < rows.length; i++) {\n        $(rows[i]).find("input[type='textbox']").val(i + 1);\n      }\n    }\n  });\n});