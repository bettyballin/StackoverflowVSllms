$(document).ready(function() {\n    $(document).on("click", "#Destination_Div01 a", function(){\n        $("#Destination_Div02").load("External.php"+$(this).attr('href')+" #Target_Div02");\n        return false;\n    });\n\n    $(document).on("click", "#Destination_Div02 a", function(){\n        $("#Destination_Div03").load("External.php"+$(this).attr('href')+" #Target_Div03");\n        return false;\n    });\n});