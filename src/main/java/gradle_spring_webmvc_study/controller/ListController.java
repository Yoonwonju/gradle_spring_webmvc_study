package gradle_spring_webmvc_study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import gradle_spring_webmvc_study.dto.ListCommand;
import gradle_spring_webmvc_study.dto.Member;
import gradle_spring_webmvc_study.spring.MemberDao;

@Controller
public class ListController {

	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/members")
	public String list(@ModelAttribute("cmd") ListCommand listCommand,Errors errors, Model model) {
		if(errors.hasErrors()) {
			return "member/memberList";
		}
		if(listCommand.getFrom() != null && listCommand.getTo() != null) {
			List<Member> members = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
			model.addAttribute("members", members);
		}
		
		if(listCommand.getFrom() == null && listCommand.getTo() == null) {
			List<Member> members = memberDao.selectAll();
			model.addAttribute("members", members);
		}
		
		return "member/memberList";
	}
}
