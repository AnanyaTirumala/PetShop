package com.amdocs.petStore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.amdocs.petStore.model.*;
import com.amdocs.petStore.dao.*;

/**
 * 
 */
public class PetDAO {
	
	public int addPetDetails (Pet p) {

		int count=0;
		try {
			 PreparedStatement pst=PetConnection.getConnection().prepareStatement("insert into pettable values(MySeq_Seq.NEXTVAL,?,?,?,?,?,?,?)");
			 //pst.setInt(1, p.getPetID());
			 pst.setString(1, p.getPetCategory());
			 pst.setString(2, p.getPetType());
			 pst.setString(3, p.getPetColour());
			 pst.setInt(4, p.getPetAge());
			 pst.setDouble(5, p.getPetPrice());
			 char isvac='o';
			 if(p.isVaccinated()==true) {
				 isvac='Y';
			 } else {
				 isvac = 'N';
			 }
			 pst.setString(6, String.valueOf(isvac));
			 pst.setString(7, p.getPetFoodHabits());
			 count= pst.executeUpdate();
			
		 }catch(Exception e) {
			 System.out.println("error" + e.getMessage());
		 }
		
		return count;
	}
	
	public int deletePetDetails (int delPetID) {
		int count=0;
		try {
			PreparedStatement pst=PetConnection.getConnection().prepareStatement("delete from pettable where petid=?");
			pst.setInt(1, delPetID);
			count = pst.executeUpdate();
			System.out.println("Deleted!");
		} catch (Exception e) {
			System.out.println("error3"+e.getMessage());
		}
		return count;
	}
	
	public boolean updatePetPriceAndVaccinationStatus(int pid, double pPrice, boolean pStatus){
		int count=0;
		try {
			PreparedStatement pst=PetConnection.getConnection().prepareStatement("update pettable set pprice=?, pisvaccinated=? where petid=?");
			pst.setDouble(1, pPrice);
			char isvac='o';
			if(pStatus==true) {
				isvac='Y';
			}else {
				isvac='N';
			}
			pst.setString(2, String.valueOf(isvac));
			pst.setInt(3,pid);
			count= pst.executeUpdate();
			System.out.println("Updated!");
		}
		catch (Exception e){
			System.out.println("error2"+e.getMessage());
		}
		return true;
	}
	
	public List<Pet> showAllPets(){
		List<Pet> Pets = new ArrayList<Pet>();
		try {
			PreparedStatement pst=PetConnection.getConnection().prepareStatement("select * from pettable");
			ResultSet count = pst.executeQuery();
			while(count.next()) {
				int ID=count.getInt(1);
				String category = count.getString(2);
				String type = count.getString(3);
				String colour = count.getString(4);
				int age = count.getInt(5);
				double price = count.getDouble(6);
				char vcc = count.getString(7).charAt(0);
				boolean isVac;
				if(vcc=='Y') {
					isVac = true;
				} else {
					isVac = false;
				}	
				
				String foodHabits = count.getString(8);
				Pet p = new Pet(ID, category, type, colour, age, price, isVac, foodHabits);
				Pets.add(p);
			}
		} catch (Exception e) {
			System.out.println("error4"+e.getMessage());

		}

		return Pets;
	}
	
	public int countPetsByCategory(String cate) {
		int count=0;
		try {
			PreparedStatement pst=PetConnection.getConnection().prepareStatement("select count(petid) from pettable where pcategory=?");
			pst.setString(1, cate);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				count =res.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("error5" + e.getMessage());
		}
		return count;
	}
	
	public List<Pet> searchByPrice(double min, double max){
		List<Pet> Pets = new ArrayList<Pet>();
		try {
			PreparedStatement pst=PetConnection.getConnection().prepareStatement("select * from pettable where pprice between ? and ?");
			pst.setDouble(1, min);
			pst.setDouble(2, max);
			ResultSet count = pst.executeQuery();
			while(count.next()) {
				int ID=count.getInt(1);
				String category = count.getString(2);
				String type = count.getString(3);
				String colour = count.getString(4);
				int age = count.getInt(5);
				double price = count.getDouble(6);
				char vcc = count.getString(7).charAt(0);
				boolean isVac;
				if(vcc=='Y') {
					isVac = true;
				} else {
					isVac = false;
				}	
				
				String foodHabits = count.getString(8);
				Pet p = new Pet(ID, category, type, colour, age, price, isVac, foodHabits);
				Pets.add(p);
			}
		} catch (Exception e) {
			System.out.println("error6"+e.getMessage());

		}
		return Pets;
	}

	public int countByVaccinationStatusForPetType(String pettype, boolean status) {
		int count=0;
		try {
			PreparedStatement pst=PetConnection.getConnection().prepareStatement("select count(petid) from pettable where ptype=? and pisvaccinated=?");
			pst.setString(1, pettype);
			char vacc;
			if(status==true) {
				vacc='Y';
			}else {
				vacc='N';
			}
			pst.setString(2, String.valueOf(vacc));
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				count =res.getInt(1);
			}

		} catch (Exception e) {
			System.out.println("error5" + e.getMessage());
		}
		return count;
	}


	

}
