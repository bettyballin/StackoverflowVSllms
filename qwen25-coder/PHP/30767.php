amespace Vendor\Module\Controller\Index;\n\nuse Magento\Framework\App\Action\Action;\nuse Magento\Framework\App\Action\Context;\nuse Vendor\Module\Model\ResourceModel\Custom\CollectionFactory as CustomCollectionFactory;\n\nclass Index extends Action {\n    protected $customCollectionFactory;\n\n    public function __construct(\n        Context $context,\n        CustomCollectionFactory $customCollectionFactory\n    ) {\n        parent::__construct($context);\n        $this->customCollectionFactory = $customCollectionFactory;\n    }\n\n    public function execute() {\n        $collection = $this->customCollectionFactory->create();\n        // Use $collection to interact with your data\n    }\n}