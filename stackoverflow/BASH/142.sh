#!/bin/sh\n#lvms command - consolidates all LVM views into a single command\npvscan 1>/dev/null 2>/dev/null\nvgscan 1>/dev/null 2>/dev/null\nlvscan 1>/dev/null 2>/dev/null\necho "Available Physical Volumes - - - - - - -"\npvs\necho\necho "Active Volume Groups - - - - - - - - - -"\nvgs\necho\necho "Active Logical Volumes - - - - - - - - -"\nlvs