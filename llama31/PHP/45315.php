// File: app/Http/Controllers/HelloController.php\n\nnamespace App\Http\Controllers;\n\nuse Illuminate\Http\Request;\n\nclass HelloController extends Controller\n{\n    public function index()\n    {\n        return 'Hello, World!';\n    }\n}