$condition = true; // replace with your condition\n\n$loginForm = '\n<div id="login">\n  <h2>Login</h2>\n  <div class="box">\n    <form method="POST" action="index.php/login">\n      Username/Email:<br />\n      <input type="text" name="username" value="' . set_value("username") . '" size="50" class="form" />\n      ' . form_error("username") . '\n      Password:<br />\n      <input type="password" name="password" value="' . set_value("password") . '" size="50" class="form" />\n      ' . form_error("password") . '\n      <input type="submit" value="Login" name="login" />\n    </form>\n  </div>\n</div>\n';\n\n$alternativeContent = 'Alternative content here'; // replace with your alternative content\n\necho $condition ? $loginForm : $alternativeContent;