$(document).ready(function() {\n    $('textarea').on('paste', function(e) {\n        e.preventDefault();\n        let text = (e.originalEvent || e).clipboardData.getData('text/plain');\n        text = cleanWordHTML(text);\n        $(this).val(text);\n    });\n\n    function cleanWordHTML(input) {\n        // Remove hidden HTML\n        let output = input.replace(/<\/?[^>]+(>|$)/g, "");\n        // Remove quotation marks\n        output = output.replace(/["']/g, "");\n        return output;\n    }\n});