<?php\n// Assuming $imageData contains the base64 encoded string from your db\n$imageData = "/9j/4AAQ...";\necho '<img src="data:image/jpeg;base64,' . htmlspecialchars($imageData) . '" />';\n?>