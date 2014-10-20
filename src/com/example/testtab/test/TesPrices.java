package com.example.testtab.test;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.example.testtab.MainActivity;
import com.example.testtab.R;

import android.content.res.XmlResourceParser;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

public class TesPrices extends ActivityInstrumentationTestCase2<MainActivity> {

	public TesPrices() {
		super(MainActivity.class);
	}

	public void testSteakPrice() {
		assertEquals(true, true);

		XmlPullParser xmlPrices = getActivity().getResources().getXml(
				R.xml.list_a);
		assertNotNull("xmlPrices is null", xmlPrices);

		int eventType = -1;
		while (eventType != XmlResourceParser.END_DOCUMENT) {
			if (eventType == XmlResourceParser.START_TAG) {
				String strNode = xmlPrices.getName();
				if (strNode.equals("item")) {
					String title = xmlPrices.getAttributeValue(null, "title");
					String price = xmlPrices.getAttributeValue(null, "price");
					Log.d("MENU test", title + " is " + price);
					if ("Steak Sirloin".equals(title)) {
						assertEquals("34", price);
					}
				}

			}
			try {
				eventType = xmlPrices.next();
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
