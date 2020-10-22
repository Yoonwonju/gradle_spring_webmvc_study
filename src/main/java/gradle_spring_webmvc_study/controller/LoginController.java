package gradle_spring_webmvc_study.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gradle_spring_webmvc_study.dto.Code;
import gradle_spring_webmvc_study.dto.Login;
import gradle_spring_webmvc_study.dto.OsCode;

@Controller
//@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("/login1")
	public String form1(Login login){
		return "login/form";
	}
	
	@GetMapping("/login2")
	public String form2(Login login){
		login.setLoginType("기업회원");
		login.setJobCode("A");
		login.setTool("VSCode");
		List<String> favoriteOsNames = Arrays.asList("윈도우10", "우분투");
		login.setFavoriteOs(favoriteOsNames);
		List<String> osCode = Arrays.asList("O1","O3");
		login.setOsCode(osCode);
		return "login/form";
	}
	
	@ModelAttribute("tools")
	public List<String> getTools(){
		List<String> tools = new ArrayList<String>();
		tools.add("Eclipse");
		tools.add("IntelliJ");
		tools.add("VSCode");
		return tools;
	}
	
	@ModelAttribute("jobCodes")
	public List<Code> getJobCodes(){
		List<Code> jobCodes = new ArrayList<Code>();
		jobCodes.add(new Code("A", "사용자"));
		jobCodes.add(new Code("B", "개발자"));
		jobCodes.add(new Code("C", "관리자"));
		return jobCodes;
	}
	
	@ModelAttribute("loginTypes")
	public List<String> getLoginTypes(){
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}

	
	@ModelAttribute("favoriteOsNames")
	public List<String> getFavoriteOsNames(){
		List<String> favoriteOsNames = new ArrayList<String>();
		favoriteOsNames.add("윈도우10");
        favoriteOsNames.add("리눅스");
        favoriteOsNames.add("유닉스");
        favoriteOsNames.add("칼리리눅스");
        favoriteOsNames.add("우분투");
		return favoriteOsNames;
	}
	
	@ModelAttribute("osCodes")
	public List<OsCode> getOsCodes(){
		List<OsCode> osCodes = new ArrayList<OsCode>();
		osCodes.add(new OsCode("O1", "윈도우10"));
		osCodes.add(new OsCode("O2", "리눅스"));
		osCodes.add(new OsCode("O3", "유닉스"));
		osCodes.add(new OsCode("O4", "칼리리눅스"));
		osCodes.add(new OsCode("O5", "우분투"));
		return osCodes;
	}
	
	@ModelAttribute("subjects")
	public List<Code> getSubjects(){
		List<Code> subjects = new ArrayList<Code>();
		subjects.add(new Code("S1", "윈도우10"));
		subjects.add(new Code("S2", "리눅스"));
		subjects.add(new Code("S3", "유닉스"));
		subjects.add(new Code("S4", "칼리리눅스"));
		subjects.add(new Code("S5", "우분투"));
		return subjects;
	}
	
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
	
	@PostMapping("/result")
	public String result(@ModelAttribute("login") Login login){
		return "login/result";
	}
	
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
