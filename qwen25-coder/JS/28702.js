$(".more").click(function(e) {\n    e.preventDefault(); // Prevents the default action of the link\n    $(this).closest('.row').find('.hidden').slideToggle("slow");\n});