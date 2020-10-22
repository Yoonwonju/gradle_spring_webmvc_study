package gradle_spring_webmvc_study.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gradle_spring_webmvc_study.dto.RegisterRequest;
import gradle_spring_webmvc_study.exception.DuplicateMemberException;
import gradle_spring_webmvc_study.service.MemberRegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private MemberRegisterService service;
	
	@RequestMapping("/step1")
	public String handleStep1() {
		return "/register/step1";
	}
	
//	@PostMapping("/step2")
//	public String handleStep2Post(
//			@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
//		if(!agree) {
//			return "register/step1";
//		}
//		model.addAttribute("registerRequest", new RegisterRequest());
//		return "register/step2";
//	}
	
	@PostMapping("/step2")
	public String handleStep2Post(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree, RegisterRequest registerRequest) {
		if(!agree) {
			return "register/step1";
		}
		return "register/step2";
	}
	
	// Redirect 처리
	@GetMapping("/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

	// 커맨드 객체를 이용해서 요청 파라미터 사용하기
	@PostMapping("/step3")
//	public String handleStep3Post(@ModelAttribute("formData") RegisterRequest regReq) {
	public String handleStep3Post(@Valid RegisterRequest regReq, Errors errors) {
//		@Valid 추가하여 아래줄 주석
//		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors())
			return "register/step2";
		
		try {
			service.regist(regReq);
			return "register/step3";
		}catch(DuplicateMemberException ex){
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
	
}
