jQuery('.class0 input')\n    .focus(function() {\n        jQuery(this).parents('.class1').addClass("special_class");\n        // Corrected: Use ".closest" to find the closest ancestor with class "class2"\n        jQuery(this).closest('.class2').find('.class3').addClass("special_class_1");\n        // Corrected: Directly select based on class since it's a direct parent of input\n        jQuery(this).parent().addClass("special_class_2");\n    });