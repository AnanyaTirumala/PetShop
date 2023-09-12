package com.amdocs.petStore.petException;

public class PetInputException extends Exception {
	
	public PetInputException(){
		System.out.println("The input entered does not match the expected type.\nPlease try again!!!");
	}

}
