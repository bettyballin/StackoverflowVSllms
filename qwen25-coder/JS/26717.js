function please_rebind() {\n  $('.number').on("change", function() {\n    var $input = $(this); // Save the reference to the input element\n    $.post('/registration/sell/check_badge_number', { number: $input.val() },\n    function(data) {\n      $input.addClass('make_it_red'); // Use the saved reference here\n      alert(data);\n    }, "html");\n  });\n}