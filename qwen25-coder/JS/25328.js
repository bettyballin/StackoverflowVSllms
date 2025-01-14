$(document).ready( function() {\n    menuMouseOver = function() {\n        for(var i=0; i<arguments.length; i++){\n            (function(parent, active, childSelect){\n                $(parent).children(childSelect)\n                    .not('.'+active).each(function(i, e) {}\n                    ).hover( \n                        function() {\n                            console.log(active); // Correctly logs the active class for each menu\n                            $(this).addClass(active);\n                        }, \n                        function() {\n                            $(this).removeClass(active);\n                        }\n                    );\n            })(arguments[i].parent, arguments[i].active, arguments[i].childSelect);\n        }\n    }\n    \n    menuMouseOver(\n        { parent: '#menu1',\n          active: 'menu1_active',\n          childSelect: ':gt(0)'\n        },\n        { parent: '#menu2',\n          active: 'menu2_active',\n          childSelect: ':gt(0)'\n        }\n    );\n});