class ContentChunkerComponent extends Component {\n    public $chunks = [];\n    \n    public function chunkContent($content, $chunkSize) {\n        // Simplified logic; you might want to adjust this based on visual considerations\n        $nodes = preg_split('/(<img[^>]+>)/i', $content, -1, PREG_SPLIT_NO_EMPTY | PREG_SPLIT_DELIM_CAPTURE);\n        $currentChunk = '';\n        \n        foreach ($nodes as $node) {\n            if (strlen($currentChunk . $node) > $chunkSize || stripos($node, '<img') === 0) {\n                $this->chunks[] = $currentChunk;\n                $currentChunk = $node;\n            } else {\n                $currentChunk .= $node;\n            }\n        }\n\n        if (!empty($currentChunk)) {\n            $this->chunks[] = $currentChunk;\n        }\n    }\n    \n    public function getChunks() {\n        return $this->chunks;\n    }\n}