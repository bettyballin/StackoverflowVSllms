class My_Controller_Action_Helper_FlvThumbnail extends Zend_Controller_Action_Helper_Abstract\n{\n    public function direct($flv, $thumbnail)\n    {\n        $flv = escapeshellarg($flv);\n        $thumbnail = escapeshellarg($thumbnail);\n\n        $command = "ffmpeg -v 0 -y -i $flv -vframes 1 -ss 10 -vcodec mjpeg -f rawvideo -s 210x140 -aspect 16:9 $thumbnail";\n\n        $output = array();\n        $returnValue = null;\n\n        exec($command, $output, $returnValue);\n\n        if ($returnValue !== 0) {\n            // Handle error\n            throw new Exception("Failed to generate thumbnail");\n        }\n\n        return $output;\n    }\n}