using Microsoft.MediaCenter;\n\n// Get the MediaExperience instance\nMediaExperience me = new MediaExperience();\n\n// Get the current playback queue\nIPlaybackQueue queue = me.PlaybackQueue;\n\n// Add a new media item to the queue\nMediaItem item = new MediaItem("path/to/your/media/file");\nqueue.Add(item);\n\n// Remove the first item from the queue\nqueue.RemoveAt(0);\n\n// Start playing the queue\nme.Play();