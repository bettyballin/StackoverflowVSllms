use ORM\Framework\Model;\n\nclass User extends Model\n{\n    protected $attributes = [\n        'email_address',\n        'name',\n        'address', // less frequently accessed\n    ];\n\n    public function __construct($id = 0)\n    {\n        if ($id) {\n            // Eager load the most commonly used attributes\n            $this->loadAttributes(['email_address', 'name'], $id);\n        }\n    }\n\n    public function getAddress()\n    {\n        // Lazy load the less frequently accessed attribute\n        if (!$this->address) {\n            $this->loadAttribute('address');\n        }\n        return $this->address;\n    }\n}