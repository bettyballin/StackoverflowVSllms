var runCount = 0;    \nfunction timerMethod() {\n    runCount++;\n    if(runCount > 3) clearInterval(timerId);\n\n    //...\n}\n\nvar timerId = setInterval(timerMethod, 60000);    //60,000 milliseconds