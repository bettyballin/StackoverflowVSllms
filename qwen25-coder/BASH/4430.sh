#!/bin/bash\n\n# This is where you process the emails, e.g., save to a file or perform actions based on content.\ncat > "/path/to/save/emails/email-$(date +%F-%H%M%S).eml"