$(function() {\n    // Initialize the start date picker\n    $("#datepicker").datepicker({\n        changeMonth: true,\n        onSelect: function(selectedDate) { // Triggered when a date is selected\n            var option = this.id == "datepicker" ? "minDate" : "maxDate",\n                instance = $(this).data("datepicker"),\n                date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);\n            datesNotYetPicked = !$("#datepicker").val() || !$("#datepicker2").val();\n            if (datesNotYetPicked && changeMonth) {\n                date.setMonth(date.getMonth() + 1); // Move to the next month\n            }\n            $("#datepicker2").datepicker("option", option, date);\n        }\n    });\n\n    // Initialize the end date picker with a default minDate\n    $("#datepicker2").datepicker({ \n        changeMonth: true,\n        minDate: new Date()\n    });\n});