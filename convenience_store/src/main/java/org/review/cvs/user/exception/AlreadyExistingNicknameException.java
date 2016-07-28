package org.review.cvs.user.exception;

public class AlreadyExistingNicknameException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AlreadyExistingNicknameException(String message) {
		super(message);
	}

}
