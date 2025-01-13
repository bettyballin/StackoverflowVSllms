$(function() {\n  $("#myTable td").draggable({\n    revert: true\n  });\n  \n  $("#myTable th").droppable({\n    accept: "td",\n    drop: function(event, ui) {\n      var droppedItem = ui.draggable.text();\n      var targetColumn = $(this).index();\n      var sourceColumn = ui.draggable.parent().index();\n      \n      // Move the item to the new column\n      ui.draggable.remove();\n      $(this).parent().find("tr").eq(ui.draggable.parent().index()).find("td").eq(targetColumn).after("<td>" + droppedItem + "</td>");\n    }\n  });\n});