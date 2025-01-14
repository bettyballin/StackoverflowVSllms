class CollectionsController extends AppController {\n\n    public $paginate = [\n        'Entity' => [\n            'fields' => ['Entity.id', 'Entity.name'], // Specify fields you need\n            'limit' => 20, // Number of entities per page\n            'order' => [\n                'Entity.name' => 'ASC'\n            ]\n        ]\n    ];\n\n    public function view($collectionId) {\n        // Paginate entities for a specific collection\n        $this->paginate['Entity']['conditions'] = ['Collection.id' => $collectionId];\n        $entities = $this->paginate('Entity');\n\n        // Pass the data to your view\n        $this->set(compact('entities'));\n    }\n}