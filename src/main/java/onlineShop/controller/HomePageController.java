package onlineShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // Spring MVC will Map each @RequestMapping methods in the class as a register
public class HomePageController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String sayIndex() {
        return "index"; // find index.jsp
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); // find login.jsp

        if (error != null) {
            modelAndView.addObject("error", "Invalid username or password");
        }

        if (logout != null) {
            modelAndView.addObject("logout", "Logged out Successfully");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String sayAbout() {
        return "aboutUs"; // find aboutUs.jsp
    }
}
