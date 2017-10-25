package com.kobio.dao;

import java.util.List;

import com.kobio.model.Equipment;

public interface EquipDao {

	 public void indexEquipment() throws Exception;
	 public void updateEquip(Equipment e);
	 public List<Equipment> listEquip() ;
	 public List<Equipment>getEquipmentsbyUserid(int userid);
	 public Equipment getEquipmentById(int id);
	 public List<Equipment> searchForEquipment(String searchText) throws Exception;
}
