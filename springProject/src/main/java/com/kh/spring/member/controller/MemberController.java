package com.kh.spring.member.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.service.MemberService;
import com.kh.spring.member.model.vo.Member;
@Controller  //Controller 타입의 어노테이션을 붙여주면 빈 스캐너가 자동으로 빈 등록해줌
public class MemberController {
	
	//private MemberService memberService = new MemberServiceImpl
	/*
	 * 기존 객체 생성 방식
	 * 서비스가 동시에 많은 회수가  요청되면 그만큼 객체가 생성된다
	 * 객체간의 결합도가 높아진다 (소스 코드의 수정이 일어날 경우 해당코드를 작성한 곳에 전부 수정이 이루어져야 한다.)
	 * Spring의 DI(Dependency injection) 객체를 생성해서 주입해준다.
	 * 
	 * new 연사자를 쓰지않고 선언만 해도 되지만 @Autowired 어노테이션을 작성해줘야 한다.
	 */
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	/*
	 * 
	 * @RequestMapping(value="login.me") //RequestMapping 타입의 어노테이션을 붙여서 HandlerMapping등록
	 * ()안에 속성을 여러개 넣을거라면 속성명=값,속성명=값 형태로 작성 매핑값 1개만 쓸거라면 값만 써도 됨
	 * @RequestMapping("login.me") 
	 *
	 * 
	 * Spring에서 parameter(요청시 전달 값) 받는 방법 
	 * 
	 * 1.HttpServletRequest을 이용해서 전달받기 (기존 jsp/servlet방식)
	 * 해당 메소드의 매개변수로 HttpServletRequest를 작성해 놓으면
	 * 스프링 컨테이너가 해당 메소드를 호출할때(실행) 자동으로 해당 객체를 생성해서 매개변수로 주입해준다.
	 * 
	 * */
	/*
	@RequestMapping(value="login.me")
	public String loginMember(HttpServletRequest request) {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println("userId : "+userId);
		System.out.println("userPwd : "+userPwd);
		
		return "main";
	}
	*/
	
	/*
	 * 2. @RequestParam 어노테이션을 이용하는 방법
	 * request.getParameter("키")로 값을 뽑는 역할을 대신 수행해주는 어노테이션
	 * value속성의 value로 jsp에서 작성했던 name값을 입력해주면 알아서 매개변수로 담아온다.
	 * 만약 넘어온 값이 비어있다면 defaultValue로 기본값 설정도 가능
	 * 
	 * */
	/*
	@RequestMapping("login.me")
	public String loginMember(@RequestParam(value="userId",defaultValue="sss") String userId,
							  @RequestParam(value="userPwd") String userPwd) {
			
		System.out.println(userId);
		System.out.println(userPwd);
			
			return "main";
	}
	*/
	
	/*
	 *3.@RequestParam 어노테이션을 생략하는 방법
	 *단 매개변수 명을 jsp의 name 속성값 (요청시 전달한 키값) 과 동일하게 세팅해줘야한다.
	 *또한 위에서 사용했던 defaultValue 속성 사용 불가 
	 * 
	 * 
	 * */
	/*@RequestMapping("login.me")
	public String loginMember(String userId,String userPwd) {
			
		System.out.println(userId);
		System.out.println(userPwd);
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		//service에 멤버객체 m을 보내면서 조회
			
		return "main";
	}
	*/
	/*
	 * 4.커맨드 객체 방식
	 * 해당 메소드의 매개변수로
	 * 요청시 전달값을 담고자하는 VO 클래스 타입으로 세팅하고
	 * 요청시 전달갑의 키값(jsp에서 넘겨주는 name)을 VO클래스에 담고자 하는 필드명으로 작성
	 * 
	 * 스프링 컨테이너가 해당 객체를 기본생성자로 생성 후 내부적으로 setter 메소드를 찾아서
	 * 요청시 전달한 값을 필드에 담아준다.
	 * 
	 * 주의) name값과 감고자하는 필드명이 같아야함
	 */
	
	/*
	 * 요청 처리 후 응답데이터를 담고 응답페이지로 포워딩 또는 url 재요청 하는 방법
	 * 
	 * 1.스프링에서 제공하는 Model 객체를 이용하는 방법
	 * 포워딩할 응답뷰로 전달하고자 하는 데이터를 맵형식 (key-value) 으로 담을 수 있는 영역
	 * Model 객체 requestScope이다.
	 * 단 setAttribute가 아닌 addAttribute를 이용
	 */
	
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m
							,HttpSession session
							,ModelAndView mv) {
		
		//암호화 전
		/*
		Member loginUser = memberService.loginMember(m);
		
		if(loginUser == null) {
			//model.addAttribute("errorMsg","로그인 실패");
			mv.addObject("errorMsg","로그인 실패");
			
//			return "common/errorPage";
			mv.setViewName("common/errorPage");
		}else {
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		}
		
		return mv;
		*/
		
		//암호화 작업 후
		//기존에 평문이 DB에 등록되어 있었기 떄문에 아이디랑 비밀번호를 같이 입력받아 조회하는 형태로 작업 했었음
		//암호화 작업을 하면 입력받은 비밀번호는 평문이지만 DB에 등록되어있는 비밀번호는 암호문이기 떄문에
		//비교시 무조건 다르게 됨
		//아이디로 먼저 회원정보 조회 후 회원이 있으면 비밀번호 암호문 비교 메소드를 
		
		Member loginUser = memberService.loginMember(m);
		//loginUser : 아이디로만 조회된 회원정보
		//loginUser의 userPwd : 담겨있는 비밀번호는 암호화된 비밀번호
		//m.getUserPwd() 암호화 안된 비밀번호(request받은)
		
		//BCryptPasswordEncoder 객체 matches 메소들 사용
		//matches(평문,암호문)을 작성하면 내부적으로 복호화 작업이 이루어져서
		//boolean자료형으로 반납(일치하면true/ 아니면 false)
		
		if(loginUser != null && bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())) {
			//아이디로만 조회해온 로그인 유저가 있고(아이디가 있다) 입력받은 평문과DB에 있는 암호문이 일치하면
			//로그인 성공
			
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		}else {
			//로그인 실패
			mv.addObject("errorMsg","로그인실패");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}

		
		/*
		 * 2.스프링에서 제공하는 ModelAndView 객체를 이용하는 방법
		 * Model은 데이터를 key-value 세트로 담을 수 있다면
		 * view는 응답뷰에 대한 정보를 담을 수 있다.
		 * 이 경우에는 리턴 타입 (반환형)이 String 이 아닌 modelAndView 형태로 return 해야한다
		 * 
		 * Model과View가 결합된 형태의 객체.
		 * Model은 단독 사용 가능하지만 View는 불가능하다.
		 * 
		 */
		


	
	@RequestMapping("logout.me")
	public String logoutMember(HttpSession session) {
		
		session.removeAttribute("loginUser");
		
		return "redirect/";
	}
	
	@RequestMapping("enrollForm.me")
	public String enrollForm() {
		
		return "member/memberEnrollForm";
	}
	
	@RequestMapping("insert.me")
	public String insertMember(Member m,HttpSession session,Model model) {
		
		/*
		 * 1.한글깨짐 문제 -> web.xml에 스피링에서 제공하는 인코딩 필터를 등록
		 * 2.나이를 입력하지 않았을때 int자료형에 빈문자열이 들어갈 수 없어서 나는 400오류
		 *  ->Member vo에 age필드를 String자료형으로 변경(오라클엔 Number지만 자동변환이 되기때문에 괜찮다)
		 * 3.비밀번호가 사용자가 입력한 그대로(평문)이기 때문에 보안문제
		 *      ->Bcrypt 방식의 암호화를 통해서 pwd를 암호문으로 변경
		 *      1)spring security 모듈에서 라이브러리 3개 pom.xml에 등록
		 *      2)BCrtptPasswordEncoder 클래스를  xml파일에 bean 등록
		 *      3)web.xml에서 로딩할 수 있게 작성
		 */
		
		System.out.println("암호화 전 평문 : "+m.getUserId());
		
		//암호화 작업
		String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
		
		System.out.println("암호화 후 비밀번호 : "+encPwd);
		
		//암호화 된 pwd를 Member m 에 담아주기(평문과 바꿔치기)
		m.setUserPwd(encPwd);
		
		int result = memberService.insertMember(m);
		
		if(result>0) {
			//성공 - 메인페이지로 보내면서 alert 메세지 띄우기
			session.setAttribute("alertMsg", "회원가입 성공");
			return "redirect:/";
		}else {
			//실패 - error페이지로 메세지 담아서 보내기
			model.addAttribute("errorMsg","회원가입 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("myPage.me")
	public String myPage() {
		
		return "member/myPage";
	}
	
	@RequestMapping("update.me")
	public String updateMember(Member m,Model model,HttpSession session) {
		
		int result = memberService.updateMember(m);
		
		if(result>0) {//성공
			//성공했으니 DB에 등록된 변경정보를 다시 조회해와서 세션에 담아야한다.
			Member updateMem = memberService.loginMember(m);
			session.setAttribute("loginUser", updateMem);
			
			session.setAttribute("alertMsg", "정보수정 성공");
			return "redirect:/myPage.me";
		}else { //실패
			
			model.addAttribute("errorMsg","회원 정보 수정 실패");
			
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("delete.me")
	public String deleteMember(String userPwd) {
		
		System.out.println(userPwd);
		
		return null;
	}zz

}