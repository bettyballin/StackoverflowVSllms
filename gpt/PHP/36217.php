// app/models/User.php\nclass User extends Model {\n    public function create($data) {\n        $this->query("INSERT INTO users (name, email) VALUES (:name, :email)", $data);\n    }\n}