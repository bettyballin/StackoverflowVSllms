amespace Vendor\Module\Model\ResourceModel;\n\nuse Magento\Framework\Model\ResourceModel\Db\AbstractDb;\n\nclass Custom extends AbstractDb {\n    protected function _construct() {\n        $this->_init('custom_table', 'entity_id');\n    }\n}