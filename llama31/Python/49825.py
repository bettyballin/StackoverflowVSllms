def hybrid_ranking(upvotes, downvotes, created_at, novelty_weight=0.5):\n    score = wilson_score_interval(upvotes, downvotes)\n    novelty = 1 / (1 + (datetime.now() - created_at).total_seconds() / (60 * 60 * 24))  # 1 day half-life\n    return score + novelty_weight * novelty