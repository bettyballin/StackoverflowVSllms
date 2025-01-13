class TagService\n{\n    protected $tagModel;\n    protected $tagObjectModel;\n\n    public function __construct()\n    {\n        $this->tagModel = new Application_Model_Tag();\n        $this->tagObjectModel = new Application_Model_TagObject();\n    }\n\n    public function getTagCloud()\n    {\n        $tagTable = $this->tagModel->getTable();\n        $tagObjectTable = $this->tagObjectModel->getTable();\n        \n        $select = $tagTable->select()\n            ->setIntegrityCheck(false)\n            ->from(array('t' => 'tags'), array('tag_name', 'count' => 'COUNT(to.object_id)'))\n            ->join(array('to' => 'tag_objects'), 't.tag_id = to.tag_id', array())\n            ->group('t.tag_name')\n            ->order('count DESC');\n        \n        return $tagTable->fetchAll($select);\n    }\n}