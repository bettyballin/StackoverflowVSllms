# Example: Create a VirtualBox VM with an old Ubuntu version\nVBoxManage createvm --name old-hardware --register\nVBoxManage modifyvm old-hardware --memory 128 --vram 16\nVBoxManage storageattach old-hardware --storagectl IDE --port 0 --device 0 --type hdd --medium old-hardware.vdi