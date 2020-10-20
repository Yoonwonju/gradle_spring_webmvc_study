package gradle_spring_webmvc_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	//	/hello경로로 들어온 요청을 hello() 메소드를 이용하여 처리
	//	Model Parameter는 컨트롤러의 처리 결과를 뷰에 전달할 때 사용
	//	@RequestParam : Http 요청 parameter value 메소드의 parameter로 전달
	//	@RequestParam("가져올 데이터의 이름") [데이터타입] [가져온데이터를 담을 변수]

	@GetMapping("/hello")
	public String hello(Model model, @RequestParam(value = "name", required = false) String name) {
		model.addAttribute("greeting", "안녕하세요, " + name);
		return "hello";
	}
}
