package com.epam.jwd.task2.parser.sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


public class TourErrorHandler implements ErrorHandler {

    private static final Logger LOGGER = LogManager.getLogger(TourErrorHandler.class);

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        LOGGER.warn(getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        LOGGER.error(getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        LOGGER.fatal(getLineColumnNumber(exception) + "-" + exception.getMessage());
    }

    private String getLineColumnNumber(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}