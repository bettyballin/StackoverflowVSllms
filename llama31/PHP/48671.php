define('DEFAULT_ENCRYPTION_KEY', 'asdHRMfjkahguglw84tlrogl9y8kamaFDaufasds');\n\nclass Encryption\n{\n    private $mode   = 'cbc';\n    private $algo   = 'rijndael-128';\n    private $td     = null;\n    private $iv     = null;\n\n    function __construct($key = DEFAULT_ENCRYPTION_KEY)\n    {\n        $this->td = mcrypt_module_open($this->algo, '', $this->mode, '');\n        $this->iv = mcrypt_create_iv(mcrypt_enc_get_iv_size($this->td), MCRYPT_DEV_URANDOM);\n        $key = substr($key, 0, mcrypt_enc_get_key_size($this->td));\n        mcrypt_generic_init($this->td, $key, $this->iv);\n    }\n\n    public function encrypt($data)\n    {\n        $encrypted_data = mcrypt_generic($this->td, $data);\n        return $this->iv . $encrypted_data;\n    }\n\n    public function decrypt($data)\n    {\n        $iv = substr($data, 0, mcrypt_enc_get_iv_size($this->td));\n        $data = substr($data, mcrypt_enc_get_iv_size($this->td));\n        mcrypt_generic_init($this->td, DEFAULT_ENCRYPTION_KEY, $iv);\n        $decrypted_data = mdecrypt_generic($this->td, $data);\n        $decrypted_data = rtrim($decrypted_data, "\0");\n        return $decrypted_data;\n    }\n\n    function __destruct()\n    {\n        mcrypt_generic_deinit($this->td);\n        mcrypt_module_close($this->td);\n    }\n}\n\n$crypt1 = new Encryption();\n$enc = $crypt1->encrypt('hello world');\n\n$crypt2 = new Encryption();\n$dec = $crypt2->decrypt($enc);\n\necho $dec;