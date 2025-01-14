$batchSize = 50;\n$subscriberChunks = array_chunk($subscribers, $batchSize);\n\nforeach ($subscriberChunks as $chunk) {\n    foreach ($chunk as $subscriber) {\n        $message = new Zend_Mail('utf-8');\n        $message->setFrom('my@mailinglist.com', 'Mailing List')\n                ->addTo($subscriber->email)\n                ->setSubject($subject)\n                ->setBodyText($body);\n\n        $attachment = $message->createAttachment($attachmentContent);\n        $attachment->type = $attachmentType;\n        $attachment->filename = $attachmentFilename;\n\n        $message->send($smtpConnection);\n    }\n    // Optional: add a delay between batches to avoid overwhelming the mail server\n    sleep(1);\n}