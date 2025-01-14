<?php\nif (isset($this->messages) && count($this->messages) > 0) {\n    $formattedMessages = array_map(function ($message) {\n        return ['message' => $message];\n    }, $this->messages);\n\n    echo $this->partialLoop('partials/messages.phtml', $formattedMessages);\n}\n?>