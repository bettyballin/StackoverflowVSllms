// Define the Post model in app/Models/Post.php\nnamespace App\Models;\n\nuse Illuminate\Database\Eloquent\Model;\n\nclass Post extends Model {\n    // Model logic goes here\n}\n\n// Usage in a Controller\npublic function show($id) {\n    $post = Post::find($id);\n    if (!$post) {\n        abort(404);\n    }\n    return view('post.show', compact('post'));\n}