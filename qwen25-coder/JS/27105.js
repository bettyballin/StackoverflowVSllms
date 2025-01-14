/* Work | Play | About | Contact */\n/* Shadow Opacity */\n$(document).ready(function() {\n    $('#workShadow, #playShadow, #aboutShadow, #contactShadow').fadeTo(0, 0.1);\n});\n\n/* Shadow Hover effect */\n$(document).ready(function() {\n    $('a#work').hover(function() {\n        $('#workShadow').fadeTo(250, 0.6); // Increase to 60% opacity\n    }, function() {\n        $('#workShadow').fadeTo(400, 0.1);\n    });\n    // Similarly for other links\n    $('a#play').hover(function() {\n        $('#playShadow').fadeTo(250, 0.6);\n    }, function() {\n        $('#playShadow').fadeTo(400, 0.1);\n    });\n    $('a#about').hover(function() {\n        $('#aboutShadow').fadeTo(250, 0.6);\n    }, function() {\n        $('#aboutShadow').fadeTo(400, 0.1);\n    });\n    $('a#contact').hover(function() {\n        $('#contactShadow').fadeTo(250, 0.6);\n    }, function() {\n        $('#contactShadow').fadeTo(400, 0.1);\n    });\n});\n\n/* Type movement on hovering */\n$(document).ready(function() {  \n    $('a.shift').hover(function() { //mouse in  \n        $(this).animate({ paddingTop: 85, paddingBottom: 2 }, 200);  \n    }, function() { //mouse out  \n        $(this).stop().animate({ paddingTop: 75, paddingBottom: 12 }, 400);  \n    });  \n});