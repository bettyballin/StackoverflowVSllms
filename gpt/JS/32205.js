$(function () {\n    $('someElement')\n        .bind('mouseover', function (e) {\n            $(this).css({\n                // change color\n            });\n        })\n        .bind('mouseout', function (e) {\n            $(this).css({\n                // return to previous state\n            });\n        })\n        .bind('click', function (e) {\n            $(this).css({\n                // do something\n            });\n        });\n});