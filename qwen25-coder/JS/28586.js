$(document).ready(function(){       \n    $("#show_morecats").click(function(){\n        $("#morecats").slideToggle("slow");\n        $(this).toggleClass("active");\n    });\n});