function reloadCaptcha() {\n    var img = document.getElementById('imgCaptcha');\n    img.src = 'captcha.php?' + new Date().getTime();\n}