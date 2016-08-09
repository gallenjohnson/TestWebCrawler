import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by allen.johnson on 8/7/2016.
 */


public class Main {

	public static void main(String[] args) {

		Document doc;
		try {

			// need http protocol
			doc = Jsoup.connect("https://www.saic.com/services-solutions/logistics-supply-chain/")
//			doc = Jsoup.connect("http://www.saic.com/")
					.userAgent("Mozilla")
					.timeout(10 * 1000)     // Tries for 10 seconds. Needed this to account for slow page load
					.get();

			// get page title
			String title = doc.title();
			System.out.println("title : " + title);

			// get all text fields
			Elements links = doc.select("input[name]");
			if (!links.isEmpty()) {
				System.out.println("Input fields detected!");
			}

			// get all links
//			Elements links = doc.select("a[href]");
			for (Element link : links) {
				if (!link.attr("placeholder").isEmpty()) {
					System.out.println("placeholder: " + link.attr("placeholder"));
				} else {
					System.out.println("Not a textfield");
				}

				// get the value from href attribute
//				System.out.println("\nlink : " + link.absUrl("href"));
//				System.out.println("text : " + link.text());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

