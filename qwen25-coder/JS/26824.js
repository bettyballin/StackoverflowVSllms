$(document).ready(function() {\n    var text1DatePickerOptions = {\n        showOn: 'button', \n        buttonImage: 'images/cal.gif', \n        buttonImageOnly: true,\n        dateFormat: 'dd-mm-yy',\n        numberOfMonths: 2,\n        minDate:0\n    };\n\n    var text2DatePickerOptions = {\n        showOn: 'button', \n        buttonImage: 'images/cal.gif', \n        buttonImageOnly: true,\n        dateFormat: 'dd-mm-yy',\n        numberOfMonths: 2,\n        minDate:1\n    };\n\n    function setReadOnly(obj) {\n        if (obj.value == "yes") {\n            $("#text2").datepicker("destroy").prop('disabled', false);\n            $("#text2").val('');\n            $("#text2").datepicker(text2DatePickerOptions); // Reinitialize datepicker\n\n            $('#text2').css('background-color', '#ffffff');\n        } else {\n            $("#text2").datepicker("destroy"); // Destroy the datepicker\n            $("#text2").prop('disabled', true);\n            $("#text2").val('Not applicable!');\n            $('#text2').css('background-color', '#eeeeee');\n        }\n    }\n\n    // Initial setup for text1 and text2\n    $("#text1").datepicker(text1DatePickerOptions);\n    $("#text2").datepicker(text2DatePickerOptions);\n\n    // Attach click event to radio buttons\n    $("input[name='update']").on('click', function() {\n        setReadOnly(this);\n    });\n});