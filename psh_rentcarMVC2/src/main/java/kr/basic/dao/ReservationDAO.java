package kr.basic.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.basic.util.MybatisConfig;
import kr.basic.vo.JoinCarView;
import kr.basic.vo.Reservation;

public class ReservationDAO {
	
private ReservationDAO() {}
static private ReservationDAO instance;
static public ReservationDAO getInstance() { 
	if(instance == null) {
		instance = new ReservationDAO();
	}
	return instance;
}


public int addCarReservation(int num,String id,String qty,String dday,String rday,String usein,String usewifi
		,String usenavi,String useseat) {
	
	
	
	Reservation rv = new Reservation(num,id,Integer.parseInt(qty),
			Integer.parseInt(dday),rday,Integer.parseInt(usein),Integer.parseInt(usewifi),
			Integer.parseInt(usenavi),Integer.parseInt(useseat));
	int cnt = -1;
	try(SqlSession session = MybatisConfig.getInstance().openSession()){
		
		cnt = session.insert("addCarReservation",rv);
		session.commit();
		System.out.println(rv);
		return cnt;
	} catch (Exception e) {
		System.out.println("addCarReservation 에러");
		e.printStackTrace();
	}
	return cnt;
}


public List<JoinCarView> getAllReservations() {
	List<JoinCarView> list = null;
    try (SqlSession session = MybatisConfig.getInstance().openSession()) {
        list = session.selectList("getAllReservations");
    } catch (Exception e) {
        System.out.println("getAllReservations 에러");
        e.printStackTrace();
    }
    return list;
}


public List<JoinCarView> getReservationList(int log) {
	List<JoinCarView> list = null;
	try(SqlSession session = MybatisConfig.getInstance().openSession()){
		list = session.selectList("getReservationList",log);
		
	} catch (Exception e) {
		System.out.println("getReservationList 에러");
		e.printStackTrace();
	}
	
return list;
}


public int deleteReservation(int reserveSeq) {
	
	int cnt = 0;
	
	try(SqlSession session = MybatisConfig.getInstance().openSession()){
		cnt = session.delete("deleteReservation",reserveSeq);
		session.commit();
	} catch (Exception e) {
		System.out.println("deleteReservation 에러");
		e.printStackTrace();
	}
	return cnt;
}

public void addJoinCarList(int num, String name, int price, String img, int qty, int dday, String rday, int usein,
		int usewifi, int useseat, int usenavi, int totalPrice, String endDate) {
	
	
}



}
