jQuery.noConflict();\njQuery(function($) {\n    $('#contacto').fancybox({\n        'hideOnContentClick': false,\n        'frameWidth': 600,\n        'frameHeight': 550,\n        'centerOnScroll': true\n    });\n\n    $('ul.drawers').accordion({\n        header: 'H2.drawer-handle',\n        selectedClass: 'open',\n        event: 'mouseover'\n    });\n\n    $("#about-button").css({ opacity: 0.3 });\n    $("#contact-button").css({ opacity: 0.3 });\n    $("#page-wrap div.button").click(function() {\n        var clicked = $(this);\n        console.log(clicked);\n\n        // if the button is not already "transformed" AND is not animated\n        if ((clicked.css("opacity") != "1") && (clicked.is(":not(animated)"))) {\n            clicked.animate({\n                opacity: 1,\n                borderWidth: 5\n            }, 600 );\n\n            // each button div MUST have a "xx-button" and the target div must have an id "xx" \n            var idToLoad = clicked.attr("id").split('-');\n\n            //we search through the content for the visible div and we fade it out\n            $("#menu-content").find("div:visible").fadeOut("fast", function() {\n                //once the fade-out is completed, we start to fade in the right div\n                $(this).parent().find("#" + idToLoad[0]).fadeIn();\n            });\n        }\n\n        //we reset the other buttons to default style\n        clicked.siblings(".button").animate({\n            opacity: 0.5,\n            borderWidth: 1\n        }, 600 );\n    });\n});