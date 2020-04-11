package com.developer.guys.Core.Utilities.Results;

public class SuccessResult extends Result {

	public SuccessResult(String message) {
		super(true, message);
		
	}
	
	public SuccessResult() {
		super(true);
	}

}