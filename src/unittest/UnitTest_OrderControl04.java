package unittest;

import control.KiddaLaController;

// 単体番号４　ドライバクラス（KiddaLaControllerクラス）
public class UnitTest_OrderControl04 {

    public static void main(String[] args) {
        try {
            // 項番１
            System.out.println("--項番１----------------------------------");
            String[] data1 = {"08023456781", ""};
            String[][] tableData1 = KiddaLaController.customerSearch(data1);
            System.out.println(tableData1[0][0]);
            System.out.println(tableData1[0][1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番２
            System.out.println("--項番２----------------------------------");
            String[] data2 = {"", "ハギワラトモコ"};
            String[][] tableData2 = KiddaLaController.customerSearch(data2);
            System.out.println(tableData2[0][0]);
            System.out.println(tableData2[0][1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番３
            System.out.println("--項番３----------------------------------");
            String[] data3 = {"09087654321", "イトウハナエ"};
            String[][] tableData3 = KiddaLaController.customerSearch(data3);
            System.out.println(tableData3[0][0]);
            System.out.println(tableData3[0][1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番４
            System.out.println("--項番４----------------------------------");
            String[] data4 = {"0120441222", ""};
            String[][] tableData4 = KiddaLaController.customerSearch(data4);
            System.out.println(tableData4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番５
            System.out.println("--項番５----------------------------------");
            String[] data5 = {"", "タカタアキラ"};
            String[][] tableData5 = KiddaLaController.customerSearch(data5);
            System.out.println(tableData5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // 項番６
            System.out.println("--項番６----------------------------------");
            String[] data6 = {"", ""};
            String[][] tableData6 = KiddaLaController.customerSearch(data6);
            System.out.println(tableData6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
