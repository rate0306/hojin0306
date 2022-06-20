package com.kh.spring.member.model.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDao;
import com.kh.spring.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{

   @Autowired
   private MemberDao memberDao;
   
   @Autowired
   private SqlSessionTemplate sqlSession;
   
   @Override
   public Member loginMember(Member m) {
      
      Member loginUser = memberDao.loginMember(sqlSession,m);
      
      /*SqlSessionTemplate ��ü�� bean ��� �� @Autowired ���ָ�
       * ������ �����̳ʰ� ��� �� �ڵ����� �ݳ����ֱ� ������ close()�� �� �ʿ䰡 ����.
       * */
      
      return loginUser;
   }

   @Override
   public int insertMember(Member m) {
      
      int result = memberDao.insertMember(sqlSession,m);
      
      return result;
   }

   @Override
   public int updateMember(Member m) {
      
      int result = memberDao.updateMember(sqlSession,m);
      
      return result;
   }

   @Override
   public int deleteMember(String userId) {
      return 0;
   }

   @Override
   public int idCheck(String userId) {
	return 0;
   }

}