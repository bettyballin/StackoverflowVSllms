$(function() {\n  var dateToday = new Date();\n  var monthPrior = new Date();\n  monthPrior.setMonth(dateToday.getMonth() - 1);\n\n  $("#datepicker").datepicker({\n    minDate: monthPrior,\n    maxDate: dateToday\n  });\n});