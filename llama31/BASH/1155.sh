#!/bin/bash\n\n# Linux version\ncase $1 in\n    start)\n        /usr/bin/java -jar /path/to/your/application.jar &\n        ;;\n    stop)\n        pkill -f /path/to/your/application.jar\n        ;;\nesac\n\n# OpenSolaris version (using SMF)\n#!/bin/bash\n\n. /lib/svc/share/smf_include.sh\n\ncase $1 in\n    start)\n        java -jar /path/to/your/application.jar &\n        ;;\n    stop)\n        pkill -f /path/to/your/application.jar\n        ;;\nesac