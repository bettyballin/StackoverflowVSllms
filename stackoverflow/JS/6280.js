function please_rebind() {\n  $('.number').bind("change", function() {\n    var that = $(this);\n    $.post('/registration/sell/check_badge_number', { number: $(this).val() },\n    function(data) {\n      that.addClass('make_it_red');          \n    }, "html");\n });\n}