package com.amdocs.petStore.model;

public class Pet {

	int petID;
	String petCategory;
	String petType;
	String petColour;
	int petAge;
	double petPrice;
	boolean isVaccinated;
	String petFoodHabits;
	
	public Pet(int petID, String petCategory, String petType, String petColour, int petAge, double petPrice,
			boolean isVaccinated, String petFoodHabits) {
		this.petID = petID;
		this.petCategory = petCategory;
		this.petType = petType;
		this.petColour = petColour;
		this.petAge = petAge;
		this.petPrice = petPrice;
		this.isVaccinated = isVaccinated;
		this.petFoodHabits = petFoodHabits;
	}
	
	public int getPetID() {
		return petID;
	}
	public void setPetID(int petID) {
		this.petID = petID;
	}
	
	public String getPetCategory() {
		return petCategory;
	}
	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	}
	
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	
	public String getPetColour() {
		return petColour;
	}
	public void setPetColour(String petColour) {
		this.petColour = petColour;
	}
	
	public int getPetAge() {
		return petAge;
	}
	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	
	public double getPetPrice() {
		return petPrice;
	}
	public void setPetPrice(double petPrice) {
		this.petPrice = petPrice;
	}
	
	public boolean isVaccinated() {
		return isVaccinated;
	}
	public void setVaccinated(boolean isVaccinated) {
		this.isVaccinated = isVaccinated;
	}
	
	public String getPetFoodHabits() {
		return petFoodHabits;
	}
	public void setPetFoodHabits(String petFoodHabits) {
		this.petFoodHabits = petFoodHabits;
	}

	@Override
	public String toString() {
		return "\n-----------------\n petID=" + petID + "\n petCategory=" + petCategory + "\n petType=" + petType + "\n petColour="
				+ petColour + "\n petAge=" + petAge + "\n petPrice=" + petPrice + "\n isVaccinated=" + isVaccinated
				+ "\n petFoodHabits=" + petFoodHabits + "\n-----------------\n";
	}
	

}
