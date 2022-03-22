package com.epam.jwd.task2.exception;

public class CustomParseXMLException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public CustomParseXMLException() {
        super();
    }

    public CustomParseXMLException(String message) {
        super(message);
    }

    public CustomParseXMLException(Exception exception) {
        super(exception);
    }
    
    public CustomParseXMLException(String message, Exception exception) {
        super(message, exception);
    }
}