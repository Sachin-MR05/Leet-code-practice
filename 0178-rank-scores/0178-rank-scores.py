import pandas as pd

def order_scores(scores: pd.DataFrame) -> pd.DataFrame:
    scores['rank'] = scores['score'].rank(ascending = False, method = 'dense')
    return scores[['score','rank']].sort_values(by ="rank")
    