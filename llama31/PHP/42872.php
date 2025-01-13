class XmlBuilder {\n    private $xml;\n\n    public function __construct() {\n        $this->xml = new xmlElement('data');\n    }\n\n    public function build($result, $parentId = null) {\n        while ($row = pg_fetch_assoc($result)) {\n            // Assuming 'id' and 'parent_id' are columns in your table\n            if ($row['parent_id'] == $parentId) {\n                $element = $this->xml->append(new xmlElement($row['fieldname']));\n                $element->write($row['fieldvalue']);\n                // Recursively call build for children\n                $this->build($result, $row['id']);\n            }\n        }\n        return $this->xml;\n    }\n}