$(".row .more").click(function() {\n  var row = $(this).closest(".row");\n  row.find(".hidden").slideToggle("slow");\n  return false;\n});