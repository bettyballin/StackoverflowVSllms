$(document).on("mouseover", ".droppable", function(ev, ui) {\n        $(this).addClass('droppable-hover');\n    }).on("mouseout", ".droppable", function(ev, ui) {\n        $(this).removeClass('droppable-hover');\n    });