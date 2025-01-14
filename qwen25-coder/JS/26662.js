// Example of using requestAnimationFrame with fallback\n   window.requestAnimFrame = (function(){\n     return  window.requestAnimationFrame ||\n             window.webkitRequestAnimationFrame ||\n             window.mozRequestAnimationFrame    || \n             function( callback ){\n               window.setTimeout(callback, 1000 / 60);\n             };\n   })();