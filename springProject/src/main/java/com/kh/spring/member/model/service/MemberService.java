package com.kh.spring.member.model.service;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {
	
	//�α��� ���� (select)
	Member loginMember(Member m);
	
	//ȸ������ ���� (insert)
	int insertMember(Member m);
	
	//ȸ�� �������� ���� (update)
	int updateMember(Member m);
	
	//ȸ�� Ż�� ���� (update)
	int deleteMember(String userId);
	
	//���̵� �ߺ�üũ ���� (select)
	int idCheck(String userId);

}
