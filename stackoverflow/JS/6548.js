$("li").each(function()\n{ \n    if($(this).is("[id^='start']")) alert("START");\n    else if($(this).is("[id^='sub']")) alert("SUB");\n});