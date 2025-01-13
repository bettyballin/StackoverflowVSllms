$(function () {\n    $('#prevYear').click(function () {\n        var year = parseInt($('#year').text()) - 1;\n        var month = $('#monthName').text();\n        $.get('@Url.Action("Calendar", new { year = year, month = month })', function (data) {\n            $('#calendar').html(data);\n        });\n    });\n\n    $('#nextYear').click(function () {\n        var year = parseInt($('#year').text()) + 1;\n        var month = $('#monthName').text();\n        $.get('@Url.Action("Calendar", new { year = year, month = month })', function (data) {\n            $('#calendar').html(data);\n        });\n    });\n});