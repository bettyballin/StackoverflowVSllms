<?php\necho $session->flash('default', '<div class="message">\n    <span>%s</span>\n    <a href="#" class="dismiss">Dismiss</a>\n</div>',\n['escape' => false]);\n?>