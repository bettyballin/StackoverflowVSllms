$("#draggable").draggable();\n$("#droppable").droppable({\n    drop: function(event, ui) {\n        console.log("Dropped!");\n    }\n});