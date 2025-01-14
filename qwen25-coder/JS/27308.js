function submit_form() {\n    // Collect all checked checkbox values\n    var user_ids = [];\n    $('input[name="user_ids[]"]:checked').each(function() {\n        user_ids.push($(this).val());\n    });\n\n    $.post("ajax.php", {\n        selectedcheckboxes: user_ids,\n        confirm: "true"\n    }, function(data) {\n        $("#lightbox").html(data);\n    });\n}