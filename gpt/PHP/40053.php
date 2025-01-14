class Serializer {\n    private $serializedObjects = [];\n\n    public function serialize($object) {\n        return $this->serializeObject($object);\n    }\n\n    private function serializeObject($object) {\n        if (is_object($object)) {\n            $objectHash = spl_object_hash($object);\n\n            if (isset($this->serializedObjects[$objectHash])) {\n                return '<recursion/>';\n            }\n\n            $this->serializedObjects[$objectHash] = true;\n\n            $xml = '<object class="' . get_class($object) . '">';\n            foreach (get_object_vars($object) as $property => $value) {\n                $xml .= '<property name="' . $property . '">';\n                if (is_object($value)) {\n                    $xml .= $this->serializeObject($value);\n                } else {\n                    $xml .= htmlspecialchars($value, ENT_QUOTES, 'UTF-8');\n                }\n                $xml .= '</property>';\n            }\n            $xml .= '</object>';\n\n            return $xml;\n        } else {\n            return htmlspecialchars($object, ENT_QUOTES, 'UTF-8');\n        }\n    }\n}\n\n// Example usage:\nclass ParentClass {\n    public $children = [];\n}\n\nclass ChildClass {\n    public $parent;\n}\n\n$parent = new ParentClass();\n$child = new ChildClass();\n$child->parent = $parent;\n$parent->children[] = $child;\n\n$serializer = new Serializer();\n$xml = $serializer->serialize($parent);\n\necho $xml;