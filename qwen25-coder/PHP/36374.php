<?php /* Template Name: Simple Page Template */ ?>\n<?php get_header(); ?>\n\n<div id="primary" class="content-area">\n    <main id="main" class="site-main" role="main">\n        <?php while (have_posts()) : the_post();?>\n            <article id="post-<?php the_ID(); ?>" <?php post_class(); ?>>\n                <header class="entry-header">\n                    <?php the_title('<h1 class="entry-title">', '</h1>'); ?>\n                </header><!-- .entry-header -->\n                <div class="entry-content">\n                    <?php the_content();?>\n                </div><!-- .entry-content -->\n            </article><!-- #post-## -->\n        <?php endwhile; // End of the loop. ?>\n    </main><!-- #main -->\n</div><!-- #primary -->\n\n<?php get_sidebar(); ?>\n<?php get_footer(); ?>