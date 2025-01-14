function startCountdown(duration, display) {\n    var timer = duration, minutes, seconds;\n    var interval = setInterval(function () {\n        minutes = parseInt(timer / 60, 10);\n        seconds = parseInt(timer % 60, 10);\n\n        minutes = minutes < 10 ? "0" + minutes : minutes;\n        seconds = seconds < 10 ? "0" + seconds : seconds;\n\n        display.textContent = minutes + ":" + seconds;\n\n        if (--timer < 0) {\n            clearInterval(interval);\n            display.textContent = "Time's up!";\n        }\n    }, 1000);\n}\n\nwindow.onload = function () {\n    var countdownDisplay = document.querySelector('#countdown');\n    startCountdown(30, countdownDisplay); // 30 seconds countdown\n};