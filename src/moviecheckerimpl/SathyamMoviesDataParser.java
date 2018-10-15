package moviecheckerimpl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import moviechecker.MovieDataParser;

public class SathyamMoviesDataParser implements MovieDataParser {

	public List<String> getParsedMovieListData(String parseUrl) {
		List<String> list = new ArrayList<String>();

		try {
			Document doc = Jsoup.connect(parseUrl).get();

			Elements ele = doc.getElementsByClass("movie__name");

			for (Element e : ele) {
				list.add(e.child(0).html());
			}

		} catch (Exception exp) {
			// System.out.println(exp.getCause());
		}
		return list;
	}

}
