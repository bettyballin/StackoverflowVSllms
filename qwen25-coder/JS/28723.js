$('div, a, span, p, td, img, input').filter(function() {\n    return $(this).children().length === 0;\n}).mousemove(myMouseOverHandler);