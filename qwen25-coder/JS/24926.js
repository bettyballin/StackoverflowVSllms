$(".varSel").on("change", function() {\n    // Navigate up to the nearest form and find the .pid input\n    var vid = $(this).closest('form').find('.pid').val();\n    var formdata = $(this).closest('form').serialize();\n    $.ajax({\n        type: "POST",\n        url: "library/varPrice.php",\n        data: formdata,\n        success: function(html) {\n            $('.price', $(this).closest('form')).html(html);\n        }.bind(this) // Use .bind to maintain the context of 'this'\n    });\n});