$("#div").hover(\n    function(){\n        // Add class to the hovered div\n        $(this).addClass('cie_hover');\n        \n        // Slide down another element with id, e.g., #anotherDiv\n        $("#anotherDiv").slideDown();\n    },          \n    function(){\n        // Remove class from the hovered div\n        $(this).removeClass('cie_hover');\n        \n        // Optionally slide up the other element if needed\n        $("#anotherDiv").slideUp();\n    }\n);