// Dispatch a job to the queue\nuse App\Jobs\ResizeImage;\n\nResizeImage::dispatch($imageId, ['thumb', 'medium', 'large']);