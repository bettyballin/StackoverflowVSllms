<?php\necho "We'll email you as soon as this is done.";\nfastcgi_finish_request();\n\n// do some stuff that will take a while\nmail('dude@thatplace.com', "okay I'm done", 'Yup, all done.');\n?>