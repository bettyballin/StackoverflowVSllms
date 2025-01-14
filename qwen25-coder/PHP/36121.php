require_once '/path/to/vendor/autoload.php';\n\n   use Propel\Runtime\Propel;\n\n   $config = ['database' => [\n       'connections' => [\n           'default' => [\n               'adapter' => 'mysql',\n               'dsn' => 'mysql:host=127.0.0.1;dbname=testdb',\n               'user' => 'your_username',\n               'password' => 'your_password',\n               'settings' => ['charset' => ['value' => 'utf8mb4']]\n           ]\n       ]\n   ]];\n\n   Propel::init($config);