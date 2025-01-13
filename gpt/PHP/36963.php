<?php\n   require 'vendor/autoload.php';\n\n   use Pheanstalk\Pheanstalk;\n\n   $pheanstalk = Pheanstalk::create('127.0.0.1');\n\n   $data = json_encode(['image_id' => 12345]);\n   $pheanstalk->useTube('task_queue')->put($data);\n\n   echo ' [x] Sent ', $data, "\n";\n   ?>