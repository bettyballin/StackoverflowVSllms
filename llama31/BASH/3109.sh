VBoxManage createvm --name "TestVM" --register\nVBoxManage modifyvm "TestVM" --memory 2048 --vram 128\nVBoxManage storagectl "TestVM" --name "SATA Controller" --add sata\nVBoxManage storageattach "TestVM" --storagectl "SATA Controller" --port 0 --device 0 --type hdd --medium ./testvm.vdi