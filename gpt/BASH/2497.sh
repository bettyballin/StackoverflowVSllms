# Create a new virtual machine\nVBoxManage createvm --name "macOS_Safari3" --ostype "MacOS1012" --register\n\n# Set memory and other configurations\nVBoxManage modifyvm "macOS_Safari3" --memory 2048 --vram 128 --cpus 2\n\n# Create a virtual hard disk\nVBoxManage createhd --filename "~/VirtualBox VMs/macOS_Safari3/macOS_Safari3.vdi" --size 64000 --format VDI\n\n# Attach the virtual hard disk\nVBoxManage storagectl "macOS_Safari3" --name "SATA Controller" --add sata --controller IntelAHCI\nVBoxManage storageattach "macOS_Safari3" --storagectl "SATA Controller" --port 0 --device 0 --type hdd --medium "~/VirtualBox VMs/macOS_Safari3/macOS_Safari3.vdi"\n\n# Attach the macOS installer ISO\nVBoxManage storageattach "macOS_Safari3" --storagectl "SATA Controller" --port 1 --device 0 --type dvddrive --medium "/path/to/macos_installer.iso"\n\n# Start the virtual machine\nVBoxManage startvm "macOS_Safari3"