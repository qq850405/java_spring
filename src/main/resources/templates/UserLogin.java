//package templates;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.demo.entity.User;
//import com.example.demo.repo.UserRepository;
//
//@Controller
//public class UserLogin {
//@Autowired
//	private UserRepository repository;
//
//	@GetMapping("/login")
//	public String login(Model model) {
//		User user = new User();
//		model.addAttribute("user", user);
//		return "login";
//	}
//	@PostMapping("/userLogin")
//	public String loginUser(@ModelAttribute("user")User user) {
//		Example<? extends User> username = null;
//		User userdata = (User) repository.findBy(username);
//		String password = "";
//		if (password.equals(userdata.getMemPassword())) {
//			return "LoginSuccess";
//		} else {
//			return "LoginFail";
//		}
//	}
//
//}
//
