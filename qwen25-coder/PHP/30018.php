// application/models/Cart_model.php\n\n   class Cart_model extends CI_Model {\n       public function __construct() {\n           parent::__construct();\n       }\n\n       // Add or update cart items in the database\n       public function add_or_update_cart_item($user_id, $product_id, $quantity) {\n           $data = array(\n               'product_id' => $product_id,\n               'quantity' => $quantity\n           );\n\n           $this->db->where('user_id', $user_id);\n           $this->db->where('product_id', $product_id);\n           if ($this->db->get('shopping_cart')->num_rows() > 0) {\n               // Update the quantity\n               $this->db->update('shopping_cart', array('quantity' => 'quantity + ' . (int)$quantity), array('user_id' => $user_id, 'product_id' => $product_id));\n           } else {\n               // Insert new item\n               $data['user_id'] = $user_id;\n               $this->db->insert('shopping_cart', $data);\n           }\n       }\n\n       // Retrieve cart data for a user from the database\n       public function get_cart_by_user($user_id) {\n           return $this->db->get_where('shopping_cart', array('user_id' => $user_id))->result_array();\n       }\n   }