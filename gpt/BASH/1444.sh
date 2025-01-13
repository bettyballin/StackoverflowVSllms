$sourcePath = "C:\Path\To\Build\Output"\n$zipPath = "C:\Path\To\Build\Output.zip"\n$destinationPath = "\\YourServer\Deployment\Path"\n\n# Zip the output\nCompress-Archive -Path $sourcePath -DestinationPath $zipPath\n\n# Copy the zip to the destination\nCopy-Item -Path $zipPath -Destination $destinationPath\n\n# Optionally, unzip at the destination\nInvoke-Command -ComputerName "YourServer" -ScriptBlock {\n    param ($zipPath, $destinationPath)\n    Expand-Archive -Path $zipPath -DestinationPath $destinationPath\n} -ArgumentList $zipPath, $destinationPath