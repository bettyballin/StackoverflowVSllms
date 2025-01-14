const gulp = require('gulp');\nconst concat = require('gulp-concat');\nconst cleanCSS = require('gulp-clean-css');\nconst uglify = require('gulp-uglify');\n\ngulp.task('styles', function() {\n  return gulp.src('src/css/*.css')\n    .pipe(concat('all.css'))\n    .pipe(cleanCSS())\n    .pipe(gulp.dest('dist/css'));\n});\n\ngulp.task('scripts', function() {\n  return gulp.src('src/js/*.js')\n    .pipe(concat('all.js'))\n    .pipe(uglify())\n    .pipe(gulp.dest('dist/js'));\n});\n\ngulp.task('default', gulp.parallel('styles', 'scripts'));