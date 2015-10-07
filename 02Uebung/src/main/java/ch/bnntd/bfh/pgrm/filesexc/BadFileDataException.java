package ch.bnntd.bfh.pgrm.filesexc;

import java.io.IOException;

@SuppressWarnings("serial")
public class BadFileDataException extends IOException {

	public BadFileDataException(){};
	
	public BadFileDataException(String message) {
		super(message);
	}
}
