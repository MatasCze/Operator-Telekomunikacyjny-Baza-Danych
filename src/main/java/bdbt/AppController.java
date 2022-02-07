package bdbt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	private String perm;

	@Autowired
	private OperatorzyDAO dao;
	
	@Autowired
	private KlientDAO kdao;
	
	@Autowired
	private UslugaDAO udao;
	
	@Autowired
	private AdresDAO adao;
	

	
	public String getPerm() {
		return perm;
	}

	public void setPerm(String perm) {
		this.perm = perm;
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginForm() {
		return "login";
	}
	
	@RequestMapping("/admin")
	public String adminPage(Model model) {
		if("a".equals(perm)) {
			return "admin";
		}
		if("b".equals(perm)){
			return "pracownik";
		}
		return "admin";
	}
	
	@RequestMapping("/")
	public String indexPage(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {
		
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		
		if("admin".equals(username) && "admin".equals(password)) {
			perm = "a";
			return "/admin";
		}
		if("pracownik".equals(username) && "pracownik".equals(password)) {
			perm = "b";
			return "/pracownik";
		}
		model.addAttribute("invalidCredentials", true);
		return "/login";
	}
	
	

	@RequestMapping("/operatorzy")
	public String viewHomePage(Model model) {
		List<Operatorzy> listOperatorzy = dao.list();
		model.addAttribute("listOperatorzy", listOperatorzy);
		return "/operatorzy";
		
	
	}
	


	@RequestMapping("/new")
	public String showNewForm(Model model) {

		Operatorzy operatorzy = new Operatorzy();
		model.addAttribute("operatorzy", operatorzy);
		return "new_form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("operatorzy") Operatorzy operatorzy) {

		dao.save(operatorzy);
		return "redirect:/operatorzy";

	}
		
	@RequestMapping("/edit/{nr_operatora}")
	public ModelAndView showEditForm(@PathVariable(name = "nr_operatora") int id) {
		ModelAndView mav = new ModelAndView("edit_form");
		Operatorzy operatorzy = dao.get(id);
		mav.addObject("operatorzy",operatorzy);
		
		return mav;
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	public String update(@ModelAttribute("operatorzy") Operatorzy operatorzy) {
		dao.update(operatorzy);
		
		return "redirect:/operatorzy";
	}
	
	@RequestMapping("/delete/{nr_operatora}")
	public String delete(@PathVariable(name = "nr_operatora") int nr_operatora) {
		dao.delete(nr_operatora);
		return "redirect:/operatorzy";
		
	}
	
	@RequestMapping("/usluga")
	public String usluga(Model model) {
		List<Usluga> listUsluga = udao.list();
		model.addAttribute("listUsluga", listUsluga);
		return "usluga";
	}
	
	@RequestMapping("/newusluga")
	public String showNewUsluga(Model model) {

		Usluga usluga = new Usluga();
		model.addAttribute("usluga", usluga);
		return "newusluga";
	}
	@RequestMapping(value = "/saveusluga", method = RequestMethod.POST)
	public String saveusluga(@ModelAttribute("usluga") Usluga usluga) {

		udao.save(usluga);
		return "redirect:/usluga";

	}
	@RequestMapping("/editusluga/{nr_uslugi}")
	public ModelAndView showEditUsluga(@PathVariable(name = "nr_uslugi") int id) {
		ModelAndView mav = new ModelAndView("editusluga");
		Usluga usluga = udao.get(id);
		mav.addObject("usluga", usluga);
		
		return mav;
	}
	@RequestMapping(value = "/updateusluga", method=RequestMethod.POST)
	public String updateusluga(@ModelAttribute("usluga") Usluga usluga) {
		udao.update(usluga);
		
		return "redirect:/usluga";
	}
	
	@RequestMapping("/deleteusluga/{nr_uslugi}")
	public String deleteusluga(@PathVariable(name = "nr_uslugi") int nr_uslugi) {
		udao.delete(nr_uslugi);
		return "redirect:/usluga";
		
	}
	
	@RequestMapping("/klient")
	public String klient(Model model) {
		List<Klient> listKlient = kdao.list();
		model.addAttribute("listKlient", listKlient);
		return "klient";
	}
	
	@RequestMapping("/newklient")
	public String showNewKlient(Model model) {

		Klient klient = new Klient();
		model.addAttribute("klient", klient);
		return "newklient";
	}
	@RequestMapping(value = "/saveklient", method = RequestMethod.POST)
	public String saveklient(@ModelAttribute("klient") Klient klient) {

		kdao.save(klient);
		return "redirect:/klient";

	}
	@RequestMapping("/editklient/{nr_klienta}")
	public ModelAndView showEditKlient(@PathVariable(name = "nr_klienta") int id) {
		ModelAndView mav = new ModelAndView("editklient");
		Klient klient = kdao.get(id);
		mav.addObject("klient", klient);
		
		return mav;
	}
	@RequestMapping(value = "/updateklient", method=RequestMethod.POST)
	public String updateklient(@ModelAttribute("klient") Klient klient) {
		kdao.update(klient);
		
		return "redirect:/klient";
	}
	
	@RequestMapping("/deleteklient/{nr_klienta}")
	public String deleteklient(@PathVariable(name = "nr_klienta") int nr_klienta) {
		kdao.delete(nr_klienta);
		return "redirect:/klient";
		
	}
	
	@RequestMapping("/adres")
	public String adres(Model model) {
		List<Adres> listAdres = adao.list();
		model.addAttribute("listAdres", listAdres);
		return "adres";
	}
	
	@RequestMapping("/newadres")
	public String showNewadres(Model model) {

		Adres adres = new Adres();
		model.addAttribute("adres", adres);
		return "newadres";
	}
	@RequestMapping(value = "/saveadres", method = RequestMethod.POST)
	public String saveadres(@ModelAttribute("adres") Adres adres) {

		adao.save(adres);
		return "redirect:/adres";

	}
	@RequestMapping("/editadres/{nr_adresu}")
	public ModelAndView showEditadres(@PathVariable(name = "nr_adresu") int id) {
		ModelAndView mav = new ModelAndView("editadres");
		Adres adres = adao.get(id);
		mav.addObject("adres", adres);
		
		return mav;
	}
	@RequestMapping(value = "/updateadres", method=RequestMethod.POST)
	public String updateadres(@ModelAttribute("adres") Adres adres) {
		adao.update(adres);
		
		return "redirect:/adres";
	}
	
	@RequestMapping("/deleteadres/{nr_adresu}")
	public String deleteadres(@PathVariable(name = "nr_adresu") int nr_adresu) {
		adao.delete(nr_adresu);
		return "redirect:/adres";
		
	}
	



}
