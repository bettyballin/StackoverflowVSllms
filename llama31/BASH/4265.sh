# Create a snapshot\nvmware-server -s "VM Name" snapshot create\n\n# Backup snapshot files\nrobocopy /source /destination\n\n# Remove snapshot\nvmware-server -s "VM Name" snapshot remove