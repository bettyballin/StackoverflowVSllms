$(document).ready(function () {\n    $('#txtQuestions').on('input', function () {\n        var text = $(this).val();\n        $(this).val(text.replace(/^(.{250}).*$/, '$1'));\n    });\n});