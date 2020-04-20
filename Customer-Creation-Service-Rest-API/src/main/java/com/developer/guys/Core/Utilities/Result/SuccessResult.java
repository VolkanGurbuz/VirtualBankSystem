package com.developer.guys.Core.Utilities.Result;

public class SuccessResult extends Result {

	public SuccessResult(String message) {
		super(true, message);
		
	}
	
	public SuccessResult() {
		super(true);
	}

}