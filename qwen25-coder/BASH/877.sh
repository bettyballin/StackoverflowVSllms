# Example of creating a bootable Windows image using PowerShell (Windows only)\nNew-WindowsImage -ImagePath "C:\Images\MyCustomImage.wim" -CapturePath "D:\" -Name "Windows Test Image" -Description "Clean installation for software testing"