package ro.utcn.sd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.utcn.sd.dto.MenuDTO;
import ro.utcn.sd.entities.MenuItem;
import ro.utcn.sd.repositories.MenuItemRepository;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;
	
	public List<MenuDTO> findAllByType(String type) {
		
		List<MenuItem> menuItems = menuItemRepository.findAllByType(type);
		List<MenuDTO> dto = new ArrayList<>();
		
		for (MenuItem m : menuItems) {
			MenuDTO menuDTO = new MenuDTO(m.getName(), m.getPrice(), m.getType());
			dto.add(menuDTO);
		}
		
		return dto;
	}
	
	public List<MenuDTO> findAll() {
		Iterable<MenuItem> menuItems = menuItemRepository.findAll();
		List<MenuDTO> dto = new ArrayList<>();
		
		for (MenuItem m : menuItems) {
			MenuDTO menuDTO = new MenuDTO(m.getName(), m.getPrice(), m.getType());
			dto.add(menuDTO);
		}
		
		return dto;  
	}
	
	
}
