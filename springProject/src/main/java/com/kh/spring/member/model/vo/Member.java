package com.kh.spring.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * lombok
 * -자동 코드 생성 라이브러리
 * -반복 되는 getter, setter, toString 등의 메소드 작성 코드를 줄여주는
 * 코드 라이브러리
 * 
 * lombok 설치 방법
 * 1.라이브러리 다운 후 적용 (Maven pom.xml)
 * 2.다운로드 된 jar파일을 찾아 설치(작업할IDE 선택)
 * 3.IDE 재 실행
 * 
 * lombok 사용시 주의 사항
 * -uName,bTitle과 같이 앞 글자가 소문자외자인 필드명은 만들면 안된다.
 * -필드명 작성시 소문자 두글자 이상으로 시작해야함.
 * -이유) el표기법 사용시 내부적으로 getter메소드를 찾게되는데
 *      이때 getName(),getTitle() 이라는 이름으로 메소드를 호출하기 때문.
 *      기존 사용하는 방식이라면 getUName()이 되기때문에 호출할 수 없다.
 */
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드를 매개변수로 갖는 생성자
@Setter //setter
@Getter //getter
@ToString //toString
@EqualsAndHashCode //위에 있는 모든 메소드를 포암하는 어노테이션
@Data //위에 있는 모든
public class Member {
	
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String gender;
	private String age;
	private String phone;
	private String address;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
	

}
