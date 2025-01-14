use Illuminate\Database\Eloquent\Model;\n\nclass User extends Model\n{\n    // By default, Eloquent uses the pluralized version of the class name as the table name.\n    // So `User` will use `users` table unless specified.\n\n    protected $fillable = ['name', 'email'];  // These are mass-assignable fields\n\n    // For overriding getters or setters:\n    public function getEmailAttribute($value)\n    {\n        return strtolower($value);\n    }\n}