import subprocess\n\n# Get the current revision number from Subversion\nrevision = subprocess.check_output(['svn', 'info', '--show-item', 'revision']).strip()\n\n# Generate a header file with the revision number\nwith open('revision.h', 'w') as f:\n    f.write('#ifndef REVISION_H\n')\n    f.write('#define REVISION_H\n')\n    f.write('#define REVISION ' + revision + '\n')\n    f.write('#endif\n')