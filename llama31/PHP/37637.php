<?php\n/*\nTemplate Name: Front Page\n*/\n\nget_header(); ?>\n\n<div id="content">\n    <?php if ( have_posts() ) : ?>\n        <?php while ( have_posts() ) : the_post(); ?>\n            <?php the_content(); ?>\n        <?php endwhile; ?>\n    <?php endif; ?>\n</div>\n\n<?php get_footer(); ?>