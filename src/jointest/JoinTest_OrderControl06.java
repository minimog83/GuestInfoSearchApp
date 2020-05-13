package jointest;
import control.KiddaLaController;
// 結合番号６　ドライバクラス
public class JoinTest_OrderControl06 {
	public static void main(String[] args) {
		try {
			// 項番１，２，３
			String[] data1 = { "09067812345", "" };
			String[][] tableData1 = KiddaLaController.customerSearch(data1);
			for (String[] row : tableData1) {
				for (String col : row) {
					System.out.print(col + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
