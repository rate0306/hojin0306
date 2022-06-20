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
 * -�ڵ� �ڵ� ���� ���̺귯��
 * -�ݺ� �Ǵ� getter, setter, toString ���� �޼ҵ� �ۼ� �ڵ带 �ٿ��ִ�
 * �ڵ� ���̺귯��
 * 
 * lombok ��ġ ���
 * 1.���̺귯�� �ٿ� �� ���� (Maven pom.xml)
 * 2.�ٿ�ε� �� jar������ ã�� ��ġ(�۾���IDE ����)
 * 3.IDE �� ����
 * 
 * lombok ���� ���� ����
 * -uName,bTitle�� ���� �� ���ڰ� �ҹ��ڿ����� �ʵ���� ����� �ȵȴ�.
 * -�ʵ�� �ۼ��� �ҹ��� �α��� �̻����� �����ؾ���.
 * -����) elǥ��� ���� ���������� getter�޼ҵ带 ã�ԵǴµ�
 *      �̶� getName(),getTitle() �̶�� �̸����� �޼ҵ带 ȣ���ϱ� ����.
 *      ���� ����ϴ� ����̶�� getUName()�� �Ǳ⶧���� ȣ���� �� ����.
 */
@NoArgsConstructor //�⺻ ������
@AllArgsConstructor //��� �ʵ带 �Ű������� ���� ������
@Setter //setter
@Getter //getter
@ToString //toString
@EqualsAndHashCode //���� �ִ� ��� �޼ҵ带 �����ϴ� ������̼�
@Data //���� �ִ� ���
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
