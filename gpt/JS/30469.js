$(document).ready(function() {\n    var screenWidth = window.screen.width;\n    var screenHeight = window.screen.height;\n\n    var thickboxWidth = screenWidth * 0.75;\n    var thickboxHeight = screenHeight * 0.75;\n\n    $("#thickbox").css({\n        'width': thickboxWidth + 'px',\n        'height': thickboxHeight + 'px'\n    });\n});