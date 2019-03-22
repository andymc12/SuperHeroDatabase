package io.superherosample.db;

@SuppressWarnings("serial")
public class UnknownTeamException extends Exception {

	public UnknownTeamException(String message) {
		super(message);
	}
}
