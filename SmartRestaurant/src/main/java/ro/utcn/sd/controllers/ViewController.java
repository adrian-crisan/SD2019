package ro.utcn.sd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ro.utcn.sd.dto.MenuDTO;
import ro.utcn.sd.service.MenuItemService;

@Controller
public class ViewController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping("/loginAsUser")
	public String loginAsUser() {
		return "index";
	}
	

	@RequestMapping("/loginAsAdmin")
	public String loginAsAdmin() {
		return "admin";  
	}
	
	@RequestMapping("/menu")
	public String menu(Model model) {
		List<MenuDTO> dto = menuItemService.findAllByType("STARTER");
		List<MenuDTO> dto2 = menuItemService.findAllByType("MAIN COURSE");
		List<MenuDTO> dto3 = menuItemService.findAllByType("DESERT");
		List<MenuDTO> dto4 = menuItemService.findAllByType("BEVERAGE");
		
		model.addAttribute("menuItems", dto);
		model.addAttribute("menuItems2", dto2); 
		model.addAttribute("menuItems3", dto3);
		model.addAttribute("menuItems4", dto4);
		 
		return "menu";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		return "logout";      
	}

}
