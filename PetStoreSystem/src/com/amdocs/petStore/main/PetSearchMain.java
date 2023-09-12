package com.amdocs.petStore.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.amdocs.petStore.dao.*;
import com.amdocs.petStore.model.*;
import com.amdocs.petStore.petException.*;

public class PetSearchMain {

	public static void main(String[] args) throws PetInputException {
		
		System.out.println("Welcome to pet store");
		int choice=0;
		Scanner sc = new Scanner(System.in);
		PetDAO pdao = new PetDAO();
		do {
			System.out.println("\n--------------------------------\nMenu\nChoose from the following options");
			System.out.println("1.Add New Pet Details"
					+ "\n2.Update Pet Price and Vaccination Status"
					+ "\n3.Delete Pet Details"
					+ "\n4.View all Pets"
					+ "\n5.Count Pets by Category"
					+ "\n6.Find by Price"
					+ "\n7.Find by Vaccination Status for Pet Type"
					+ "\n0.Exit");
			choice = sc.nextInt();
			if(choice==1) {
				int ID=1;
				String category = "Dog";
				String type = "Pug";
				String colour = "Black";
				int age = 4;
				double price = 10000;
				boolean isVac = true;
				String foodHabits = "Veg";
				int dowhile=-1;
				do {
					try {
						System.out.println("Enter the Category of the Pet:");
						category = sc.next();
						System.out.println("Enter the type of Pet:");
						type = sc.next();
						System.out.println("Enter the colour of the Pet:");
						colour = sc.next();
						System.out.println("Enter the age of the Pet:");
						age = sc.nextInt();
						System.out.println("Enter the price of the Pet:");
						price = sc.nextDouble();
						System.out.println("Is your pet Vaccinated (true/false)?");
						isVac = sc.nextBoolean();
						System.out.println("What are your pet's food habits?");
						foodHabits = sc.next();
						dowhile=0;
					}
					catch(Exception e){
						dowhile=1;
						try {
							sc.next();
							throw new PetInputException();
						}
						catch(PetInputException e1) {}
					}
				}while(dowhile>0);
				Pet p = new Pet(ID, category, type, colour, age, price, isVac, foodHabits);
				pdao.addPetDetails(p);
				
			}
			else if (choice==2) {
				int forid=2;
				double newPrice=10000;
				boolean newvac=true;
				int dowhile = -1;
				do {
					try {
						System.out.println("Enter the Pet ID for the pet whose details have to be updated:");
						forid = sc.nextInt();
						System.out.println("Enter the new Price for this Pet:");
						newPrice = sc.nextDouble();
						System.out.println("Enter the vaccination status of this pet (true/false):");
						newvac = sc.nextBoolean();
						dowhile=0;
					} catch(Exception e){
						dowhile=1;
						try {
							sc.next();
							throw new PetInputException();
						}
						catch(PetInputException e1) {}
					}
				}while(dowhile>0);
				pdao.updatePetPriceAndVaccinationStatus(forid, newPrice, newvac);

			}
			else if (choice==3) {
				int forid=2;
				int dowhile=-1;
				do {
					try {
						System.out.println("Enter the pet ID of the pet to be deleted:");
						forid = sc.nextInt();
						dowhile=0;
					} catch (Exception e) {
						dowhile=1;
						try {
							sc.next();
							throw new PetInputException();
						}
						catch(PetInputException e1) {}
					}
				}while(dowhile>0);
				pdao.deletePetDetails(forid);
			}
			else if (choice==4) {
				List<Pet> Pets = new ArrayList<Pet>();
				Pets = pdao.showAllPets();
				System.out.println(Pets);
			}
			else if (choice==5) {
				String forcate;
				System.out.println("Enter the category for which you want the count:");
				forcate = sc.next();
				int count = pdao.countPetsByCategory(forcate);
				if(count==0) {
					System.out.println("There are no pets in this category!");
				} else {
					System.out.println("The number of pets in the category are : " + count);
				}
			}
			else if (choice==6) {
				List<Pet> Pets = new ArrayList<Pet>();
				double min=0, max=1;
				int dowhile=0;
				do {
					try {
						System.out.println("Enter the maximum value for Price:");
						max = sc.nextDouble();
						System.out.println("Enter the minimum value for Price:");
						min = sc.nextDouble();
						dowhile=0;
					} catch (Exception e) {
						dowhile=1;
						try {
							sc.next();
							throw new PetInputException();
						}
						catch(PetInputException e1) {}
					}
					if(max<min) {
						System.out.println("Maximum value cannot be less than minimum value.\nPlease enter the values again");
						dowhile=1;
					}
				}while(dowhile>0);
				Pets = pdao.searchByPrice(min, max);
				System.out.println(Pets);
			}
			else if (choice==7) {
				int count=0;
				String type = " ";
				boolean b = true;
				int dowhile=-1;
				do {
					try {
						System.out.println("Enter the type of pet");
						type = sc.next();
						System.out.println("Enter the vaccination status(true/false)");
						b = sc.nextBoolean();
						dowhile=0;
					}catch(Exception e) {
						dowhile=1;
						try {
							sc.next();
							throw new PetInputException();
						}
						catch(PetInputException e1) {}
					}
				}while(dowhile>0);
				count = pdao.countByVaccinationStatusForPetType(type, b);
				System.out.println("The number of pets with that vaccination status are: " + count);
			}
			else if (choice==0) {
				break;
			}
			else {
				System.out.println("Given number does not correspond to a feature! Please choose another number.");
			}
		}while(choice!=0);

	}

}
