package com.abir.project.config;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abir.project.modal.Posts;
import com.abir.project.modal.User;
import com.abir.project.service.LocationService;
import com.abir.project.service.PostsService;
import com.abir.project.service.UserService;

@Controller
public class WebController {

	@Autowired
	private UserService userService;

	@Autowired
	private PostsService postsService;

	@Autowired
	private LocationService locationService;

	private Logger logger = LoggerFactory.getLogger(WebController.class);

	public void setAuth(HttpSession session) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		User user = userService.findByEmail(email);

		if (user != null) {
			session.setAttribute("user", user);
			session.setAttribute("id", user.getId());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("name", user.getName());
		}
	}

	@RequestMapping(value = { "/" })
	public ModelAndView homePage(HttpSession session) {
		
		setAuth(session);

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("allPosts", postsService.findAllPublic((Long) session.getAttribute("id")));
		modelAndView.addObject("userClickHome", true);
		return modelAndView;
	}

	@RequestMapping(value = { "/profile"}, method = RequestMethod.GET)
	public ModelAndView profilePage(@RequestParam(name = "message", required = false) String message, HttpSession session) {

		setAuth(session);

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("locations", locationService.findAll());
		modelAndView.addObject("user", session.getAttribute("user"));
		modelAndView.addObject("userPosts", postsService.findByUser((Long) session.getAttribute("id")));
		modelAndView.addObject("userClickProfile", true);

		if (message != null) {
			if (message.equals("selectLocation!")) {
				modelAndView.addObject("message", "Select a location!");
			} else if (message.equals("writeSomething!")) {
				modelAndView.addObject("message", "Write something for post!");
			} else if (message.equals("input_error!")) {
				modelAndView.addObject("message", "Invalid input fields!");
			}
		}
		
		return modelAndView;
	}

	@RequestMapping(value = { "/profile" }, method = RequestMethod.POST)
	public String createSignUp(@Validated @ModelAttribute("posts") Posts posts, BindingResult bindingResult, Model model) {
		
		System.out.println(posts.getLocation()+"----\n----"+posts.getText());
		
		if (posts.getLocation() == null) {
			return "redirect:/profile?message=selectLocation!";
		} else if (posts.getText().equals("")) {
			return "redirect:/profile?message=writeSomething!";
		} else if (bindingResult.hasErrors()) {
			return "redirect:/profile?input_error";
		} else {
			postsService.save(posts);
			return "redirect:/profile";
		}
		
	}


	@RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
	public ModelAndView editPage(@RequestParam(name = "id", required = false) long id,  HttpSession session) {

		setAuth(session);

		ModelAndView modelAndView = new ModelAndView("index");
		
		modelAndView.addObject("locations", locationService.findAll());
		modelAndView.addObject("user", session.getAttribute("user"));

		Posts posts = postsService.findById(id);
		modelAndView.addObject("postEdit", posts);
		modelAndView.addObject("userClickEdit", true);

		
		return modelAndView;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView viewSignUp(@RequestParam(name = "message", required = false) String message) {

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickSignUp", true);
		mv.addObject("title", "SignUp");
		mv.addObject("user", new User());

		if (message != null) {
			if (message.equals("alreadyRegistered!")) {
				mv.addObject("message", "Alredy registered with this email!");
			} else if (message.equals("passwordMismatched!")) {
				mv.addObject("message", "Confirm Password doesn't match with Password!!");
			} else if (message.equals("input_error!")) {
				mv.addObject("message", "Invalid input fields!");
			}
		}
		return mv;
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.POST)
	public String createSignUp(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

		if (userService.findByEmail(user.getEmail()) != null) {
			return "redirect:/signup?message=alreadyRegistered!";
		} else if (!user.getPassword().equals(user.getConfirmPassword())) {
			return "redirect:/signup?message=passwordMismatched!";
		} else if (bindingResult.hasErrors()) {
			model.addAttribute("userClickSignUp", true);
			return "page";
		} else {
			userService.save(user);
			return "redirect:/login";
		}
	}

	@RequestMapping(value = { "/login" })
	public ModelAndView showLogin(@RequestParam(name = "message", required = false) String message) {

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("userClickLogin", true);
		mv.addObject("title", "Login");

		if (message != null) {
			if (message.equals("error")) {
				mv.addObject("message", "Login error!");
			}
		}
		return mv;
	}

}
