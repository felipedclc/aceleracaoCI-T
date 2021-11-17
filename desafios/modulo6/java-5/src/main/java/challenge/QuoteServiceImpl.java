package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		List<Quote> quotes = repository.findAll();
		return getRandomQuote(quotes);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quotes = repository.findByActorEquals(actor);
		if (quotes.size() == 1) return quotes.get(0);
		else return getRandomQuote(quotes);
	}

	private Quote getRandomQuote(List<Quote> list) {
		Random index = new Random();
		int randIndex = index.nextInt(list.toArray().length);
		return list.get(randIndex);
	}
}
