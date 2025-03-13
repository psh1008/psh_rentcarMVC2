package kr.basic.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.basic.util.MybatisConfig;
import kr.basic.vo.RentCar;

public class RentCarDAO {
	
	private RentCarDAO() {}
	static private RentCarDAO instance;
	static public RentCarDAO getInstance() { 
		if(instance == null) {
			instance = new RentCarDAO();
		}
		return instance;
	}
	public ArrayList<RentCar> rentcarList() {
		
		ArrayList<RentCar> list = null;
		
		
		
		try(SqlSession session = MybatisConfig.getInstance().openSession()){
			list = (ArrayList)session.selectList("rentcarList");
		} catch (Exception e) {
			System.out.println("rentcarList 에러");
			e.printStackTrace();
		}
		return list;
	}
	
public ArrayList<RentCar> CarListByCategory(int num) {
		
		ArrayList<RentCar> list = null;
		
		try(SqlSession session = MybatisConfig.getInstance().openSession()){
			list = (ArrayList)session.selectList("carListByCategory",num);
		} catch (Exception e) {
			System.out.println("CarListByCategory 에러");
			e.printStackTrace();
		}
		return list;
	}
	
	public RentCar getOneCarInfo(int num) {
		
		RentCar car = null;
		
		try(SqlSession session = MybatisConfig.getInstance().openSession()){
			car = session.selectOne("getOneCarInfo",num);
		} catch (Exception e) {
			System.out.println("getOneCarInfo 에러");
			e.printStackTrace();
		}
		return car;
	}

	public int addRentcar(String name,int category,int price,int usepeople,int total_qty,
			String company,String img,String info) {
		
		int cnt = 0;
		
		RentCar rc = new RentCar(name,category,price,usepeople,total_qty,company,img,info);
		try(SqlSession session = MybatisConfig.getInstance().openSession()){
			cnt = session.insert("addRentcar",rc);
			session.commit();
		} catch (Exception e) {
			System.out.println("addRentcar 에러");
			e.printStackTrace();
		}
		
		
		return cnt;
	}
	
	
}
