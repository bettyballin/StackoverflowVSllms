var category = $("#business_business_category_id").val().trim();\nif (category == "") {\n    $('#categorylabel').show();\n    $("#business_business_category_id").focus();\n    return false;\n}