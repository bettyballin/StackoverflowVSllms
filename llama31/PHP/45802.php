// app/Jobs/SendEmail.php\nnamespace App\Jobs;\n\nuse Illuminate\Contracts\Queue\Job;\nuse Illuminate\Support\Facades\Mail;\n\nclass SendEmail implements Job\n{\n    public function handle()\n    {\n        Mail::to('recipient@example.com')->send(new \App\Mail\HelloWorld);\n    }\n}