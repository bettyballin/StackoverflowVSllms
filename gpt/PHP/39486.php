<?php if (isset($error)): ?>\n    <p><?php echo $error; ?></p>\n<?php endif; ?>\n<form action="" method="post">\n    <label>Username:</label><input type="text" name="username" /><br />\n    <label>Password:</label><input type="password" name="password" /><br />\n    <input type="submit" value="Login" />\n</form>