$('a.something').live("click",function() {\n    alert('this will still work after a.something has been replaced via ajax');\n});