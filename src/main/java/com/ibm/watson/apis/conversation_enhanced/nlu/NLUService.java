package com.ibm.watson.apis.conversation_enhanced.nlu;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;

public class NLUService {

	public double getSentimentScore(String inputText) {
		NaturalLanguageUnderstanding nluService = new NaturalLanguageUnderstanding(
				NaturalLanguageUnderstanding.VERSION_DATE_2017_02_27, System.getenv("NLU_USERNAME"),
				System.getenv("NLU_PASSWORD"));

		SentimentOptions sentiment = new SentimentOptions.Builder().build();

		Features features = new Features.Builder().sentiment(sentiment).build();

		AnalyzeOptions parameters = new AnalyzeOptions.Builder().text(inputText).features(features)
				.language("pt").build();

		AnalysisResults results = nluService.analyze(parameters).execute();

		return results.getSentiment().getDocument().getScore();

	}
}
