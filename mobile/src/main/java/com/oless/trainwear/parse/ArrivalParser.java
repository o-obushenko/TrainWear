package com.oless.trainwear.parse;

import com.oless.trainwear.model.Arrival;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by oless on 10/18/15.
 */
public class ArrivalParser {

    String mArrivalXmlString;

    public ArrivalParser(String arrivalXmlString) {
        mArrivalXmlString = arrivalXmlString;
    }

    public ArrayList<Arrival> parse() throws XmlPullParserException, IOException {
        XmlPullParser parser = Xml.newPullParser();
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        parser.setInput(new StringReader(mArrivalXmlString));
        parser.nextTag();
        return readFeed(parser);
    }


    private ArrayList<Arrival> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<Arrival> arrivals = new ArrayList();

        parser.require(XmlPullParser.START_TAG, null, "ctatt");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("eta")) {
                arrivals.add(readArrival(parser));
            } else if (name.equals("errCd")) {
                if (!readErrorCode(parser)) {
                    //Give back empty list in case of reported error!
                    return new ArrayList();
                }
            } else {
                skip(parser);
            }
        }
        return arrivals;
    }

    private Arrival readArrival(XmlPullParser parser) throws XmlPullParserException, IOException {

        parser.require(XmlPullParser.START_TAG, null, "eta");

        int run = 0;
        String color = "";
        int trainDirection = 0;
        boolean isApproaching = false;
        boolean isScheduled = false;
        boolean isFault = false;
        boolean isDelayed = false;
        String arrivalTime = "";
        String predictionTime = "";
        String destStationName = "";

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            switch(name) {
                case "rn":
                    run = Integer.parseInt(readSpecificTagText(parser, "rn"));
                    break;
                case "rt":
                    color = readSpecificTagText(parser, "rt");
                    break;
                case "trDr":
                    trainDirection = Integer.parseInt(readSpecificTagText(parser, "trDr"));
                    break;
                case "isApp":
                    isApproaching = Boolean.parseBoolean(readSpecificTagText(parser, "isApp"));
                    break;
                case "isSch":
                    isScheduled = Boolean.parseBoolean(readSpecificTagText(parser, "isSch"));
                    break;
                case "isDly":
                    isDelayed = Boolean.parseBoolean(readSpecificTagText(parser, "isDly"));
                    break;
                case "isFlt":
                    isFault = Boolean.parseBoolean(readSpecificTagText(parser, "isFlt"));
                    break;
                case "prdt":
                    predictionTime = readSpecificTagText(parser, "prdt");
                    break;
                case "arrT":
                    arrivalTime = readSpecificTagText(parser, "arrT");
                    break;
                case "destNm":
                    destStationName = readSpecificTagText(parser, "destNm");
                    break;
                default:
                    skip(parser);
                    break;
            }
        }
        return new Arrival(run, color, trainDirection, isApproaching, isScheduled, isFault, isDelayed, arrivalTime, predictionTime, destStationName);
    }

    private String readSpecificTagText(XmlPullParser parser, String tag) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, tag);
        String tagContent = readText(parser);
        parser.require(XmlPullParser.END_TAG, null, tag);
        return tagContent;
    }

    // For the tags title and summary, extracts their text values.
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private boolean readErrorCode(XmlPullParser parser) throws IOException, XmlPullParserException {
        int error = Integer.parseInt(readText(parser));
        if (error == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }


}
