// Load Joomla framework\n   defined('_JEXEC') or die('Restricted access');\n\n   // Get the database object\n   $db = JFactory::getDbo();\n\n   // Query to get the article\n   $query = $db->getQuery(true)\n       ->select($db->quoteName(array('id', 'title', 'introtext')))\n       ->from($db->quoteName('#__content'))\n       ->where($db->quoteName('title') . ' = ' . $db->quote('Article 1'))\n       ->where($db->quoteName('access') . ' = 0') // Public access\n       ->setLimit(1);\n\n   // Execute the query\n   $db->setQuery($query);\n   $article = $db->loadObject();\n\n   if ($article) {\n       // Get the first 100 words of the article\n       $introText = strip_tags($article->introtext);\n       $words = explode(' ', $introText);\n       $shortText = implode(' ', array_slice($words, 0, 100));\n\n       // Create the read more link\n       $link = JRoute::_('index.php?option=com_content&view=article&id=' . $article->id);\n   ?>\n       <h2><?php echo htmlspecialchars($article->title, ENT_QUOTES, 'UTF-8'); ?></h2>\n       <p><?php echo htmlspecialchars($shortText, ENT_QUOTES, 'UTF-8'); ?>...</p>\n       <p><a href="<?php echo $link; ?>">Read More</a></p>\n   <?php\n   } else {\n       echo '<p>Article not found.</p>';\n   }