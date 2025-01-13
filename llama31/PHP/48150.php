class DES {\n    private $key;\n\n    public function __construct($key) {\n        $this->key = $key;\n    }\n\n    public function encrypt($data) {\n        $encrypted = openssl_encrypt($data, 'des-ecb', $this->key, OPENSSL_RAW_DATA);\n        return bin2hex($encrypted);\n    }\n\n    public function decrypt($encrypted) {\n        $encrypted = hex2bin($encrypted);\n        $decrypted = openssl_decrypt($encrypted, 'des-ecb', $this->key, OPENSSL_RAW_DATA);\n        return trim($decrypted);\n    }\n}