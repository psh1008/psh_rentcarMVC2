package kr.basic.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.basic.util.MybatisConfig;
import kr.basic.vo.User;

public class UserDAO {

private UserDAO() {}
static private UserDAO instance;
static public UserDAO getInstance() { 
	if(instance == null) {
		instance = new UserDAO();
	}
	return instance;
}
	

public ArrayList<User> userList() {

	ArrayList<User> list = null;
	try(SqlSession session = MybatisConfig.getInstance().openSession()) {
		
		list = (ArrayList)session.selectList("userList");
		session.commit();
	} catch (Exception e) {
		System.out.println(" userJoin() 에러");
		e.printStackTrace();
	}
	return list;
}

public boolean checkLogin(String id, String pw) {
	
	
		User u = new User();
		u.setUserid(id);
		u.setPwd(pw);
		Integer count = MybatisConfig.getInstance().openSession().selectOne("checkLogin",u);
		 if(count != null && count > 0)return true;
	
	
	return false;
}


public int getUserNo(String id) {
	Integer count = MybatisConfig.getInstance().openSession().selectOne("getUserNo",id);
	return count;
}

public boolean isValidId(String id) {
	Integer count = MybatisConfig.getInstance().openSession().selectOne("isValidId", id);

    if (count != null && count > 0) {
        return true;
    }
	return false;
}

public int userJoin(User u) {
	int cnt =-1;
	try(SqlSession session = MybatisConfig.getInstance().openSession(false)) {
		System.out.println("user = " + u);
		cnt = session.insert("userJoin", u);
		session.commit();
	} catch (Exception e) {
		System.out.println(" userJoin() 에러");
		e.printStackTrace();
	}
	return cnt;
}

public int deleteUser(int num) {
	int cnt = 0;
	
	try(SqlSession session = MybatisConfig.getInstance().openSession()){
		cnt = session.delete("deleteUser",num);
		session.commit();
	} catch (Exception e) {
		System.out.println("deleteUser 에러");
		e.printStackTrace();
	}
	return cnt;
	
}

public int updateUser(int num, String email, String phone) {
    int cnt = 0;

    // HashMap을 사용하여 여러 매개변수를 전달
    Map<String, Object> paramMap = new HashMap<>();
    paramMap.put("num", num);
    paramMap.put("email", email);
    paramMap.put("phone", phone);

    try (SqlSession session = MybatisConfig.getInstance().openSession()) {
        cnt = session.update("updateUser", paramMap);
        session.commit();
    } catch (Exception e) {
        System.out.println("updateUser 에러");
        e.printStackTrace();
    }

    return cnt;
}

public User getUserInfo(int log) {
	
	User u = null;
	
	try (SqlSession session = MybatisConfig.getInstance().openSession()) {
        u = session.selectOne("getUserInfo",log);
    } catch (Exception e) {
        System.out.println("getUserInfo 에러");
        e.printStackTrace();
    }
	
	
	return u;
}

}
