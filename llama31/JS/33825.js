$(".subMenuTD").hover(\n    function() { \n        $(this).addClass("subMenuTDActive");\n        $(this).children(".subLink").addClass("subLink-white");\n    },\n    function() { \n        $(this).removeClass("subMenuTDActive");\n        $(this).children(".subLink").removeClass("subLink-white");\n    }\n);