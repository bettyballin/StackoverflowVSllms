use Illuminate\Database\Eloquent\Model;\n\nclass User extends Model {\n    // Define table name if it's not users (plural of class name)\n    protected $table = 'users';\n\n    // Specify columns that can be mass assigned\n    protected $fillable = ['name', 'email'];\n}