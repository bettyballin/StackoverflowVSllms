$(".subMenuTD").hover(\n    function() { \n        $(this).addClass("subMenuTDActive");\n        $(this).find(".subLink").addClass("subLink-white");\n    },\n    function() { \n        $(this).removeClass("subMenuTDActive");\n        $(this).find(".subLink").removeClass("subLink-white");\n    }\n);