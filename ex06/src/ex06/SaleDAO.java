package ex06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {

	Connection con = Databass.connect();

	// 판매정보
	public List<SaleVO> list(int pcode) {
		List<SaleVO> array = new ArrayList<>();

		try {
			String sql = "SELECT * FROM SALE WHERE PCODE=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, pcode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SaleVO vo = new SaleVO();
				vo.setQnt(rs.getInt("qnt"));
				vo.setSprice(rs.getInt("Sprice"));
				vo.setSdate(rs.getTimestamp("sdate"));
				array.add(vo);
			}
		} catch (Exception e) {
			System.out.println("판매정보목록 : " + e.toString());
		}
		return array;
	}

}
