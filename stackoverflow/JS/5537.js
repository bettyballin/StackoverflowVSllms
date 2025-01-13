$(function(){ \n   $('#tog_table0').click( toggle_table )\n});\n\nfunction toggle_table() {\n   //this refers to the element clicked\n   var $el = $(this);\n   // get the table - assuming the element is inside the table\n   var $table = $el.closest('table');\n   // Toggle the table\n   $table.slideToggle("slow", function () {\n       $el.is(":hidden") ? $el.text("show") : $el.text("hide");\n   }\n}