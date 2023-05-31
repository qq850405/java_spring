package templates;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.*;
import com.example.demo.service.UserService;

@Controller
public class UserRegister {
	@Autowired
	private UserService service;
	@GetMapping("/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "register";
	}
	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute("user")User user) {
		service.registerUser(user);
		return "registerSuccess";
	}
}
