$.ajax({\n    type: "POST",\n    url: "populate_area.php",\n    data: {city_id: city_id},\n    success: function(data){\n        $("#area_dropdown").html(data);\n    }\n});