$(document).ready(function() {\n    $("#sortlist1").treeview();\n    $("#sortlist2").treeview();\n    $("#sortlist3").treeview();\n\n    // Make the lists droppable\n    $(".drop-container").droppable({\n        accept: ".item",\n        drop: function(ev, ui) {\n            $(this).append($(ui.draggable));\n        }\n    });\n\n    // Initialize sortable for each list\n    $('.sortlist').sortable({\n        handle: '.icono',\n        connectWith: ".sortlist", // This allows items to be dragged between connected lists.\n        update: function(event, ui) {\n            if (this === ui.item.parent()[0]) { // Check if the item is dropped within the same list\n                // Update the serialization for the specific list if needed\n                var serialized = $(this).sortable('serialize');\n                console.log(serialized); // You can handle it as per your requirement.\n            }\n        }\n    });\n\n    $(".item").draggable({\n        connectToSortable: ".sortlist",\n        helper: "clone"\n    });\n});