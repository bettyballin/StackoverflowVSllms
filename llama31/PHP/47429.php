// Shared DTO class, used by both app server and web server\nclass OrderDTO {\n    private $id;\n    private $customerName;\n    private $orderDate;\n\n    public function __construct($id, $customerName, $orderDate) {\n        $this->id = $id;\n        $this->customerName = $customerName;\n        $this->orderDate = $orderDate;\n    }\n\n    public function getId() {\n        return $this->id;\n    }\n\n    public function getCustomerName() {\n        return $this->customerName;\n    }\n\n    public function getOrderDate() {\n        return $this->orderDate;\n    }\n}\n\n// App server side, Order class with business logic\nclass Order {\n    private $id;\n    private $customerName;\n    private $orderDate;\n\n    public function __construct($id, $customerName, $orderDate) {\n        $this->id = $id;\n        $this->customerName = $customerName;\n        $this->orderDate = $orderDate;\n    }\n\n    public function cancel() {\n        // business logic to cancel the order\n    }\n\n    public function toDTO() {\n        return new OrderDTO($this->id, $this->customerName, $this->orderDate);\n    }\n}\n\n// Web server side, receives the OrderDTO object\n$orderDTO = unserialize($_POST['order']);\n\n// Use the OrderDTO object to display data\necho $orderDTO->getCustomerName();