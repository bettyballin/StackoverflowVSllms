$form->video->receive();\n\n// Get the upload progress\n$progress = $adapter->getProgress();\n\n// Update the progress bar\n$adapter->update($progress);