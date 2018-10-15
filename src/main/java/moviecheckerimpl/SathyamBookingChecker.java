package moviecheckerimpl;
import java.util.List;
import java.util.Map;

import moviechecker.MovieBookingChecker;
import moviechecker.MovieDataParser;
import utils.ParseUtil;

public class SathyamBookingChecker implements MovieBookingChecker {

	public boolean isBookingStarted(String movieName) {

		MovieDataParser movieDataParser = new SathyamMoviesDataParser();
		Map<String, String> map = ParseUtil.loadProperties();

		String url = map.get("parseUrl");

		List<String> list = movieDataParser.getParsedMovieListData(url);

		System.out.println(list);

		return list.contains(movieName);
	}
}
