// Example using Gulp\n   const gulp = require('gulp');\n   const concat = require('gulp-concat');\n   const uglify = require('gulp-uglify');\n   const rename = require('gulp-rename');\n\n   gulp.task('scripts', function() {\n       return gulp.src(['path/to/jquery.js', 'path/to/plugin1.js', 'path/to/plugin2.js', 'path/to/plugin3.js'])\n           .pipe(concat('all.js'))\n           .pipe(gulp.dest('dist'))\n           .pipe(rename('all.min.js'))\n           .pipe(uglify())\n           .pipe(gulp.dest('dist'));\n   });