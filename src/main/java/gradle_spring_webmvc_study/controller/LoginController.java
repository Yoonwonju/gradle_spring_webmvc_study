package gradle_spring_webmvc_study.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gradle_spring_webmvc_study.exception.WrongIdPasswordException;
import gradle_spring_webmvc_study.service.AuthService;
import gradle_spring_webmvc_study.spring.AuthInfo;
import gradle_spring_webmvc_study.spring.LoginCommand;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AuthService authService;

	@GetMapping
	public String form(LoginCommand loginCommand, @CookieValue(value="REMEMBER", required = false) Cookie rCookie) {
		if(rCookie != null) {
			loginCommand.setEmail(rCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "/login/form";
	}

	@PostMapping
	public String submit(@Valid LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		// @Valid로 변경
		// new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors())
			return "/login/form";
		try {
			AuthInfo authInfo = authService.authenicate(loginCommand.getEmail(), loginCommand.getPassword());
			// 세션에 authInfo 저장
			session.setAttribute("authInfo", authInfo);
			
            //쿠키를 이용한 이메일기억하기 적용
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			if(loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			}else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);

			return "/login/loginSuccess";
		} catch (WrongIdPasswordException ex) {
			errors.reject("idPasswordNotMatching");
			return "/login/form";
		}
	}
	
	
//	@GetMapping("/login1")
//	public String form1(Login login){
//		return "login/form";
//	}
//	
//	@GetMapping("/login2")
//	public String form2(Login login){
//		login.setLoginType("기업회원");
//		login.setJobCode("A");
//		login.setTool("VSCode");
//		List<String> favoriteOsNames = Arrays.asList("윈도우10", "우분투");
//		login.setFavoriteOs(favoriteOsNames);
//		List<String> osCode = Arrays.asList("O1","O3");
//		login.setOsCode(osCode);
//		return "login/form";
//	}
//	
//	@ModelAttribute("tools")
//	public List<String> getTools(){
//		List<String> tools = new ArrayList<String>();
//		tools.add("Eclipse");
//		tools.add("IntelliJ");
//		tools.add("VSCode");
//		return tools;
//	}
//	
//	@ModelAttribute("jobCodes")
//	public List<Code> getJobCodes(){
//		List<Code> jobCodes = new ArrayList<Code>();
//		jobCodes.add(new Code("A", "사용자"));
//		jobCodes.add(new Code("B", "개발자"));
//		jobCodes.add(new Code("C", "관리자"));
//		return jobCodes;
//	}
//	
//	@ModelAttribute("loginTypes")
//	public List<String> getLoginTypes(){
//		List<String> loginTypes = new ArrayList<String>();
//		loginTypes.add("일반회원");
//		loginTypes.add("기업회원");
//		loginTypes.add("헤드헌터회원");
//		return loginTypes;
//	}
//
//	
//	@ModelAttribute("favoriteOsNames")
//	public List<String> getFavoriteOsNames(){
//		List<String> favoriteOsNames = new ArrayList<String>();
//		favoriteOsNames.add("윈도우10");
//        favoriteOsNames.add("리눅스");
//        favoriteOsNames.add("유닉스");
//        favoriteOsNames.add("칼리리눅스");
//        favoriteOsNames.add("우분투");
//		return favoriteOsNames;
//	}
//	
//	@ModelAttribute("osCodes")
//	public List<OsCode> getOsCodes(){
//		List<OsCode> osCodes = new ArrayList<OsCode>();
//		osCodes.add(new OsCode("O1", "윈도우10"));
//		osCodes.add(new OsCode("O2", "리눅스"));
//		osCodes.add(new OsCode("O3", "유닉스"));
//		osCodes.add(new OsCode("O4", "칼리리눅스"));
//		osCodes.add(new OsCode("O5", "우분투"));
//		return osCodes;
//	}
//	
//	@ModelAttribute("subjects")
//	public List<Code> getSubjects(){
//		List<Code> subjects = new ArrayList<Code>();
//		subjects.add(new Code("S1", "윈도우10"));
//		subjects.add(new Code("S2", "리눅스"));
//		subjects.add(new Code("S3", "유닉스"));
//		subjects.add(new Code("S4", "칼리리눅스"));
//		subjects.add(new Code("S5", "우분투"));
//		return subjects;
//	}
//	
//	@PostMapping("/result")
//	public String result(@ModelAttribute("login") Login login){
//		return "login/result";
//	}
	
	
	
	
	
	
//	private List<Code> getSelectedSubject(List<String> strSubject) {
//        List<Code> subjects = getSubjects();
//        List<Code> selected = new ArrayList<>();
//        for(String c : strSubject) {
//            Code code = new Code(c, null);
//            if (subjects.contains(code)) {
//                selected.add(subjects.get(subjects.indexOf(code)));
//            }
//        }
//        return selected;
//    }
	

	
//	@GetMapping("/login")
//	public String form(Model model, Login login){
//		List<String> loginTypes = new ArrayList<String>();
//		loginTypes.add("일반회원");
//		loginTypes.add("기업회원");
//		loginTypes.add("헤드헌터회원");
//		
//		model.addAttribute("loginTypes", loginTypes);
////		model.addAttribute("login", new Login());
//		return "login/form";
//		
////		ModelAndView mav = new ModelAndView("login/form");
////		return mav;
//	}
	
//	@ModelAttribute("tools")
//	public List<String> getTools(){
//		List<String> tools = new ArrayList<String>();
//		return tools;
//	}
	
//	@ModelAttribute("codes")
//	public List<JobCode> getCodes(){
//		List<JobCode> loginTypes = new ArrayList<JobCode>();
//		loginTypes.add("일반회원");
//		loginTypes.add("기업회원");
//		loginTypes.add("헤드헌터회원");
//		return loginTypes;
//	}
}
